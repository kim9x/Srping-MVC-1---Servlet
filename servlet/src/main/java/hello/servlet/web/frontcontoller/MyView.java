package hello.servlet.web.frontcontoller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import com.fasterxml.jackson.annotation.JacksonInject.Value;

public class MyView {
	
	private String viewPath;

	public MyView(String viewPath) {
		this.viewPath = viewPath;
	}
	
	public void render(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}

	 public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modelToRequestAttribute(model, request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}

	private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
		model.forEach((key, value) -> request.setAttribute(key, response));
	}

}