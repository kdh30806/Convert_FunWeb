package com.funweb.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.UploadContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;
import com.funweb.service.PictureService;
import com.funweb.service.RecipeService;

@Controller
public class PictureController {
	
	@Inject
	private PictureService pictureService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/board/picture/main", method = RequestMethod.GET)
	public String main(HttpSession session, HttpServletRequest request, Model model) {	
		
		String id = (String)session.getAttribute("id");
		String pageNum = request.getParameter("pageNum");
		PageBean pb = new PageBean();
		pb.setPageSize(4);
		if(pageNum == null) {
			pageNum = "1";
		}
		pb.setPageNum(pageNum);
		
		List<BoardBean> pictureList = pictureService.getBoardList(pb);
		
		pb.setCount(pictureService.getBoardCount());
		
		session.setAttribute("id", id);
		model.addAttribute("pictureList", pictureList);
		model.addAttribute("pb", pb);
		
		return "/board/picture/main";
	}
	
	@RequestMapping(value = "/board/picture/write", method = RequestMethod.GET)
	public String write(HttpSession session) {	
		
		String id = (String)session.getAttribute("id");
		session.setAttribute("id", id);
		
		return "/board/picture/write";
	}
	
	@RequestMapping(value = "/board/picture/write", method = RequestMethod.POST)
	public String writePost(HttpServletRequest request, MultipartFile file) throws IOException {	
//		System.out.println("@@@@@@@@@@@@@@@");
//		System.out.println("파일이름 : " + file.getOriginalFilename());
//		System.out.println("파일크기 : " + file.getSize());
//		System.out.println("파일타입 : " + file.getContentType());
		
		UUID uid = UUID.randomUUID();
		String saveName = uid.toString() + "_" + file.getOriginalFilename();
		
		File target = new File(uploadPath,saveName);
		FileCopyUtils.copy(file.getBytes(), target);
		
		BoardBean bb = new BoardBean();
		bb.setContent(request.getParameter("content"));
		bb.setFile(saveName);
		bb.setName(request.getParameter("name"));
		bb.setSubject(request.getParameter("subject"));
		
		pictureService.writeBoard(bb);
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/board/picture/content", method = RequestMethod.GET)
	public String content(HttpSession session, HttpServletRequest request, Model model) {	
		
		String id = (String)session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardBean bb = pictureService.getBoard(num);
		
		session.setAttribute("id", id);	
		model.addAttribute("bb", bb);
		return "/board/picture/content";
	}
	
	@RequestMapping(value = "/board/picture/update", method = RequestMethod.GET)
	public String update(HttpSession session, HttpServletRequest request, Model model) {	
		
		String id = (String)session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardBean bb = pictureService.getBoard(num);
		
		session.setAttribute("id", id);	
		model.addAttribute("bb", bb);
		return "/board/picture/update";
	}
	
	@RequestMapping(value = "/board/picture/update", method = RequestMethod.POST)
	public String updatePost(BoardBean bb) {	
		
		pictureService.updateBoard(bb);
	
		return "redirect:/board/recipe/main";
	}
	
	@RequestMapping(value = "/board/picture/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {	
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		pictureService.deleteBoard(num);

		return "redirect:/board/picture/main";
	}

}
