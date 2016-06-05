package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns="/auth/*")
public class AuthenticalFilter implements Filter {

    public AuthenticalFilter() {
       
    }

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
		HttpSession mySession =httpReq.getSession();
		String username = (String) mySession.getAttribute("user");
		
		System.out.println("doFilter");
		
		if( mySession.getAttribute("user")==null){
			
			System.out.println("AuthenticateFilter no session");
			httpResp.sendRedirect("../login.jsp");
			
		}else{
			
			System.out.println("AuthenticateFilter found");
			chain.doFilter(request, response);
			System.out.println("good ");
		}  

	}
	
	public void destroy() {
		
	}
}
