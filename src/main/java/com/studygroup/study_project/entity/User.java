package com.studygroup.study_project.entity;

public class User {

    private int idx;
    private String username;
    private String userID;
    private String password;
    private Role role;

    public User(){}

    public User(int idx, String username, String password, String userID, Role role) {
        this.idx = idx;
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.role = role;
    }


    // getter & setter는 Lombok 대체 가능 -> 사용 방법 찾아보기 -> (@Lombok) 작성하면 자동으로 생성된다.
    
    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
