package com.studygroup.study_project.entity;

import org.springframework.security.core.authority.AuthorityUtils;


public class CusotmUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CusotmUser(User user){
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
    }

}
