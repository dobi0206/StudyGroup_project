// DOM 체 연결(html 혹은 jsp 파일 안에 있는 태그들을 자바스크립트와 연결시키는 과정) 객
const container = document.getElementById("container");
const menuAdmin = document.getElementById("noticeAdmin");
const noticeList = document.getElementById("noticeList");

//CSRF 토큰과 헤더이름 가져오기
const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

