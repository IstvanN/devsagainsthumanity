package com.greenfoxacademy.dah.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LobbyController {

    @GetMapping(value= {"", "/app"})
    public String showIndex() {
        return "index";
    }
}