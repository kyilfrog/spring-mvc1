package hello.servlet.web.frontcontroller.v1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {
	
	private Map<String, ControllerV1> controllerMap = new HashMap<>();
	
	public FrontControllerServletV1() {
		controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());           // 키/값
		controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());               // 키/값
		controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());                    // 키/값
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FrontControllerServletV1.service");
	
		// /front-controller/v1/members - 이 주소로 요청이 오면(이 키를 넣으면)
		String requestURI = request.getRequestURI();
		
		// ControllerV1 controller = MemberListControllerV1() - 생성해 놓은 객체인스턴스(값)가 반환이 된다
		ControllerV1 controller = controllerMap.get(requestURI);             // 다형성
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		controller.process(request, response);

	}

}
