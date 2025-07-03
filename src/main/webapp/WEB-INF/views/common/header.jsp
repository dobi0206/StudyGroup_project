<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
   <link rel="stylesheet" href = "/resources/css/bootstrap.css">
</head>
<body>
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <div class="col-md-3 mb-2 mb-md-0" >
            <a href="${pageContext.request.contextPath}/" class="d-inline-flex link-body-emphasis text-decoration-none">
                <img src="/resources/images/IF_logo.png" alt="IF Study Group 로고" class="img-fluid navbar-logo">
            </a>
        </div>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li>
                <a href="${pageContext.request.contextPath}/" class="nav-link px-2">
                         Home
                        </a></li>
            <li>
                <a href="${pageContext.request.contextPath}/memberPage" class="nav-link px-2">
                    Member
                    </a></li>
            <li>
                <a href="${pageContext.request.contextPath}/projectPage" class="nav-link px-2">Project
                </a></li>
        </ul>

        <div class="col-md-3 text-end">
            <button type="button" class="btn btn-outline-primary me-2" onclick="location.href='${pageContext.request.contextPath}/loginPage'">로그인</button>
            <button type="button" class="btn btn-outline-primary me-2" onclick="location.href='${pageContext.request.contextPath}/registerPage'">가입하기</button>
        </div>
    </header>
</body>
</html>
