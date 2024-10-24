package kr.co.greenart.web.customer.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.greenart.web.util.QNAIsSecure;
import kr.co.greenart.web.util.QNANotFoundException;

@Service
public class QNAServiceImpl implements QNAService {
	@Autowired
	private QNAMapper mapper;

	@Override
	@Transactional
	public QNA findById(Integer articleId) {
		QNA qna = mapper.findById(articleId);

		// 주소 에러 - 예외 발생
		if (qna == null) {
			throw new QNANotFoundException(articleId);
		}

		// 비밀글 여부 - 예외 발생
		if (qna.getSecure()) {
			throw new QNAIsSecure(articleId);
		}

		// 조회수 증가
		int rows = mapper.updateCount(articleId);
		if (rows == 1) {
			qna.setViews(qna.getViews() + 1);
		}

		return qna;
	}

	@Override
	@Transactional
	public List<QNA> findAll(int pageSize, int offset) {
		List<QNA> all = mapper.findAll(pageSize, offset);
		return all;
	}
}