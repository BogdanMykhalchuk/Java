package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dreawalker on 30.08.2017.
 */
@Controller
@RequestMapping(value = "/")
public class FirstPageController {
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
    public String getToAdminPage(Model model){
        return "public/index";
    }
}
