<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href = "/resources/css/common.css">
    <link rel="stylesheet" href = "/resources/css/bootstrap.css">
    <title>로그인</title>
</head>
<body>

    <%@ include file = "/WEB-INF/views/common/header.jsp" %>

    <div class="main-wrapper">
        <main class="form-signin">

            <form action = "${pageContext.request.contextPath}/login" method = "post">

                <!--csrf 토큰 추가-->
                <input type="hidden" name="_csrf" value = "${_csrf.token}">

                <img class="mb-4 logo-img" src="/resources/images/IF_logo.png" alt="IF Study Group 로고">

                <h1 class="h3 mb-3 fw-normal">로그인</h1>

                <!-- 로그인 실패시 오류 메시지 표시 -->
                    <c:if test="${not empty param.error}">
                        <P style = "color:red;"> 아이디 또는 비밀번호가 잘못되었습니다.</P>
                    </c:if>

                <div class="form-floating">
                    <input type="text" class="form-control" id="userID" name = "userID" placeholder="아이디">
                    <label for="floatingInput">아이디</label>
                </div>

                <div class="form-floating">
                    <input type="password" class="form-control" id="password" name ="password" placeholder="비밀번호">
                    <label for="floatingPassword">비밀번호</label>
                </div>
                <button class="btn btn-primary w-100 py-2" type="submit" id = "login-button">로그인</button>
            </form>
        </main>
    </div>

    <%@ include file = "/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
