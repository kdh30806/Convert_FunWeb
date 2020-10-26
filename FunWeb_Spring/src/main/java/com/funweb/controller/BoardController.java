package com.funweb.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;
import com.funweb.service.BoardService;

@Controller
public class BoardController {

	@Inject
	private BoardService boardService;

	@Resource(name = "uploadPath")
	private String uploadPath;

//==========================================notic=============================================	

	@RequestMapping(value = "/board/notice/main", method = RequestMethod.GET)
	public String noticeMain(HttpSession session, HttpServletRequest request, Model model) {

		String id = (String) session.getAttribute("id");
		String pageNum = request.getParameter("pageNum");
		String category = "notice";
		PageBean pb = new PageBean();
		pb.setPageSize(10);
		if (pageNum == null) {
			pageNum = "1";
		}
		pb.setPageNum(pageNum);
		pb.setCategory(category);
		List<BoardBean> noticeList = boardService.getBoardList(pb);

		pb.setCount(boardService.getBoardCount(category));

		session.setAttribute("id", id);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pb", pb);

		return "/board/notice/main";
	}

	@RequestMapping(value = "/board/notice/write", method = RequestMethod.GET)
	public String noticeWrite(HttpSession session) {

		String id = (String) session.getAttribute("id");
		session.setAttribute("id", id);

		return "/board/notice/write";
	}

	@RequestMapping(value = "/board/notice/write", method = RequestMethod.POST)
	public String noticeWritePost(BoardBean bb) {

		bb.setCategory("notice");
		boardService.writeBoard(bb);

		return "redirect:/main";
	}

	@RequestMapping(value = "/board/notice/content", method = RequestMethod.GET)
	public String noticeContent(HttpSession session, HttpServletRequest request, Model model) {

		String id = (String) session.getAttribute("id");
		BoardBean bb = new BoardBean();
		bb.setNum(Integer.parseInt(request.getParameter("num")));
		bb.setCategory("notice");
		
		boardService.updateReadCount(bb);
		BoardBean bb2 = boardService.getBoard(bb);

		session.setAttribute("id", id);
		model.addAttribute("bb", bb2);
		return "/board/notice/content";
	}

	@RequestMapping(value = "/board/notice/update", method = RequestMethod.GET)
	public String noticeUpdate(HttpSession session, HttpServletRequest request, Model model) {

		String id = (String) session.getAttribute("id");
		BoardBean bb = new BoardBean();
		bb.setNum(Integer.parseInt(request.getParameter("num")));
		bb.setCategory("notice");
		BoardBean bb2 = boardService.getBoard(bb);

		session.setAttribute("id", id);
		model.addAttribute("bb", bb2);
		return "/board/notice/update";
	}

	@RequestMapping(value = "/board/notice/update", method = RequestMethod.POST)
	public String noticeUpdatePost(BoardBean bb) {

		bb.setCategory("notice");
		boardService.updateBoard(bb);

		return "redirect:/board/notice/main";
	}

	@RequestMapping(value = "/board/notice/delete", method = RequestMethod.GET)
	public String noticeDelete(HttpServletRequest request) {

		BoardBean bb = new BoardBean();
		bb.setNum(Integer.parseInt(request.getParameter("num")));
		bb.setCategory("notice");

		boardService.deleteBoard(bb);

		return "redirect:/board/notice/main";
	}

//===============================================================================================
//==========================================recipe===============================================	

	@RequestMapping(value = "/board/recipe/main", method = RequestMethod.GET)
	public String recipeMain(HttpSession session, HttpServletRequest request, Model model) {

		String id = (String) session.getAttribute("id");
		String pageNum = request.getParameter("pageNum");
		String category = "recipe";
		PageBean pb = new PageBean();
		pb.setPageSize(10);
		if (pageNum == null) {
			pageNum = "1";
		}
		pb.setPageNum(pageNum);
		pb.setCategory(category);
		List<BoardBean> recipeList = boardService.getBoardList(pb);

		pb.setCount(boardService.getBoardCount(category));

		session.setAttribute("id", id);
		model.addAttribute("recipeList", recipeList);
		model.addAttribute("pb", pb);

		return "/board/recipe/main";
	}

	@RequestMapping(value = "/board/recipe/write", method = RequestMethod.GET)
	public String recipeWrite(HttpSession session) {

		String id = (String) session.getAttribute("id");
		session.setAttribute("id", id);

		return "/board/recipe/write";
	}

	@RequestMapping(value = "/board/recipe/write", method = RequestMethod.POST)
	public String recipeWritePost(BoardBean bb) {

		bb.setCategory("recipe");
		boardService.writeBoard(bb);

		return "redirect:/main";
	}

	@RequestMapping(value = "/board/recipe/content", method = RequestMethod.GET)
	public String recipeContent(HttpSession session, HttpServletRequest request, Model model) {

		String id = (String) session.getAttribute("id");
		BoardBean bb = new BoardBean();
		bb.setNum(Integer.parseInt(request.getParameter("num")));
		bb.setCategory("recipe");
		
		boardService.updateReadCount(bb);
		BoardBean bb2 = boardService.getBoard(bb);
		
		session.setAttribute("id", id);
		model.addAttribute("bb", bb2);
		return "/board/recipe/content";
	}

