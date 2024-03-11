package hello.servlet.web.frontcontroller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyView {

	private String viewPath;  // 예시1 "/WEB-INF/views/new-form.jsp"

	public MyView(String viewPath) {
		
		this.viewPath = viewPath;
	}
	
	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
	
	
}
