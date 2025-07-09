<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 수정</title>

  <meta name = "_csrf" content="${_csrf.token}">
  <meta name = "_csrf_header" content="${_csrf.headerName}">

  <link rel="stylesheet" type="text/css" href = "/resources/css/common.css">
  <link rel="stylesheet" type="text/css" href = "/resources/css/bootstrap.css">

</head>
<body>
  <%@ include file = "/WEB-INF/views/common/header.jsp" %>

    <form id = "noticeForm">
      <div id = "container">
        <div id = 'noticeAdmin'>
          <!--csrf 토큰 추가-->
          <%--<input type="hidden" name="_csrf" value = "${_csrf.token}">--%>

          <img class="mb-4 logo-img" src="/resources/images/IF_logo.png" alt="IF Study Group 로고">

          <h2 id = "noticeAdmin2">게시글 수정</h2>
          <br>


          <div class="form-floating">
            <input type="hidden" class="form-control" id="idx" name = "idx" placeholder="idx" maxlength="20" value="${notice.idx}" readonly>

            <input type="text" class="form-control" id="userID" name = "userID" placeholder="아이디" maxlength="20" value="${notice.userID}" readonly style="background-color:#e0e0e0">
            <label for="floatingInput">아이디</label>
          </div>
          <br>
          <div class="form-floating">
            <input type="text" class="form-control" id="title" name = "title" placeholder="제목" maxlength="10" value="${notice.title}">
            <label for="floatingInput">제목</label>
          </div>
          <br>
          <div class="form-floating">
            <input type="text" class="form-control" id="content" name="Content" placeholder="내용" maxlength="60" value="${notice.content}">
            <label for="floatingInput">내용</label>
          </div>
          <br>
          <input type="hidden" id="username" name ="username" value="${notice.username}" readonly>

          <c:if test = '${MANAGER==true}'>
          <button class="btn btn-outline-primary me-2" type="button" id ="buttonCheck">확인</button>
          </c:if>

        </div>
      </div>
    </form>


  <%@ include file = "/WEB-INF/views/common/footer.jsp" %>

  <!--버튼 기능만 추가-->
  <script src="/resources/js/noticeModify.js"></script>
</body>
</html>
