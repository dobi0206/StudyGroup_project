package com.studygroup.study_project.controller;


import com.studygroup.study_project.entity.Notice;
import com.studygroup.study_project.service.NoticeRestService;
import com.studygroup.study_project.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @Autowired
    private NoticeRestService noticeRestService;

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

    @GetMapping("/noticeAddPage")
    public String noticeAddPage(){
        return "noticeAdd/index";
    }

    @GetMapping("/noticeCheckPage")
    public String shownoticeChaeckPage(@RequestParam("idx") int idx, Model model){
        Notice notice = noticeRestService.boardContent(idx);
        model.addAttribute("notice",notice);
        return "noticeCheck/index";
    }

    @GetMapping("/noticeModifyPage")
    public String shownoticeModifyPage(@RequestParam("idx") int idx, Model model){
        Notice notice = noticeRestService.boardContent(idx);
        model.addAttribute("notice",notice);
        return "noticeModify/index";
    }
}
