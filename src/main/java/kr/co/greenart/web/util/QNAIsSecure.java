package kr.co.greenart.web.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "비밀글입니다")
public class QNAIsSecure extends RuntimeException {
	private Integer articleId;

	public QNAIsSecure(Integer articleId) {
		super();
		this.articleId = articleId;
	}
}
