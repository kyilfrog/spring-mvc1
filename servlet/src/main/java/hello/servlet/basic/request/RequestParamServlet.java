package hello.servlet.basic.request;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[전체 파라미터 조회] - start");
		
		request.getParameterNames().asIterator().forEachRemaining(
		paramName -> System.out.println(paramName + "=" + 
		request.getParameter(paramName)));
		
		System.out.println("[전체 파라미터 조회] - end");
		System.out.println();
		
		
		System.out.println("[단일 파라미터 조회] ");
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		
		System.out.println("username = " + username);
		System.out.println("age = " + age);
		System.out.println();
		
		System.out.println("[이름이 같은 복수 파라미터 조회] ");
		String[] usernames = request.getParameterValues("username");
		for(String name : usernames) {
			System.out.println("username = " + name);
		}
		
		System.out.println();
		
		
		System.out.println("[맵으로 파라미터 조회 연습]");
		Map<String, String[]> parameterMap = request.getParameterMap();
		for(String paramName : parameterMap.keySet()) {
			String[] paramValues = parameterMap.get(paramName);
			System.out.print(paramName + "=");
			for(int i=0; i<paramValues.length; i++) {
				System.out.print(paramValues[i]);
				if(i<paramValues.length-1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
		
		
		
		response.getWriter().write("ok");
	}

	
}



















