package com.semi.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.semi.dto.ChBoard;
import com.semi.dto.ReviewDTO;
import com.semi.persistence.ChBoardRepository;

@Service
public class ChBoardServiceImpl implements ChBoardService {

	@Autowired
	private ChBoardRepository chBoardRepository;
	
	@Override
	public void fileProcess(MultipartHttpServletRequest mul) {
		ChBoard chboard = new ChBoard();

		chboard.setWriter(mul.getParameter("writer"));
		chboard.setTitle(mul.getParameter("title"));
		chboard.setContent(mul.getParameter("content"));
		chboard.setProductName(mul.getParameter("productName"));
		chboard.setType(mul.getParameter("type"));
		chboard.setId(mul.getParameter("id"));
		chboard.setReady(mul.getParameter("ready"));
		String productSeqString = mul.getParameter("productSeq");
		int productSeq = Integer.parseInt(productSeqString);
		chboard.setProductSeq(productSeq);
		
		MultipartFile file = mul.getFile("file");
		if (file.getSize() != 0) {
			try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = sdf.format(calendar.getTime());
			sysFileName += file.getOriginalFilename();
			chboard.setFilename(sysFileName);

			String absolutePath = IMAGE;
			File saveFile = new File(absolutePath +  File.separator + sysFileName);
			
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			chboard.setFilename("non");
		}
		chBoardRepository.save(chboard);
	}

	@Override
	public Page<ChBoard> chBoardList(Pageable pageable) {
		return chBoardRepository.findAll(pageable);
	}

	@Override
	public ChBoard chBoardView(Long seq) {
		return chBoardRepository.findById(seq).get();
	}

	@Override
	public void chboardDelete(Long seq) {
		chBoardRepository.deleteById(seq);
	}

	@Override
	public Page<ChBoard> boardSearchList(String searchKeyword, Pageable pageable) { // 검색 기능 추가
		return chBoardRepository.findByTitleContaining(searchKeyword, pageable);
	}

	@Override
	public List<ChBoard> myChBoardList(ChBoard board, String id) {
		return (List<ChBoard>) chBoardRepository.findById(id);
	}

	@Override
	public Page<ChBoard> myChBoardList(ChBoard board, String id, Pageable pageable) {
		return (Page<ChBoard>) chBoardRepository.findById(id, pageable);
	}
	
	@Override
	public void save(ChBoard board) {
		chBoardRepository.save(board);
	}

	@Override
	public Optional<ChBoard> getBoard(ChBoard board) {
		Long seq = board.getSeq();
		ChBoard chBoard = chBoardRepository.findById(seq).orElse(null);

		return Optional.ofNullable(chBoard);
	}

	@Override
	public List<ChBoard> allBoard() {

		List<ChBoard> list = chBoardRepository.findAll();

		return list;
	}
	
	@Override
	public void updateChboard(MultipartHttpServletRequest mul) {
		Long seq = Long.parseLong(mul.getParameter("seq"));

		System.out.println("seq = " + seq);
		ChBoard findBoard = chBoardRepository.findById(seq).get();
		findBoard.setTitle(mul.getParameter("title"));
		findBoard.setContent(mul.getParameter("content"));
		int findIndex = findBoard.getFilename().lastIndexOf("-");
		String saveFileName ="";
		
		MultipartFile file = mul.getFile("file");
		
		System.out.println("");
		if (!saveFileName.equals(file.getOriginalFilename())) {
			if(findBoard.getFilename().equals("non")) {
				
			}else {
				
				saveFileName = findBoard.getFilename().substring(findIndex);
			}
			try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendal = Calendar.getInstance();
			String sysFileName = sdf.format(calendal.getTime());
			sysFileName += file.getOriginalFilename();

			findBoard.setFilename(sysFileName);

			String absolutePath = IMAGE;
			File saveFile = new File(absolutePath +  File.separator + sysFileName);
	
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		chBoardRepository.save(findBoard);
	}
	
	public List<ChBoard> getBoard(int seq) {
		return chBoardRepository.findByProductSeq(seq);
	}
	
	public List<ChBoard> ChBoardId(String id){
		return chBoardRepository.findById(id);
	}
}
