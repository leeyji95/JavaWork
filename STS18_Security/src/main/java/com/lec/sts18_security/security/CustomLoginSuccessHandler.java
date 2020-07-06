package com.lec.sts18_security.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override // onAuthenticationSuccess 의미 : 일단 로그인은 성공했다. 
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		System.out.println("Login Success");
		
		// Authentication 객체를 이용해서 사용자가 가진 모든 권한을 문자열로 체크 가능
		
		List<String> roleNames = new ArrayList<String>();
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority()); /* Authentication에 있는 모든 권한을 리스트에 담는다. */
		});
		
		System.out.println("ROLE NAMES : " + roleNames);
		
		// 로그인 한 사용자가 ROLE_ADMIN  권한을 가졌다면 로그인 후 곧바로 /sample/admin  으로 이동
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect(request.getContextPath() + "/sample/admin");
			return;
		}  
		
		// 아니면 /sample/member 로 이동 
		if(roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect(request.getContextPath() + "/sample/member");
			return;
		}
		
		// 이것도 저것도 아니면  여기로 가겠다.
		response.sendRedirect(request.getContextPath());
		
		
		
		// 이 클래스의 빈객체 컨텍스트에 만들어주기 !
		
	}

	
	
}
