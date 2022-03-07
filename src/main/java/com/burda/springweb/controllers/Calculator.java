package com.burda.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class Calculator {

    @GetMapping("/calculator")
    public String helloPage(@RequestParam(value = "a",required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "c", required = false) String c,
                            Model model) {
        double result;
        switch (c) {
            case "sum":
                result = a * b;
                break;
            case "div":
                result = a / (double) b;
                break;
            case "plus":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
            default:
                result = 0;
        }

        model.addAttribute("result", result);

        return "test/calculator";
    }
}
