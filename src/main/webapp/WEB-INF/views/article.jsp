<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 조회 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f9f9f9; /* 배경색 */
        }
        article {
            background-color: #fff; /* 게시글 배경색 */
            padding: 20px; /* 내부 여백 */
            border: 1px solid #ddd; /* 테두리 */
            border-radius: 5px; /* 모서리 둥글게 */
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
            margin-bottom: 20px; /* 게시글 간 간격 */
        }
        header {
            border-bottom: 1px solid #eee; /* 헤더 아래쪽 테두리 */
            margin-bottom: 15px; /* 헤더와 본문 간 간격 */
        }
        h3 {
            color: #333; /* 제목 색상 */
            margin: 0; /* 여백 제거 */
        }
        h4 {
            color: #777; /* 작성자 색상 */
            margin: 5px 0; /* 상하 여백 */
        }
        p {
            color: #555; /* 내용 색상 */
            line-height: 1.6; /* 줄 간격 */
        }
        footer {
            margin-top: 15px; /* 푸터와 본문 간 간격 */
            font-size: 0.9em; /* 작은 폰트 크기 */
            color: #888; /* 날짜 색상 */
        }
        button {
            padding: 7px 10px; /* 버튼 내부 여백 */
            background-color: #4CAF50; /* 버튼 배경색 */
            color: white; /* 버튼 글자색 */
            border: none; /* 버튼 테두리 없음 */
            border-radius: 4px; /* 버튼 모서리 둥글게 */
            cursor: pointer; /* 마우스 포인터가 손가락으로 바뀜 */
            text-decoration: none; /* 텍스트 장식 제거 */
            font-size: 1em; /* 폰트 크기 */
            margin-top: 20px; /* 버튼 위쪽 여백 */
            margin-right: 10px; /* 버튼 간 간격 */
        }
        button:hover {
            background-color: #45a049; /* 마우스 오버 시 버튼 배경색 변화 */
        }
        .button-group {
            margin-top: 15px; /* 버튼 그룹 위쪽 여백 */
        }
        .back-button {
            margin-bottom: 20px; /* 제목과의 간격 추가 */
        }
    </style>
</head>
<body>
    <article>
        <form action="/qna" method="get" class="back-button">
            <button type="submit">돌아가기</button>
        </form>
        <header>
            <h3>제목 : ${ qna.title }</h3>
            <h4>작성자 : ${ qna.username }</h4>
            <p>조회수 : ${ qna.views }</p>
        </header>
        <p>내용</p>
        <p>${ qna.content }</p>
        <footer>
            <p>작성일 : ${ qna.createdAt }</p>
            <div class="button-group">
                   
                    <button type="submit">수정</button>
                    <button type="submit">삭제</button>
            </div>
        </footer>
    </article>
</body>
</html>
