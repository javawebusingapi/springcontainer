package com.mycompany.springcontainer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch01") //이 컨트롤러는 ch01이 포함이된다면 선택이 된다. 뒤의 메소드는 ch01을 빼버려도 된다.
public class Ch01Controller {
	//@Slf4j를 쓰지 않는 경우
	//private static final Logger log = LoggerFactory.getILoggerFactory(Ch01Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		log.info("ch01 content 실행");
		return "ch01/content";
	}
	
	@RequestMapping("/button1")
	public String button1() {
		log.info("ch01 button1 누름");
		return "ch01/content";
	}
	
	@RequestMapping("/button2")
	public String button2() {
		log.info("ch01 button2 누름");
		//redirect: 재요청되는 RequestMapping
		return "redirect:/ch01/content";
	}
}
