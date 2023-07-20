package com.mycompany.springcontainer.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch01MemberService {
	
	public Ch01MemberService() {
		log.info("Service 생성자 실행");
	}
}
