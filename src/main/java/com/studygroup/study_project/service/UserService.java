package com.studygroup.study_project.service;


import com.studygroup.study_project.entity.User;
import com.studygroup.study_project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insertUser(User user){
        userMapper.insertUser(user);
    }

    public String findUsername(String userID){
        return userMapper.findUsername(userID);

    }

}
