package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/page")
@Controller
public class Calculator {

    /*@GetMapping("/calculate")
    public String getCalculatorPage (@RequestParam(value = "a", required = false) String a,
                                     @RequestParam(value = "b", required = false) String b,
                                     @RequestParam (value = "operation", required = false) String operation,
                                     Model model){
        int i = Integer.parseInt(a);
        int j = Integer.parseInt(b);
        double res = 0;
        if (operation.equals("plus")) {
            res = i + j;
        } else if (operation.equals("divide")) {
            res = i / (double) j;
        } else if (operation.equals("multiply")) {
            res = i * j;
        } else if (operation.equals("minus")) {
            res = i - j;
        }
        model.addAttribute("result", "Результат: " + res);
        return "calculatorPage";
    }*/

    @GetMapping ("/calculator")
    public String getCalculatorPage (){
        return "calculatorPage";
    }

    @PostMapping
    public String getCalculator(@RequestParam(value = "a", required = false) int i,
                                @RequestParam(value = "b", required = false) int j,
                                @RequestParam (value = "operation", required = false) String operation,
                                Model model){
        String doing = "";
        Number res = 0;
        switch (operation) {
            case "plus":
                res = i + j;
                doing = " плюс ";
                break;
            case "divide":
                res = i / (double) j;
                doing = " разделить на ";
                break;
            case "multiply":
                res = i * j;
                doing = " умножить на ";
                break;
            case "minus":
                res = i - j;
                doing = " минус ";
                break;
        }
        model.addAttribute("result", "Результат: " + i + doing + j + " равно " + res);
        return "calculatorPage";
    }

}
