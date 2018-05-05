package com.lei.main.comm.web;

import com.lei.main.comm.action.LoginController;
import com.lei.main.comm.bean.Message;
import com.lei.main.system.attendance.action.AttendanceController;
import com.lei.main.system.course.action.CourseController;
import com.lei.main.system.group.action.GroupController;
import com.lei.main.system.systemManager.action.UserManagerController;
import com.lei.main.system.systemManager.bean.User;
import com.mangofactory.swagger.annotations.ApiIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
public class pageController {

    @Autowired
    private LoginController loginController;
    @Autowired
    private UserManagerController userManagerController;
    @Autowired
    private GroupController groupController;
    @Autowired
    private CourseController courseController;
    @Autowired
    private AttendanceController attendanceController;

    @ApiIgnore
    @RequestMapping(value = "/login")
    public String studentLogin(Model model, HttpServletRequest request, String phone, String mm
    ){
        Message<String> m = loginController.checkLogin(request, phone, mm);
        model.addAttribute("code", m.getCode());
        model.addAttribute("message", m.getMessage());
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
    public String studentInformation(Model model, String id, HttpServletRequest request
    ){
        Message<User> m = userManagerController.getUserById(request, id);
        model.addAttribute("code", m.getCode());
        model.addAttribute("message", m.getMessage());
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
