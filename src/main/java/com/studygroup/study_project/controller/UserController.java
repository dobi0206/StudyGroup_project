package com.studygroup.study_project.controller;


import com.studygroup.study_project.entity.Role;
import com.studygroup.study_project.entity.User;
import com.studygroup.study_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        String userpassword=user.getPassword();
        user.setRole(Role.MEMBER);
        String passwordEncoded = passwordEncoder.encode(userpassword);
        user.setPassword(passwordEncoded);
        userService.insertUser(user);

        return "redirect:/loginPage";
    }


}
