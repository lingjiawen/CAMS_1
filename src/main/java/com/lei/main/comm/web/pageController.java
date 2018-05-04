package com.lei.main.comm.web;

import com.lei.main.comm.bean.Message;
import com.lei.main.comm.bean.UserSession;
import com.lei.main.comm.service.VerifyCodeService;
import com.lei.main.comm.util.Common;
import com.lei.main.comm.util.MySessionContext;
import com.lei.main.system.systemManager.bean.User;
import com.lei.main.system.systemManager.service.UserManager;
import com.lei.util.DateUtils;
import com.lei.util.MD5Util;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import com.wordnik.swagger.annotations.*;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class pageController {
    @ApiIgnore
    @RequestMapping(value = "/login")
    public String studentLogin(Model model
    ){
       return "login";
    }

    @ApiIgnore
    @RequestMapping(value = "/main")
    public String studentMain(Model model
    ){
        return "main";
    }

    @ApiIgnore
    @RequestMapping(value = "/change_password")
    public String changePassword(Model model
    ){
        return "change_password";
    }

    @ApiIgnore
    @RequestMapping(value = "/new_friend")
    public String newFriend(Model model
    ){
        return "new_friend";
    }

    @ApiIgnore
    @RequestMapping(value = "/contact_detail")
    public String contactDetail(Model model
    ){
        return "contact_detail";
    }

    @ApiIgnore
    @RequestMapping(value = "/student_information")
    public String studentInformation(Model model
    ){
        return "student_information";
    }

    @ApiIgnore
    @RequestMapping(value = "/course_detail")
    public String courseDetail(Model model
    ){
        return "course_detail";
    }

    @ApiIgnore
    @RequestMapping(value = "/student_information_school")
    public String studentInformationSchool(Model model
    ){
        return "student_information_school";
    }

    @ApiIgnore
    @RequestMapping(value = "/student_information_grade")
    public String studentInformationGrade(Model model
    ){
        return "student_information_grade";
    }

    @ApiIgnore
    @RequestMapping(value = "/student_information_signature")
    public String studentInformationSignature(Model model
    ){
        return "student_information_signature";
    }

    @ApiIgnore
    @RequestMapping(value = "/course_information")
    public String courseInformation(Model model
    ){
        return "course_information";
    }

    @ApiIgnore
    @RequestMapping(value = "/api/login_auth")
    @ResponseBody
    public Map studentLoginAuth(Model model
    ){
        Map<String, String> result = new HashMap<String, String>();
        result.put("code", "1");
        result.put("msg", "登陆成功");

        return result;
    }

}
