package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

@Service
public class BoardServiceImpl implements BoardService{

	//객체생성
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardBean bb) {
		// num구해서 +1 넣기
		if(boardDAO.getMaxNum()==null) {
			bb.setNum(1);
			//답글 관련
			bb.setRe_ref(1);
		}else {
			bb.setNum(boardDAO.getMaxNum()+1);
			//답글 관련
			bb.setRe_ref(boardDAO.getMaxNum()+1);
		}
		// readcount 0 넣기
		bb.setReadcount(0);
		// date 현시스템 날짜 넣기
		bb.setDate(new Timestamp(System.currentTimeMillis()));
		//답글 관련
		bb.setRe_lev(0);
		bb.setRe_seq(0);
		
		boardDAO.insertBoard(bb);
	}
	


	@Override
	public List<BoardBean> getBoardList(PageBean pb) {
		// 시작하는 행번호 구하기 
		// int currentPage=Integer.parseInt(pageNum);
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		// int startRow= ((currentPage-1)*pageSize+1)-1;
		pb.setStartRow((pb.getCurrentPage()-1)*pb.getPageSize());
		// int endRow=currentPage*pageSize;
		pb.setEndRow(pb.getCurrentPage()*pb.getPageSize());

		return boardDAO.getBoardList(pb);
	}



	@Override
	public Integer getBoardCount() {
		return boardDAO.getBoardCount();
	}

	@Override
	public BoardBean getBoard(int num) {
		return boardDAO.getBoard(num);
	}

	@Override
	public BoardBean numCheck(BoardBean bb) {
		return boardDAO.numCheck(bb);
	}

	@Override
	public void updateBoard(BoardBean bb) {
		boardDAO.updateBoard(bb);
	}

	@Override
	public void deleteBoard(BoardBean bb) {
		boardDAO.deleteBoard(bb);
	}
	
	@Override
	public void reInsertBoard(BoardBean bb) {
		//내글 밑에 답글의 순서 재배치(아래로 이동)
		boardDAO.updateReseq(bb);
		// num구해서 +1 넣기
		bb.setNum(boardDAO.getMaxNum()+1);
		// readcount 0 넣기
		bb.setReadcount(0);
		// date 현시스템 날짜 넣기
		bb.setDate(new Timestamp(System.currentTimeMillis()));
		//답글 관련
		// re_ref그대로 사용
		// re_lev  +1
		bb.setRe_lev(bb.getRe_lev()+1);
		// re_seq +1
		bb.setRe_seq(bb.getRe_seq()+1);
		boardDAO.insertBoard(bb);
	}

}
