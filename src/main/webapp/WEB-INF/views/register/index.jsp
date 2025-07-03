<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href = "/resources/css/common.css">
    <link rel="stylesheet" href = "/resources/css/bootstrap.css">
    <title>회원가입</title>
</head>
<body>

<%@ include file = "/WEB-INF/views/common/header.jsp" %>

<div class="main-wrapper">
    <main class="form-signin">
        <form>
            <img class="mb-4 logo-img" src="/resources/images/IF_logo.png" alt="IF Study Group 로고">
            <h1 class="h3 mb-3 fw-normal">회원가입</h1>

            <div class="form-floating">
                <input type="email" class="form-control" id="floatingInput" placeholder="이름@example.com">
                <label for="floatingInput">이름</label>
            </div>

            <div class="form-floating">
                <input type="email" class="form-control" id="floatingInput" placeholder="이름@example.com">
                <label for="floatingInput">아이디</label>
            </div>

            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" placeholder="비밀번호">
                <label for="floatingPassword">비밀번호</label>
            </div>
            <button class="btn btn-primary w-100 py-2" type="submit">완료</button>
        </form>
    </main>
</div>

<%@ include file = "/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
