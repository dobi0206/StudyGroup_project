<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

    <meta name = "_csrf" content=""${_csrf.token}">
    <meta name = "_csrf_header" content="${_csrf.headerName}">

    <link rel="stylesheet" href = "/resources/css/common.css">
    <link rel="stylesheet" href = "/resources/css/bootstrap.css">

</head>
<body>

    <%@ include file = "/WEB-INF/views/common/header.jsp" %>

    <div id = "container">
        <div id = 'noticeAdmin'>
            <h2 id = "noticeAdmin2">게시글</h2>
            <br>

            <c:if test = "${MANAGER == true}">
                <button type="button" class="btn btn-outline-primary me-2" onclick="location.href='${pageContext.request.contextPath}/noticeAdd'">게시글 작성</button>
            </c:if>

            <div id ="noticeList">

            </div>
        </div>
    </div>

    <%@ include file = "/WEB-INF/views/common/footer.jsp" %>
<script type="text/javascript" src = "${pageContext.request.contextPath}/resources/js/script.js"></script>
    <!-- js 파일 연동 , JSP에서 절대경로를 왜 권장하지 않는지 찾아보기. -->
</body>
</html>
