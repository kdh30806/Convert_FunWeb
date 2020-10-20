package com.funweb.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.funweb.service.MainService;

@Controller
public class MainController {
	
	@Inject
	private MainService mainService;
	
	

}
