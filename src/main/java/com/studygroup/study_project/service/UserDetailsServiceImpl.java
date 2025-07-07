package com.studygroup.study_project.service;


import com.studygroup.study_project.entity.CusotmUser;
import com.studygroup.study_project.entity.User;
import com.studygroup.study_project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {

        User user = userMapper.findByUserID(userID);
        if(user == null){
            throw new UsernameNotFoundException(userID+"존재하지 않습니다.");
        }


        return new CusotmUser(user);
    }
}
