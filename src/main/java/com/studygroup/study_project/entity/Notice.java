package com.studygroup.study_project.entity;

public class Notice {

    private int idx;
    private String userID;
    private String title;
    private String content;
    private String username;
    private String indate;
    private int count;

    public Notice(){}

    public Notice(int idx, String userID, String title, String content, String username, String indate, int count) {
        this.idx = idx;
        this.userID = userID;
        this.title = title;
        this.content = content;
        this.username = username;
        this.indate = indate;
        this.count = count;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


