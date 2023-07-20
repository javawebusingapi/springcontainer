package com.mycompany.springcontainer.controller;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.springcontainer.dto.Ch03Dto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch03") //이 컨트롤러는 ch03이 포함이된다면 선택이 된다. 뒤의 메소드는 ch03을 빼버려도 된다.
public class Ch03Controller {
	
	@RequestMapping("/content")
	public String content() {
		log.info("ch03 content 실행");
		return "ch03/content";
	}
	
	//String으로 넘어올때 param에 값이 들어가지 않으면 null
	//String으로 주지 않고 int로 매개변수를 줬을때 null이 들어오면 예외 발생 (null 값이 나오거나, 형식에 맞지않는 값이 나오면 문제가 생긴다.)
	@GetMapping("/method1")
	public String method1(
			String param1,
			//위와 같은 문제를 해결하기 위한 방법 @RequestParam : 파라미터를 받을때 default 값을 설정시켜 null이 들어오지 않게 한다.
			@RequestParam(defaultValue="0") int param2,
			@RequestParam(defaultValue="0.0") double param3,
			@RequestParam(defaultValue="false") boolean param4,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date param5) {
		log.info("param1 : " + param1);
		log.info("param2 : " + param2);
		log.info("param3 : " + param3);
		log.info("param4 : " + param4);
		log.info("param5 : " + param5);
		
		return "redirect:/ch03/content";
	}
	
	@GetMapping("/method2")
	public String method2(
			//매개변수 명과 넘어오는 parameter의 이름이 다른경우 @RequestParam의 value에 parameter 이름을 입력하면 값이 출력된다.
			@RequestParam("param1") String arg1,
			@RequestParam(value="param2",defaultValue="0") int arg2,
			@RequestParam(defaultValue="0.0") double param3,
			@RequestParam(defaultValue="false") boolean param4,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date param5) {
		log.info("param1 : " + arg1);
		log.info("param2 : " + arg2);
		log.info("param3 : " + param3);
		log.info("param4 : " + param4);
		log.info("param5 : " + param5);
		
		return "redirect:/ch03/content";
	}
	
	@PostMapping("/method3")
	public String method3(
			//required=true가 있다면 값이 없어도 출력하는게 아닌 예외가 발생하게 된다.
			//@RequestParam(required=true) String param1,
			String param1,
			@RequestParam(defaultValue="0") int param2,
			@RequestParam(defaultValue="0.0") double param3,
			@RequestParam(defaultValue="false") boolean param4,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date param5) {
		log.info("param1 : " + param1);
		log.info("param2 : " + param2);
		log.info("param3 : " + param3);
		log.info("param4 : " + param4);
		log.info("param5 : " + param5);
		
		return "redirect:/ch03/content";
	}
	
	@RequestMapping("/method4")
	public void method4(Ch03Dto dto, HttpServletResponse response) throws Exception{
		log.info("param1: " + dto.getParam1());
		log.info("param2: " + dto.getParam2());
		log.info("param3: " + dto.getParam3());
		log.info("param4: " + dto.isParam4());
		log.info("param5: " + dto.getParam5());
		
		JSONObject root = new JSONObject();
		root.put("result", "success");
		String json = root.toString();
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter(); 
		pw.print(json);
		pw.flush();
		pw.close();
	}
	
	@RequestMapping("/method5")
	public void method5(@RequestBody Ch03Dto dto, HttpServletResponse response) throws Exception{
		log.info("param1: " + dto.getParam1());
		log.info("param2: " + dto.getParam2());
		log.info("param3: " + dto.getParam3());
		log.info("param4: " + dto.isParam4());
		log.info("param5: " + dto.getParam5());
		
		JSONObject root = new JSONObject();
		root.put("result", "success");
		String json = root.toString();
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter(); 
		pw.print(json);
		pw.flush();
		pw.close();
	}
}
