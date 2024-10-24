package kr.co.greenart.web.customer.qna;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QNA {
	private Integer articleId;
	private String title;
	private String content;
	private String username;
	private String password;
	private Integer views;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Boolean secure;
	private Boolean deleted;
}
