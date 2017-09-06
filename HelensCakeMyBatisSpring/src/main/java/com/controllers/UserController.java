package com.controllers;

import com.dataValidation.DataValidation;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Dreawalker on 28.08.2017.
 */
@Controller(value = "/userController/**")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userController/saveUser")
    public String saveUser(@RequestParam Map<String, String> requestParam, Model model) {

        boolean checkUserLogin = true;
        boolean checkUserPassWord = true;
        boolean checkUserName = true;
        boolean checkUserPhoneNumber = true;
        boolean isUserSaved = false;

        String userLogin = requestParam.get("userLogin");
        if(!DataValidation.isContainValidCharsOnly(userLogin)) {
            checkUserLogin = false;
        }

        String userPassword = requestParam.get("userPassword");
        if(!DataValidation.isContainValidCharsOnly(userPassword)) {
            checkUserPassWord = false;
        }

        String userName = requestParam.get("userName");
        if(!DataValidation.isContainValidCharsOnly(userName)) {
            checkUserName = false;
        }

        String userPhoneNumber = requestParam.get("userPhoneNumber");
        if(!DataValidation.isValidPhoneNumber(userPhoneNumber)) {
            checkUserPhoneNumber = false;
        }

        if(checkUserLogin && checkUserPassWord && checkUserName && checkUserPhoneNumber) {
            isUserSaved = userService.registerUser(userLogin, userPassword, userName, userPhoneNumber);
        }

        model.addAttribute("isUserSaved", isUserSaved);
        model.addAttribute("checkUserLogin", checkUserLogin);
        model.addAttribute("checkUserPassWord", checkUserPassWord);
        model.addAttribute("checkUserName", checkUserName);
        model.addAttribute("checkUserPhoneNumber", checkUserPhoneNumber);

        return "public/registration";
    }

    @RequestMapping(value = "/userController/getToRegistrationPage")
    public String getToRegistrationPage(Model model) {

        boolean checkUserLogin = true;
        boolean checkUserPassWord = true;
        boolean checkUserName = true;
        boolean checkUserPhoneNumber = true;
        boolean isUserSaved = false;
        model.addAttribute("isUserSaved", isUserSaved);
        model.addAttribute("checkUserLogin", checkUserLogin);
        model.addAttribute("checkUserPassWord", checkUserPassWord);
        model.addAttribute("checkUserName", checkUserName);
        model.addAttribute("checkUserPhoneNumber", checkUserPhoneNumber);

        return "public/registration";
    }
}
