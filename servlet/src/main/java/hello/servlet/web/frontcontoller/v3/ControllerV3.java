package hello.servlet.web.frontcontoller.v3;

import java.util.Map;

import hello.servlet.web.frontcontoller.ModelView;

public interface ControllerV3 {
	
	ModelView process(Map<String, String> paramMap);

}
