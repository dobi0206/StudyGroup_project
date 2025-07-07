<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href = "/resources/css/common.css">
    <title>project</title>
</head>
<body>
    <%@ include file = "/WEB-INF/views/common/header.jsp" %>

    <div class="main-wrapper" >
        <div class="album py-5 bg-body-tertiary">
            <div class="container" style="background-color:white" >
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

                    <div class="col">
                        <div class="card shadow-sm">
                            <img src = "/resources/images/IF_logo.png">
                            <div class="card-body">
                                <p class="card-text"> 프로젝트명 : 동아리 소개 웹 페이지 개발</p>
                                <p class="card-text"> 기간 : 2023.03 ~ 2023.07</p>
                                <p class="card-text">
                                    <a href = "https://github.com/dobi0206/StudyGroup_project">URL : https://github.com/dobi0206/StudyGroup_project</a></p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <%@ include file = "/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
