package com.semi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.semi.dto.ChBoard;

@Service
public interface ChBoardService {

   
	public static final String IMAGE="/var/lib/tomcat9/webapps/semi-0.0.1-SNAPSHOT/WEB-INF/classes/static/review";
   
   public void fileProcess(MultipartHttpServletRequest mul);
   
   public Page<ChBoard> chBoardList(Pageable pageable);
   
   public List<ChBoard> getBoard(int seq);

   public ChBoard chBoardView(Long seq);
   
   public void chboardDelete(Long seq);
   
   public Page<ChBoard> boardSearchList(String searchKeyword, Pageable pageable);
   
   public List<ChBoard> myChBoardList(ChBoard board, String id);
   
   public List<ChBoard> ChBoardId(String id);
   
   public Page<ChBoard> myChBoardList(ChBoard board, String id, Pageable pageable);
   
   public void save(ChBoard board);
   
   public void updateChboard(MultipartHttpServletRequest mul);
   
   Optional<ChBoard> getBoard(ChBoard board);
   
   public List<ChBoard> allBoard();
}