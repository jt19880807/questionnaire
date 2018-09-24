package com.que.controller;

import com.que.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QueController {
    @RequestMapping("que/testing")
    public String testing( Model model) {

        return "/que/testing";
    }
    @RequestMapping("que/result")
    public String  listUser(Model model) {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i <10; i++) {
            userList.add(new User(i,"张三"+i,20+i+"","中国广州"));
        }

        model.addAttribute("users", userList);
        return "/user/list";
    }

    @RequestMapping("que/save")
    public String  save(@RequestParam String answers) {
        String[] ans = answers.split("|");
        //1 读取文件

        //2 写入文件

        return "/user/list";
    }

    public static String readTxtFile(String filePath) {
        StringBuilder content = new StringBuilder("");
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] result =null; //getNamePhone(lineTxt);
                    System.out.println(lineTxt);
                    content.append(result[0] + "----" + result[1]);
                    content.append("\r\n");// txt换行
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void printFile(String content) {
        BufferedWriter bw = null;
        try {
            File file = new File("D:/filename.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
