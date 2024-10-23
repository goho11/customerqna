package kr.co.greenart.web;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface customerqnaMapper {
	// 2. 글 작성
	@Insert({ "insert into customerqna (title, content, username, password) ",
			"values (#{title}, #{content}, #{username}, #{password} )" })
	int insert(String title, String content, String username, String password);

	// 3. 게시글 목록(id, title, username, is_secure)
	@Select("select article_id, title, username, is_secure from customerqna;")
	void selectAll();
	
	// 3-1. 게시글 조회 시, is_secure 값이 false인 행만 조회
	@Select({"select article_id, title, username, is_secure from customerqna ",
			 "where is_secure = 0;"})
	void selectAllId();
	
	// 4. 게시글 조회(id로 검색, title, content, username)
	@Select("select title, content, username from customerqna where article_id = #{article_id};")
	void searchId();
	
	// 5. 게시글(id)의 비밀 여부 조회 (is_secure)
	@Select("select is_secure from customerqna where article_id = 0;")
	void pp();
	
	// 6. views count 수정(1 증가)
	@Update("update customerqna set views = views + 1 where article_id = #{article_id};")
	int upviews(int article_id);
	
	// 7. 7. 글 논리 삭제(pk 및 password 일치) : is_deleted => 1로 수정
	@Update("update customerqna set is_deleted = 1 where (article_id = 2) and (password = #{password});")
	void s();
	

}
