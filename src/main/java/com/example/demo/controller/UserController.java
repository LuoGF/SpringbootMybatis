package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Json;
import com.example.demo.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@Controller
@RequestMapping(value = "/user")//设置访问改控制类的"别名"
public class UserController {

    @Autowired
    private UserService userService;

    /*
     **返回标准的Json格式数据其中包括（是否成功、状态码、消息、内容）
     * 该方法是由于公司很多童鞋写接口时没有一个标准的定义，天马行空的编写数据接口导致调用时效率极低，因此自己写了一个标准的
     * 接口调用方法，仅供大家参考
     * @param statu
     * @param code
     * @param message
     * @author lgf
     * */
    @RequestMapping("/getAllUser")
    @ResponseBody
    private void getAllUser(HttpServletResponse response)throws Exception {
        List<User> users =  userService.getAllUser();
        if(users.isEmpty()){
            Json.toJson(new Tool(false,7000,"没有数据",null),response);
            return;
        }
        List<User> listuser = new ArrayList<User>();
        for (User entity : users) {
            User user = new User();
            user.setId(entity.getId());
            user.setName(entity.getName());
            user.setAge(entity.getAge());
            user.setSex(entity.getSex());
            listuser.add(entity);
        }
        Tool result = new Tool(true,200,"成功",listuser);
        Json.toJson(result,response);

    }
    @RequestMapping("/find")
    @ResponseBody
    private User find() {
        User users =  userService.getAllUserByName("小芳");
        return users;
    }
    @RequestMapping("/checkLogin")
    @ResponseBody
    private User checkLogin() {
        User users = new User();
        return users;
    }
    /*
     **登录调用方法跳转登录页面
     * @author lgf
     * */
    @RequestMapping("/login")
    private String index() {
        return "Login2.html";
    }
    /*
     **登录成功响应方法
     * @param message
     * @author lgf
     * */
    @RequestMapping(value="/success",method = {RequestMethod.POST, RequestMethod.GET})
    private String ok() {
        return "success";
    }
    /*
     **输入账号密码登录校验方法
     * @param message
     * @author lgf
     * */
    @RequestMapping(value="/loginPage",method = {RequestMethod.POST, RequestMethod.GET})
    private ModelAndView login(HttpServletRequest request, HttpSession session) {
        ModelAndView mav=new ModelAndView();
        //out.print("ajax进入后台！！");
        String name = request.getParameter("username");
        String id = request.getParameter("pwd");
        User tname = userService.loginPage(name,id);
        out.print(tname);
        if (tname == null) {
            mav.clear();
            mav.setViewName("Login2");
            return mav;
        } else {
            session.setAttribute("tname", tname.getName());
            out.print(tname.getName());
            //验证通过跳转首页
            mav.setViewName("homePage");
            return mav;
        }
    }
}