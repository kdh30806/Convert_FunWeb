package com.itwillbs.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.service.BoardService;

@Controller
public class BoardController {
	// 객체생성
	@Inject
	private BoardService boardService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	//  http://localhost:8080/myweb2/board/write
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write() {
		//   /WEB-INF/views/board/writeForm.jsp
		return "board/writeForm";
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String writePost(BoardBean bb) {
		boardService.insertBoard(bb);
		//   /list 가상주소 이동
		return "redirect:/board/list";
	}
	
//  http://localhost:8080/myweb2/board/list
//  http://localhost:8080/myweb2/board/list?pageNum=2
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(Model model,HttpServletRequest request) {
		PageBean pb=new PageBean();
		// 한페이지에 보여줄 글개수 설정
		pb.setPageSize(3);
		// pageNum 파라미터 가져오기
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		pb.setPageNum(pageNum);
		
		List<BoardBean> boardList=boardService.getBoardList(pb);
		
		// getBoardCount() 전체글 개수 구하기=> 페이징 관련계산
		pb.setCount(boardService.getBoardCount());
				
		//데이터 저장 이동
		model.addAttribute("boardList",boardList);
		model.addAttribute("pb",pb);
		//   /WEB-INF/views/board/list.jsp
		return "board/list";
	}
	
	//  http://localhost:8080/myweb2/board/content?num=${bb.num}
	@RequestMapping(value = "/board/content", method = RequestMethod.GET)
	public String content(Model model,HttpServletRequest request) {
		// num 파라미터 가져오기
		int num=Integer.parseInt(request.getParameter("num"));
		
		BoardBean bb=boardService.getBoard(num);
				
		//데이터 저장 이동
		model.addAttribute("bb",bb);
		//   /WEB-INF/views/board/content.jsp
		return "board/content";
	}
	
	// http://localhost:8080/myweb2/board/update?num=${bb.num }
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String update(Model model,HttpServletRequest request) {
		// num 파라미터 가져오기
		int num=Integer.parseInt(request.getParameter("num"));
		
		BoardBean bb=boardService.getBoard(num);
				
		//데이터 저장 이동
		model.addAttribute("bb",bb);
		//   /WEB-INF/views/board/updateForm.jsp
		return "board/updateForm";
	}
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String updatePost(BoardBean bb,Model model) {
		
		BoardBean bb2=boardService.numCheck(bb);
		if(bb2!=null) {
			boardService.updateBoard(bb);
		    //   가상주소 /board/list
			return "redirect:/board/list";
		}else {
			// "num 비밀번호 틀림"
			model.addAttribute("msg","입력하신 내용 틀립니다.");
			//   /WEB-INF/views/board/msg.jsp
			return "board/msg";
		}
	}
	
	// http://localhost:8080/myweb2/board/delete?num=${bb.num }
		@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
		public String delete(Model model,HttpServletRequest request) {
			// num 파라미터 가져오기
			int num=Integer.parseInt(request.getParameter("num"));
			
			BoardBean bb=boardService.getBoard(num);
					
			//데이터 저장 이동
			model.addAttribute("bb",bb);
			//   /WEB-INF/views/board/deleteForm.jsp
			return "board/deleteForm";
		}
		@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
		public String deletePost(BoardBean bb,Model model) {
			
			BoardBean bb2=boardService.numCheck(bb);
			if(bb2!=null) {
				boardService.deleteBoard(bb);
			    //   가상주소 /board/list
				return "redirect:/board/list";
			}else {
				// "num 비밀번호 틀림"
				model.addAttribute("msg","입력하신 내용 틀립니다.");
				//   /WEB-INF/views/board/msg.jsp
				return "board/msg";
			}
		}
		
	// http://localhost:8080/myweb2/board/reWrite?num=${bb.num }&re_ref=${bb.re_ref }&re_lev=${bb.re_lev }&re_seq=${bb.re_seq }
		@RequestMapping(value = "/board/reWrite", method = RequestMethod.GET)
		public String reWrite(Model model,HttpServletRequest request) {
			// BoardBean bb 객체생성
			BoardBean bb=new BoardBean();
			// 멤버변수 <- 파라미터 가져와서 저장
			bb.setNum(Integer.parseInt(request.getParameter("num")));
			bb.setRe_ref(Integer.parseInt(request.getParameter("re_ref")));
			bb.setRe_lev(Integer.parseInt(request.getParameter("re_lev")));
			bb.setRe_seq(Integer.parseInt(request.getParameter("re_seq")));
			
			model.addAttribute("bb",bb);
			//   /WEB-INF/views/board/reWriteForm.jsp
			return "board/reWriteForm";
		}
		
		@RequestMapping(value = "/board/reWrite", method = RequestMethod.POST)
		public String reWritePost(BoardBean bb) {
			boardService.reInsertBoard(bb);
			//   /list 가상주소 이동
			return "redirect:/board/list";
		}
		
		@RequestMapping(value = "/board/fwrite", method = RequestMethod.GET)
		public String fwrite() {
			//   /WEB-INF/views/board/fwriteForm.jsp
			return "board/fwriteForm";
		}
		
		@RequestMapping(value = "/board/fwrite", method = RequestMethod.POST)
		public String fwritePost(HttpServletRequest request, MultipartFile file) throws IOException {
			//파일
			System.out.println("파일이름 : " + file.getOriginalFilename());
			System.out.println("파일크기 : " + file.getSize());
			System.out.println("파일타입 : " + file.getContentType());
			// file.getBytes(); : 실제파일
			// 파일이름이 동일할 수 있으니 랜덤파일이름변경_파일이름
			
			UUID uid = UUID.randomUUID();
			String saveName = uid.toString() + "_" + file.getOriginalFilename();
			
			File target = new File(uploadPath,saveName);
			FileCopyUtils.copy(file.getBytes(), target);
//			boardService.insertBoard(bb);
			
			BoardBean bb = new BoardBean();
			bb.setContent(request.getParameter("content"));
			bb.setFile(saveName);
			bb.setName(request.getParameter("name"));
			bb.setPass(request.getParameter("pass"));
			bb.setSubject(request.getParameter("subject"));
			
			boardService.insertBoard(bb);
			//   /list 가상주소 이동
			return "redirect:/board/list";
		}
}
