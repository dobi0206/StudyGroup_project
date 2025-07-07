package com.studygroup.study_project.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/memberPage")
    public String member(){
        return "member";
    }

    @GetMapping("/projectPage")
    public String project(){
        return "project";
    }

    @GetMapping("/loginPage")
    public String loginPage(HttpServletRequest request, Model model){

        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        model.addAttribute("_csrf",csrfToken);

        return "login/index";
    }

    @GetMapping("/registerPage")
    public String registerPage(HttpServletRequest request, Model model){

        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        model.addAttribute("_csrf",csrfToken);


        return "register/index";
    }
}
