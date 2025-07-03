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
            IF_Study_Group
            </a>
        </div>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li>
                <a href="#" class="nav-link px-2 link-secondary">
                    <font style="vertical-align: inherit;">
                        <font style="vertical-align: inherit;"> Home
                        </font></font></a></li>
            <li>
                <a href="/memberPage" class="nav-link px-2"><font style="vertical-align: inherit;">
                    <font style="vertical-align: inherit;">Member
                    </font></font></a></li>
            <li>
                <a href="projectPage" class="nav-link px-2"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Project
                </font></font></a></li>
        </ul>

        <div class="col-md-3 text-end">
            <button type="button" class="btn btn-outline-primary me-2"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">로그인</font></font></button>
            <button type="button" class="btn btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">가입하기</font></font></button>
        </div>
    </header>
</body>
</html>