	@RequestMapping(value = "/board/recipe/update", method = RequestMethod.GET)
	public String recipeUpdate(HttpSession session, HttpServletRequest request, Model model) {

		String id = (String) session.getAttribute("id");
		BoardBean bb = new BoardBean();
		bb.setNum(Integer.parseInt(request.getParameter("num")));
		bb.setCategory("recipe");

		BoardBean bb2 = boardService.getBoard(bb);

		session.setAttribute("id", id);
		model.addAttribute("bb", bb2);
		return "/board/recipe/update";
	}

	@RequestMapping(value = "/board/recipe/update", method = RequestMethod.POST)
	public String recipeUpdatePost(BoardBean bb) {

		bb.setCategory("recipe");
		boardService.updateBoard(bb);

		return "redirect:/board/recipe/main";
	}

	@RequestMapping(value = "/board/recipe/delete", method = RequestMethod.GET)
	public String recipeDelete(HttpServletRequest request) {

		BoardBean bb = new BoardBean();
		bb.setNum(Integer.parseInt(request.getParameter("num")));
		bb.setCategory("recipe");
		boardService.deleteBoard(bb);

		return "redirect:/board/recipe/main";
	}

//===============================================================================================
//==========================================picture===============================================	

	@RequestMapping(value = "/board/picture/main", method = RequestMethod.GET)
	public String pictureMain(HttpSession session, HttpServletRequest request, Model model) {

		String id = (String) session.getAttribute("id");
		String pageNum = request.getParameter("pageNum");
		String category = "picture";
		PageBean pb = new PageBean();
		pb.setPageSize(4);
		if (pageNum == null) {
			pageNum = "1";
		}
		pb.setPageNum(pageNum);
		pb.setCategory(category);
		List<BoardBean> pictureList = boardService.getBoardList(pb);

		pb.setCount(boardService.getBoardCount(category));

		session.setAttribute("id", id);
		model.addAttribute("pictureList", pictureList);
		model.addAttribute("pb", pb);

		return "/board/picture/main";
	}

	@RequestMapping(value = "/board/picture/write", method = RequestMethod.GET)
	public String pictureWrite(HttpSession session) {

		String id = (String) session.getAttribute("id");
		session.setAttribute("id", id);

		return "/board/picture/write";
	}

	@RequestMapping(value = "/board/picture/write", method = RequestMethod.POST)
	public String pictureWritePost(HttpServletRequest request, MultipartFile file) throws IOException {
//		System.out.println("@@@@@@@@@@@@@@@");
//		System.out.println("파일이름 : " + file.getOriginalFilename());
//		System.out.println("파일크기 : " + file.getSize());
//		System.out.println("파일타입 : " + file.getContentType());
		String category = "picture";

		UUID uid = UUID.randomUUID();
		String saveName = uid.toString() + "_" + file.getOriginalFilename();

		File target = new File(uploadPath, saveName);
		FileCopyUtils.copy(file.getBytes(), target);

		BoardBean bb = new BoardBean();
		bb.setCategory(category);
		bb.setContent(request.getParameter("content"));
		bb.setFile(saveName);
		bb.setName(request.getParameter("name"));
		bb.setSubject(request.getParameter("subject"));

		boardService.writeBoard(bb);

		return "redirect:/main";
	}

	@RequestMapping(value = "/board/picture/content", method = RequestMethod.GET)
	public String pictureContent(HttpSession session, HttpServletRequest request, Model model) {

		String id = (String) session.getAttribute("id");
		BoardBean bb = new BoardBean();
		bb.setNum(Integer.parseInt(request.getParameter("num")));
		bb.setCategory("picture");

		boardService.updateReadCount(bb);
		BoardBean bb2 = boardService.getBoard(bb);

		session.setAttribute("id", id);
		model.addAttribute("bb", bb2);
		return "/board/picture/content";
	}

	@RequestMapping(value = "/board/picture/update", method = RequestMethod.GET)
	public String pictureUpdate(HttpSession session, HttpServletRequest request, Model model) {

		String id = (String) session.getAttribute("id");
		BoardBean bb = new BoardBean();
		bb.setNum(Integer.parseInt(request.getParameter("num")));
		bb.setCategory("picture");
		BoardBean bb2 = boardService.getBoard(bb);

		session.setAttribute("id", id);
		model.addAttribute("bb", bb2);
		return "/board/picture/update";
	}

	@RequestMapping(value = "/board/picture/update", method = RequestMethod.POST)
	public String pictureUpdatePost(MultipartFile file, HttpServletRequest request) throws IOException {

		String category = "picture";
		UUID uid = UUID.randomUUID();
		String saveName = uid.toString() + "_" + file.getOriginalFilename();

		File target = new File(uploadPath, saveName);
		FileCopyUtils.copy(file.getBytes(), target);

		BoardBean bb = new BoardBean();
		bb.setCategory(category);
		bb.setNum(Integer.parseInt(request.getParameter("num")));
		bb.setContent(request.getParameter("content"));
		bb.setFile(saveName);
		bb.setName(request.getParameter("name"));
		bb.setSubject(request.getParameter("subject"));
		boardService.updateBoard(bb);

		return "redirect:/board/picture/main";
	}

	@RequestMapping(value = "/board/picture/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {

		BoardBean bb = new BoardBean();
		bb.setNum(Integer.parseInt(request.getParameter("num")));
		bb.setCategory("picture");

		boardService.deleteBoard(bb);

		return "redirect:/board/picture/main";
	}

}
