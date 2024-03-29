package com.semi.controller;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.semi.dto.BuyDTO;
import com.semi.dto.ChBoard;
import com.semi.dto.MemberDTO;
import com.semi.dto.QaBoard;
import com.semi.service.BuyService;
import com.semi.service.ChBoardService;

@SessionAttributes("user")
@Controller
public class ChController {

	@Autowired
	private BuyService buyService;
	
	
	@GetMapping("chMain")
    public String chMain() {
        return "/chBoard/chMain"; 
    }
	
	@Autowired
	private ChBoardService chBoardService;
	
	@GetMapping("chBoardWrite")
    public String chboardWriteForm(@ModelAttribute("user") MemberDTO user, Model model, ChBoard board) {
      
      if(user.getId() == null) {
          model.addAttribute("message", "로그인이 필요한 서비스입니다.");
           model.addAttribute("searchUrl", "login");
           
           return "/qaBoard/message";
       }
      
      List<BuyDTO> list = null;
      list = buyService.getBuyList(user.getId());

      if (list != null && !list.isEmpty()) {
          List<ChBoard> chlist = chBoardService.myChBoardList(board, user.getId());
          
          // 사용할 Iterator 생성
          Iterator<BuyDTO> iterator = list.iterator();
          
          while (iterator.hasNext()) {
              BuyDTO buyDTO = iterator.next();
              
              for (int j = 0; j < chlist.size(); j++) {
                  if (buyDTO.getSeq() == chlist.get(j).getProductSeq()) {
                      // 만약 이미 존재하는 경우 Iterator를 통해 안전하게 제거
                      iterator.remove();
                      break;  // 이미 일치하는 경우는 더 이상 검사할 필요가 없으므로 반복문 종료
                  }
              }
          }
      }
      
      if(list.isEmpty()){
          model.addAttribute("message", "구매내역이 있는 고객만 이용할 수 있습니다.");
          model.addAttribute("searchUrl", "productList");
           
           return "/qaBoard/message";
       }
      
      
      model.addAttribute("list", list);
        return "/chBoard/chBoardWrite"; 
    }
    

    @PostMapping("chWritepro")
    public String chboardWritePro(MultipartHttpServletRequest mul, Model model){
    	chBoardService.fileProcess(mul);
    	
    	model.addAttribute("message", "취소/반품 신청이 완료되었습니다.");
    	model.addAttribute("searchUrl", "chMain");
    	
        return "qaBoard/message";
    }
    
    @GetMapping("chBoardList")
    public String chBoardList(Model model, @PageableDefault(page = 0, size = 10, sort = "seq", direction = Sort.Direction.DESC) Pageable pageable, String searchKeyword) {
    	
    	
    	Page<ChBoard> list = null;
    	
    	if (searchKeyword == null) {
    	
    	list = chBoardService.chBoardList(pageable);
    	
    	} else {
    		
    		list = chBoardService.boardSearchList(searchKeyword, pageable);
    	}
    	
    	int nowPage = list.getPageable().getPageNumber() + 1; 
        int blockSize = 5;  // 페이징 블록의 크기

        int startBlock = (nowPage - 1) / blockSize * blockSize + 1;
        int endBlock = startBlock + blockSize - 1;

        int startPage = Math.max(startBlock, 1); 
        int endPage = Math.min(endBlock, list.getTotalPages()); 

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
    	
    	return "/chBoard/chBoardList";
    }
    
    @GetMapping("myChBoardList")
    public String myBoardList(@ModelAttribute("user") MemberDTO user, @PageableDefault(page = 0, size = 5, sort = "seq", direction = Sort.Direction.DESC) Pageable pageable, Model model, ChBoard board) {
    	
    	if(user.getId() == null) {
    		model.addAttribute("message", "로그인이 필요한 서비스입니다.");
        	model.addAttribute("searchUrl", "login");
        	
        	return "/qaBoard/message";
    	}
    	
    	String id = user.getId();
    	
    	Page<ChBoard> boardList = chBoardService.myChBoardList(board, id, pageable);
		
    	int nowPage = boardList.getPageable().getPageNumber() + 1; 
        int blockSize = 5;  // 페이징 블록의 크기

        int startBlock = (nowPage - 1) / blockSize * blockSize + 1;
        int endBlock = startBlock + blockSize - 1;

        int startPage = Math.max(startBlock, 1); 
        int endPage = Math.min(endBlock, boardList.getTotalPages()); 

        model.addAttribute("boardList", boardList);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
		
		return "/chBoard/myChBoardList";
    }
    
    
    @GetMapping("chBoardView")
    public String boardView(@ModelAttribute("user") MemberDTO user, Model model, Long seq, ChBoard board) {
    	
    	Optional<ChBoard> chBoardOptional = chBoardService.getBoard(board);
		if (chBoardOptional.isEmpty()) {
			model.addAttribute("message", "이미 삭제된 글입니다.");
	        model.addAttribute("searchUrl", "chMain");
	        return "/qaBoard/message";
	    } else {
    	
    	model.addAttribute("board", chBoardService.chBoardView(seq));
    	return "/chBoard/chBoardView";
	    }
    	
    }
    
    
	/*
	 * @GetMapping("/chBoardView") public String boardView(@ModelAttribute("user")
	 * MemberDTO user, Model model, Long seq, ChBoard board) {
	 * 
	 * Optional<ChBoard> chBoardOptional = chBoardService.getBoard(board); if
	 * (chBoardOptional.isEmpty()) { model.addAttribute("message", "이미 삭제된 글입니다.");
	 * model.addAttribute("searchUrl", "chMain"); return "/qaBoard/message"; } else
	 * { ChBoard chboard = chBoardService.chBoardView(seq);
	 * 
	 * if(chboard.getFilepath().endsWith("_")) { String a = "no";
	 * model.addAttribute("no",a); model.addAttribute("board",
	 * chBoardService.chBoardView(seq)); return "/chBoard/chBoardView"; }else {
	 * String a = "yes"; model.addAttribute("no",a); model.addAttribute("board",
	 * chBoardService.chBoardView(seq)); return "/chBoard/chBoardView"; }
	 * 
	 * }
	 */
    
    @GetMapping("deleteChBoard")
    public String chboardDelete(Long seq, Model model) {
    	chBoardService.chboardDelete(seq);
    	
    	model.addAttribute("message", "요청 삭제가 완료되었습니다.");
    	model.addAttribute("searchUrl", "chMain");
    	
    	return "/qaBoard/message";
    }
    
    @GetMapping("deleteChBoard2")
    public String chboardDelete2(Long seq, Model model) {
    	chBoardService.chboardDelete(seq);
    	
    	model.addAttribute("message", "요청 삭제가 완료되었습니다.");
    	model.addAttribute("searchUrl", "chBoardList");
    	
    	return "/qaBoard/message";
    }
    
    @GetMapping("modifyChBoard")
    public String chboardModify(Model model, Long seq) {
    	model.addAttribute("board", chBoardService.chBoardView(seq));
    	return "/chBoard/chBoardModify";
    }
    
    @PostMapping("updateChBoard")
    public String boardUpdate(MultipartHttpServletRequest mul, Model model){
    	chBoardService.updateChboard(mul);
    	
    	model.addAttribute("message", "취소/반품 수정이 완료되었습니다.");
    	model.addAttribute("searchUrl", "myChBoardList");
    	
    	return "/qaBoard/message";
    }
    
    
}
