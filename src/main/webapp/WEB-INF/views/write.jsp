<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 작성</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    label {
        display: block; /* 레이블을 블록 요소로 설정하여 줄 바꿈 */
        margin-bottom: 5px; /* 레이블과 입력 요소 간의 간격 */
    }
    input[type="text"],
    input[type="password"],
    textarea {
        width: 100%; /* 입력 요소의 폭을 100%로 설정 */
        padding: 10px; /* 내부 여백 추가 */
        margin-bottom: 15px; /* 각 입력 요소 간의 간격 */
        border: 1px solid #ccc; /* 테두리 스타일 */
        border-radius: 4px; /* 모서리 둥글게 */
    }
    button {
        padding: 10px 15px; /* 버튼 내부 여백 */
        background-color: #4CAF50; /* 버튼 배경색 */
        color: white; /* 버튼 글자색 */
        border: none; /* 버튼 테두리 없음 */
        border-radius: 4px; /* 버튼 모서리 둥글게 */
        cursor: pointer; /* 마우스 포인터가 손가락으로 바뀜 */
    }
    button:hover {
        background-color: #45a049; /* 마우스 오버 시 버튼 배경색 변화 */
    }
</style>
</head>
<body>
    <h1>문의 하기</h1>
    <form action="/write" method="post">
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" required>

        <label for="content">내용:</label>
        <textarea id="content" name="content" required></textarea>

        <label for="username">사용자 이름:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">등록</button>
    </form>
</body>
</html>
