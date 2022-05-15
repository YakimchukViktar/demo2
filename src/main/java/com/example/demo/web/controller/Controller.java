package com.example.demo.web.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
@RequestMapping("/page")
public class Controller {

    /*@PostMapping
    public String getFirstPage(@RequestParam("name") String name,
                               @RequestParam("num") int num,
                               Model model){
        model.addAttribute("message", "Hello, " + name);
        model.addAttribute("number", "Your number is " +
                          (num>10? "bigger than 10.": "less than 10 or equal 10."));
        System.out.println(name);
        System.out.println(num);
        return "firstPage";
    }*/

    @GetMapping ("/first")
    public String getFirstPage (HttpServletRequest request) {
        String name = request.getParameter("name");
        String male = request.getParameter("male");
        //System.out.println(name);
        //System.out.println(male);
        return "firstPage";
    }

    @GetMapping ("/second")
    public String getSecondPage (@RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "age", required = false) String age){
        //System.out.println(name);
        //System.out.println(age);
        return "secondPage";
    }
}
