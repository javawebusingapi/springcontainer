package com.mycompany.springcontainer.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch02FilterA implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			
		//전처리
		log.info("Filter 전처리");
		
		chain.doFilter(request, response);
		
		//후처리
		//log.info("Filter 후처리");
	}
}
