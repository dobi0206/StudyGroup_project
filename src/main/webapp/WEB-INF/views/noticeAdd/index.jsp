<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>게시글 작성</title>
    <meta name ="_csrf" content="${_csrf.token}">
    <meta name ="_csrf_header" content="${_csrf.headerName}">

    <link rel="stylesheet" type="text/css" href = "/resources/css/common.css">
    <link rel="stylesheet" type="text/css" href = "/resources/css/bootstrap.css">

</head>

<body>
    <%@ include file = "/WEB-INF/views/common/header.jsp" %>

<%--    --%>
<%--        <div id = 'noticeAdmin'>--%>
<%--            <h2 id = "noticeAdmin2">게시글 작성하기</h2>--%>
<%--            <br>--%>

<%--            --%>

<%--        </div>--%>
<%--    </div>--%>

<%--    <div class="main-wrapper">--%>
<%--        <main class="form-signin">--%>
            <!-- js로 form 태그의 action 기능 대신-->

            <form id = "noticeForm">
                <div id = "container">
                    <div id = 'noticeAdmin'>
                <!--csrf 토큰 추가-->
                <%--<input type="hidden" name="_csrf" value = "${_csrf.token}">--%>

                <img class="mb-4 logo-img" src="/resources/images/IF_logo.png" alt="IF Study Group 로고">

                <h2 id = "noticeAdmin2">게시글 작성하기</h2>
                <br>

                <div class="form-floating">
                    <input type="text" class="form-control" id="userID" name = "userID" placeholder="아이디" maxlength="20" value="${userID}" readonly>
                    <label for="floatingInput">아이디</label>
                </div>
                <br>
                <div class="form-floating">
                    <input type="text" class="form-control" id="title" name = "title" placeholder="제목" maxlength="10">
                    <label for="floatingInput">제목</label>
                </div>
                <br>
                <div class="form-floating">
                    <input type="text" class="form-control" id="content" name="Content" placeholder="내용" maxlength="60">
                    <label for="floatingInput">내용</label>
                </div>
                <br>
                <input type="hidden" id="username" name ="username" value="${username}" readonly>
                <input type="hidden" id="indate" name ="indate">

                <button class="btn btn-primary w-100 py-2" type="button" id ="buttonSubmit">확인</button>
                    </div>
                </div>
            </form>
<%--        </main>--%>
<%--    </div>--%>





    <%@ include file = "/WEB-INF/views/common/footer.jsp" %>


<script src="/resources/js/noticeAdd.js"></script>
</body>
</html>
