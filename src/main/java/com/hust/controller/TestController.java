package com.hust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
//@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/http")
    public void http(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求数据
        System.out.println(req.getMethod());//获取请求方式
        System.out.println(req.getServletPath());//获取请求路径
        Enumeration<String> headerNames = req.getHeaderNames();//获取所有请求头名称key
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();//获取单个请求头名称key
            String value = req.getHeader(name);//获取请求头对应的值value
            System.out.println(name + ": " + value);
        }
        System.out.println(req.getParameter("code"));//根据code获取请求参数
        //返回响应数据
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<h1>牛客网<h1>");
        writer.close();
    }
    //GET请求
    //示例:/student?current=1&limit=20
    @GetMapping("/students")
    //@RequestMapping(path = "/student",method = RequestMethod.GET)
    public String getStudents(
            @RequestParam(name = "current",required = false,defaultValue = "1") int current,
            @RequestParam(name = "limit",required = false,defaultValue = "10")int limit){
        System.out.println(current);//尝试看能否获取到参数current
        System.out.println(limit);//尝试看能否获取到参数limit
        return "some student";
    }
    //示例:/student
    @GetMapping("/student/{id}")
    //@RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);//尝试看能否获取到参数id
        return "a student";
    }

    //POST请求
    @PostMapping("/student")
    //@RequestMapping(path = "/student",method =RequestMethod.POST)
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //使用thymeleaf模板响应HTML数据
    //方式1
    @GetMapping("/teacher")
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","张三");//添加数据
        mav.addObject("age","18");//添加数据
        mav.setViewName("/demo/view");//设置thymeleaf的模板路径
        return mav;
    }
    //方式2:此方式的Controller类上不能使用@ResponseBody注解,否则只能返回字符串
    @GetMapping("/school")
    public String getSchool(Model model){
        model.addAttribute("name","北京大学");
        model.addAttribute("age",100);
        return "/demo/view";
    }

    //响应json数据:异步请求
    //java对象->json字符串->js对象
    @GetMapping("/emp")
    public Map<String, Object> getEmp(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("salary",8000.00);
        map.put("age",23);
        return map;//会自动转换为json数据:{"name":"张三","salary":8000.0,"age":23}
    }


}
