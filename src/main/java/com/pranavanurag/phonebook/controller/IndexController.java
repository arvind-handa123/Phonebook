package com.pranavanurag.phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

   	@RequestMapping("/")
    public String serveIndexPage() {
        return "html/index.html";
    }
}
