package com.mycompany.springcontainer.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	public HomeController() {
		log.info("HomeController 실행");
	}
	
	@PostConstruct //객체 생성 후 실행
	public void postConstructor1() {
		log.info("postConstructor1 실행");
	}
	@PostConstruct //객체 생성 후 실행
	public void postConstructor2() {
		log.info("postConstructor2 실행");
	}
	@PreDestroy //객체가 없어지는 시점(어플리케이션이 종료 됐을 때 실행)
	public void preDestory() {
		log.info("preDestory1 실행");
	}
	
	
	//http://localhost:8080/springwebapp
	@RequestMapping("/")
	public String home() {
		log.info("home 실행");
		return "home";
	}
}
