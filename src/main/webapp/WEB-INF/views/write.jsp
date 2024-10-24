<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
</head>
<body>
    <h2>글 작성</h2>
    <form action="/qna/write" method="post">
        <label for="title">제목:</label><br>
        <input type="text" id="title" name="title" required><br><br>
        <label for="username">작성자:</label><br>
        <input type="text" id="username" name="username" required><br><br>
        <label for="content">내용:</label><br>
        <textarea id="content" name="content" required></textarea><br><br>
        <input type="submit" value="작성">
    </form>
    <br>
    <a href="/qna">목록으로 돌아가기</a>
</body>
</html>