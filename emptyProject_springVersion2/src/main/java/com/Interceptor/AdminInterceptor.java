package com.Interceptor;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dto.Login;
import com.dto.Member;


public class AdminInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if(member == null || member.getUserid().equals("admin") == false ) {
			System.out.println("접근 불가");
/*			RequestDispatcher dis = request.getRequestDispatcher("/app/WEB-INF/views/loginForm");
			dis.forward(request, response);*/
			response.sendRedirect("/app/WEB-INF/views/loginForm");
			return false;			
		}else if(member.getUserid().equals("admin")) {
			System.out.println("관리자 접속 "+member.getUserid());
			return true;
		}
		return true;
	}
}
