package com.example.hibia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/hibia/long-process")
    @ResponseBody
    public String pause() throws InterruptedException {
        Thread.sleep(10000);
        return "Process finished";
    }

}
