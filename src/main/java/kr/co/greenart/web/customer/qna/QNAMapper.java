package kr.co.greenart.web.customer.qna;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.data.domain.Pageable;

import kr.co.greenart.web.util.MyOrder;

@Mapper
public interface QNAMapper {
	// 글 작성
	@Insert({ "INSERT INTO customerqna (title, content, username, password)",
			"VALUES (#{title}, #{content}, #{username}, #{password})" })
	@Options(useGeneratedKeys = true, keyProperty = "articleId")
	int save(QNA qna);

	// 모든 qna를 list 가져오기 - 일부 속성만 반환
	@Select({ "SELECT article_id, title, content, username, views, is_secure FROM customerqna",
			"ORDER BY article_id DESC", "LIMIT #{pageSize} OFFSET #{offset}" })
	@Results(id = "qnaList", value = { @Result(column = "article_id", property = "articleId"),
			@Result(column = "title", property = "title"), @Result(column = "content", property = "content"),
			@Result(column = "username", property = "username"), @Result(column = "views", property = "views"),
			@Result(column = "is_secure", property = "secure") })
	List<QNA> findAll(Pageable page);

	// 작성글 비밀글 여부
	@Select({ "SELECT article_id, title, content, username, views, is_secure FROM customerqna",
			"WHERE is_secure = false", "ORDER BY article_id DESC", "LIMIT #{limit} OFFSET #{pageSize}" })
	@ResultMap("qnaList")
	List<QNA> findBySecureIsFalse(int limit, int pageSize);

	// id로 게시글 검색 -qna모든 속성 반환
	@Select("SELECT * FROM customerqna WHERE article_id = #{articleid}")
	@Results(id = "qnaMapping", value = { @Result(column = "article_id", property = "articleId", id = true),
			@Result(column = "title", property = "title"), @Result(column = "content", property = "content"),
			@Result(column = "username", property = "username"), @Result(column = "password", property = "password"),
			@Result(column = "views", property = "views"), @Result(column = "created_at", property = "createdAt"),
			@Result(column = "updated_at", property = "updatedAt"), @Result(column = "is_secure", property = "secure"),
			@Result(column = "is_deleted", property = "deleted") })
	QNA findById(Integer articleId);

	// 조회수 증가
	@Update("UPDATE customerqna SET views = views + 1 WHERE article_id=#{articleId}")
	int updateCount(Integer articleId);

	class SQLProvider {
		public String selectOrderBy(MyOrder order) {
			return new SQL().SELECT("columns").FROM("tablename")
//					.ORDER_BY(order.get정렬방식())
					.LIMIT("리밋").OFFSET("오프셋").toString();
		}
	}

	// 5. 게시글(id)의 비밀 여부 조회 (is_secure)
	@Select("select is_secure from customerqna where article_id=#{article_id};")
	void findSecureByPk();

	// 6. views count 수정(1 증가)
//	@Update("update customerqna set views = views + 1 where article_id = #{article_id};")
//	int updateCount(int article_id);

	// 7. 글 논리 삭제(pk 및 password 일치) : is_deleted => 1로 수정
	// void? 논리 삭제는 객체 상태값 변경이라 반환값이 필요없다
//	@Update({"UPDATE customerqna SET deleted = 1",
//			"WHERE article_id = #{article_id} AND password = #{password}",
//			"AND deleted = 0;"
//			})
//	void deleteArticle(@Param("articleId") Integer articleId, 
//	                   @Param("password") String password);
	@Update("UPDATE customerqna SET deleted = 1 WHERE article_id = #{articleId} AND deleted = 0")
    void deleteArticle(Integer articleId);
	
}
