package kr.co.greenart.web.customer.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class QNAController {
	@Autowired
	private QNAService service;

	@GetMapping("/qna")
	public String qna(@PageableDefault(size = 10) Pageable page, Model model) {
		// 페이지 정보를 로그에 기록
		log.info("size=" + page.getPageSize());
		log.info("page=" + page.getPageNumber());
		log.info("offset: " + page.getOffset());
		log.info("sort: " + page.getSort());

		List<QNA> qnaList = service.findAll(page);
		model.addAttribute("qnaList", qnaList);

		return "qna";
	}

	@GetMapping("/qna/{id}")
	public String readArticle(@PathVariable Integer id, Model model) {
		QNA qna = service.findById(id);

		model.addAttribute("qna", qna);

		return "article";
	}

	@GetMapping("/write")
	public String writeForm() {
		return "/write"; // 글 작성 페이지 반환
	}

	@PostMapping("/write")
	public String writeQNA(QNA qna) {
		service.save(qna);

		System.out.println(qna + " 전송 확인");

		return "redirect:/qna"; // 저장 후 Q&A 목록 페이지로 리다이렉트
	}

}
