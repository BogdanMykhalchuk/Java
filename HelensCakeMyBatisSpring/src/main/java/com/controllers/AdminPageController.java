package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/adminController")
public class AdminPageController {
    @RequestMapping(method = RequestMethod.GET)
    public String getToAdminPage(@RequestParam("forward") String forward, Model model){
        if(forward.equals("true")) {

            boolean checkIncisionName = true;
            boolean checkIncisionDescription = true;
            boolean checkIncisionPath = true;
            boolean checkIncisionPrice = true;
            boolean isIncisionSaved = false;
            boolean checkIncisionId = true;
            boolean isIncisionDeleted = false;
            model.addAttribute("checkIncisionName", checkIncisionName);
            model.addAttribute("checkIncisionDescription", checkIncisionDescription);
            model.addAttribute("checkIncisionPath", checkIncisionPath);
            model.addAttribute("checkIncisionPrice", checkIncisionPrice);
            model.addAttribute("isIncisionSaved", isIncisionSaved);
            model.addAttribute("checkIncisionId", checkIncisionId);
            model.addAttribute("isIncisionDeleted", isIncisionDeleted);

            boolean checkCakeType = true;
            boolean checkCakeCoverType = true;
            boolean checkCakePathToImg = true;
            boolean checkCakeDecorComplexity = true;
            boolean isCakeSaved = false;
            boolean checkCakeId = true;
            boolean isCakeDeleted = false;
            model.addAttribute("checkCakeType", checkCakeType);
            model.addAttribute("checkCakeCoverType", checkCakeCoverType);
            model.addAttribute("checkCakePathToImg", checkCakePathToImg);
            model.addAttribute("checkCakeDecorComplexity", checkCakeDecorComplexity);
            model.addAttribute("isCakeSaved", isCakeSaved);
            model.addAttribute("checkCakeId", checkCakeId);
            model.addAttribute("isCakeDeleted", isCakeDeleted);

            return "admin/admin";
        }
        return "public/index";
    }
}
