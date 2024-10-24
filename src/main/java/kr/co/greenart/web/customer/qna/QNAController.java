package kr.co.greenart.web.customer.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QNAController {
	@Autowired
	private QNAService service;
	
	//  사용자가 view를 조작할 때 명령 - model값 반환
	 @GetMapping("/qna")
	    public String qna(@RequestParam(defaultValue = "10") int pageSize,
	                      @RequestParam(defaultValue = "0") int offset,
	                      Model model) 
	 	{
	        List<QNA> qnaList = service.findAll(pageSize, offset);
	        model.addAttribute("qnaList", qnaList);
	        
	        System.out.println(qnaList + "출력확인");
	        return "qna"; // JSP 파일 이름
	    }

	@GetMapping("/qna/{id}")
	public String readArticle(@PathVariable Integer id, Model model) {
		QNA qna = service.findById(id);
		
		model.addAttribute("qna", qna);
		
		return  "article";
	}
}
