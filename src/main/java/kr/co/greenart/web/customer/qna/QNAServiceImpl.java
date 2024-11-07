package kr.co.greenart.web.customer.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
	public List<QNA> findAll(Pageable page) {
		List<QNA> all = mapper.findAll(page);
		return all;
	}

	@Override
	@Transactional
	public QNA save(QNA qna) {
		mapper.save(qna);

		return qna;
	}

	@Override
	@Transactional
	public boolean deleteArticle(Integer articleId, String password) {
	    // 게시글을 조회합니다.
	    QNA qna = mapper.findById(articleId);

	    // 게시글이 존재하지 않으면 null 반환
	    if (qna == null) {
	        throw new QNANotFoundException(articleId);
	    }

	    // 비밀번호가 일치하는지 확인하고, 삭제되지 않은 경우 삭제
	    if (qna.getPassword().equals(password) && !qna.getDeleted()) {

	    	mapper.deleteArticle(articleId);
	        return true; 
	    } else {
	        return false; 
	    }
	}

}