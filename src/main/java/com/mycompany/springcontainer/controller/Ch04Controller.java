package com.mycompany.springcontainer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springcontainer.dto.Ch04Dto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch04") //이 컨트롤러는 ch03이 포함이된다면 선택이 된다. 뒤의 메소드는 ch03을 빼버려도 된다.
public class Ch04Controller {
	
	@RequestMapping("/content")
	public String content() {
		log.info("ch04 content 실행");
		return "ch04/content";
	}
	
	@PostMapping("/method1")
	public String method1(Ch04Dto dto) {
		log.info("param1: " + dto.getParam1());
		log.info("param1: " + dto.getParam2());
		log.info("param1: " + dto.getParam3());
		log.info("param1: " + dto.isParam4());
		log.info("param1: " + dto.getParam5());
		
		return "redirect:/ch04/content";
	}
}
