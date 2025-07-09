// DOM 체 연결(html 혹은 jsp 파일 안에 있는 태그들을 자바스크립트와 연결시키는 과정) 객
const container = document.getElementById("container");
const noticeAdmin = document.getElementById("noticeAdmin");
const noticeList = document.getElementById("noticeList");

//CSRF 토큰과 헤더이름 가져오기
const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

// 데이터를 조회할 때 사용할 기능 정의
function fetchNotices(){
    fetch("/Notice/all").then(response => response.json())
        .then(notices=>{
            noticeList.innerHTML = ""; // 기존 메뉴 목록 초기화
            notices.forEach(notice=>{
                const noticeItem = document.createElement("div");
                noticeItem.className="notice-item";
                noticeItem.innerHTML = `
                <a href = "#" class = "notice-link" style="text-decoration: none; color:black;">
                    <h3>${notice.title}</h3>
                    <p>${notice.content}</p>
                    <small>작성자:${notice.userID}. 작성일:${notice.indate}, 조회수:${notice.count}</small>
                    </a> 
                    <br>
                    <br>
                `
                noticeItem.querySelector(".notice-link").addEventListener('click',(event)=>{
                    event.preventDefault();
                    console.log(`event:${event}`);
                    incrementCount(notice.idx).then(()=>window.location.href=`/noticeCheckPage?idx=${notice.idx}`)
                });
                noticeList.appendChild(noticeItem);
            })
        })

}

function incrementCount(idx){
    return fetch(`/Notice/count/${idx}`, {
        method:"PUT",
        headers:{
            [csrfHeader]:csrfToken
        }
    }).then(response=>{
        if(!response.ok){
            console.log("데이터 전송 실패");
        }
    }).catch(error=>{
        console.log(`Error: ${error}`);
    })
}

window.addEventListener("load",fetchNotices);