package com.mycompany.springcontainer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@RequestMapping("/") 
	public String index() {
		log.info("실행");
		log.info("실행2");
		return "index";
	}
}
