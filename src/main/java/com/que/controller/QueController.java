package com.que.controller;

import com.que.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/que")
public class QueController {
    @RequestMapping("/testing")
    public String testing( Model model) {

        return "/que/testing";
    }
    @RequestMapping("/result")
    public String  listUser(Model model) {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i <10; i++) {
            userList.add(new User(i,"张三"+i,20+i+"","中国广州"));
        }

        model.addAttribute("users", userList);
        return "/user/list";
    }
}