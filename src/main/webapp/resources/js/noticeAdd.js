document.getElementById("buttonSubmit").addEventListener("click", function () {
    const formData = {
        userID: document.getElementById("userID").value,
        title : document.getElementById("title").value,
        content : document.getElementById("content").value,
        username: document.getElementById("username").value,
    };

    // csrf 토큰
    const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
    const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

    fetch("/Notice/add", {  // <-- 올바른 위치
        method: "POST",
        headers:{
            "Content-Type": "application/json",
            [csrfHeader]: csrfToken
        },
        body: JSON.stringify(formData)
    })
        .then(response => {
            if(!response.ok){
                throw new Error("게시물 작성 실패");
            }
            return response.text();
        })
        .then(_ => {
            console.log("Success");
            window.location.href = "/";
        })
        .catch(error => {
            console.log("Error 발생", error);
        });
});
