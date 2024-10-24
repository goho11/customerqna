package kr.co.greenart.web.customer.qna;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import kr.co.greenart.web.util.QNANotFoundException;

@ControllerAdvice(assignableTypes = QNAController.class)
public class QNAControllerAdvice {
	@ExceptionHandler(QNANotFoundException.class)
	public ModelAndView notFound(QNANotFoundException e) {
		ModelAndView mv = new ModelAndView("notFound");
		mv.setStatus(HttpStatusCode.valueOf(404));
		
		return mv;
	}
}
