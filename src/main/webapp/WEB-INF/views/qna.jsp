<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A 게시판</title>
<style>
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px; /* 테이블 위쪽 여백 추가 */
    }
    th, td {
        border: 1px solid #ddd;
        padding: 8px;
    }
    th {
        background-color: #f2f2f2;
        text-align: left;
    }
    .btn {
        padding: 10px 15px;
        margin-bottom: 20px; /* 버튼 아래 여백 */
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        text-decoration: none;
    }
</style>
</head>
<body>
<h2>Q&A 게시판</h2>
<a href="/write" class="btn">문의작성</a>
<table>
    <thead>
        <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성자</th>
            <th>보안 여부</th>
            <th>조회수</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach var="qna" items="${qnaList}">        
            <tr>
                <td>${qna.articleId}</td>
                <td><a href="/qna/${qna.articleId}">${qna.title}</a></td>
                <td>${qna.content}</td>
                <td>${qna.username}</td>
                <td>${qna.secure ? '예' : '아니오'}</td>
                <td>${qna.views}</td>
            </tr>
       	</c:forEach>
    </tbody>
</table>
</body>
</html>
