package com.hust.controller;

import com.hust.entity.DiscussPost;
import com.hust.entity.Page;
import com.hust.entity.User;
import com.hust.service.DiscussPostService;
import com.hust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;


    @GetMapping("/index")
    public String getIndexPage(Model model,Page page){
        //方法调用前,SpringMVC会自动实例化Model和Page,并将Page注入Model
        //所以,在thymeleaf中可以直接访问Page对象中的数据
        page.setRows(discussPostService.findDiscussPostRows(0));//获取数据总条数
        page.setPath("/index");

        List<DiscussPost> posts = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> postsAndUsers = new ArrayList<>();
        if(posts != null){
            for (DiscussPost post : posts) {
                Map<String, Object> map = new HashMap<>();
                map.put("post",post);//将帖子的信息放进map集合中
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);//将发布帖子的用户信息放进map集合中
                postsAndUsers.add(map);
            }
        }
        model.addAttribute("postsAndUsers",postsAndUsers);
        return "/index";
    }



}
