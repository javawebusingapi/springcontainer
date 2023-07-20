package com.mycompany.springcontainer.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Ch01Util {
	
	public Ch01Util() {
		log.info("Util 실행");
	}
}
