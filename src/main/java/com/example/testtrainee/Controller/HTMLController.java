package com.example.testtrainee.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTMLController {
    @GetMapping("/home")
    public String showHome(){
    return "index";
}
}
