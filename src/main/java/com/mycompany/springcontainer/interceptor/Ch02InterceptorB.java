package com.mycompany.springcontainer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springcontainer.interceptor.Auth.Role;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch02InterceptorB implements HandlerInterceptor{
	//전처리 할 때 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("Interceptor ADMIN 전처리 실행");
		
		//요청 처리 메소드가 @Auth가 붙어있는지 확인
		HandlerMethod hm = (HandlerMethod) handler;
		Auth auth = hm.getMethodAnnotation(Auth.class);
		if(auth == null) {
			//Auth 어노테이션이 안붙어 있는 경우(USER)
			return true;
		} else {
			//Auth 어노테이션이 붙어있는 경우(ADMIN 여부는 모름)
			
				
			if(auth.value() == Role.ADMIN) {
				//Auth 어노테이션이 ADMIN 권한을 가지고 있는지 검사후 맞다면 ~
				boolean isAdmin = false;
				if(isAdmin) {
					return true;
				} else {
					//Auth 어노테이션이 ADMIN 권한을 가지고 있는지 검사후 아니라면~
					log.info("관리자 권한이 필요하다");
					response.sendRedirect(request.getContextPath());
				}
			} else {
				return true;
			}
		}
		return true;
	}
	
	//후처리 할 떄 실행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//log.info("Intetceptor 후처리 실행");
	}
	
	
	//응답이 바로 가기 직전에 실행(JSP까지 다 실행)
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//log.info("Intetceptor 응답 직전");
	}
}
