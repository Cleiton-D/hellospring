package br.com.cleitonkiper.testek8;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AppInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(AppInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		
		logger.info("Request URL::" + request.getRequestURL().toString()
				+ ":: Start Time=" + System.currentTimeMillis());
		
		request.setAttribute("startTime", startTime);
		
		return true;
	}


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		logger.info("Request URL::" + request.getRequestURL().toString()
				+ ":: End Time=" + System.currentTimeMillis());
		logger.info("Request URL::" + request.getRequestURL().toString()
				+ ":: Time Taken=" + (System.currentTimeMillis() - startTime));
	}
}
