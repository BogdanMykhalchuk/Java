package com.controllers;

import com.dataValidation.DataValidation;
import com.models.User;
import com.models.UserRole;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Dreawalker on 06.09.2017.
 */
@Controller(value = "/adminController/**")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/adminController/saveUser")
    public String saveUser(@RequestParam Map<String, String> requestParam, Model model) {

        boolean checkUserLogin = true;
        boolean checkUserPassWord = true;
        boolean checkUserName = true;
        boolean checkUserPhoneNumber = true;
        boolean checkUserRole = true;
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

        String stringUserRole = requestParam.get("userRole");
        UserRole userRole = UserRole.ROLE_CLIENT;
        if(!UserRole.checkUserRole(stringUserRole)) {
            checkUserRole = false;
        } else {
            userRole = UserRole.valueOf(stringUserRole);
        }

        if(checkUserLogin && checkUserPassWord && checkUserName && checkUserPhoneNumber && checkUserRole) {
            User user = User.createUserWithRole(userLogin, userPassword, userName, userPhoneNumber, userRole);
            isUserSaved = userService.registerUser(user);
        }

        if(isUserSaved) {
            model.addAttribute("isUserSaved", isUserSaved);
            return "admin/admin";
        }

        model.addAttribute("checkUserLogin", checkUserLogin);
        model.addAttribute("checkUserPassWord", checkUserPassWord);
        model.addAttribute("checkUserName", checkUserName);
        model.addAttribute("checkUserPhoneNumber", checkUserPhoneNumber);
        model.addAttribute("checkUserRole", checkUserRole);

        return "admin/adminRegistration";
    }

    @RequestMapping(value = "/adminController/getToRegistrationPage")
    public String getToRegistrationPage(Model model) {

        boolean checkUserLogin = true;
        boolean checkUserPassWord = true;
        boolean checkUserName = true;
        boolean checkUserPhoneNumber = true;
        boolean checkUserRole = true;
        model.addAttribute("checkUserLogin", checkUserLogin);
        model.addAttribute("checkUserPassWord", checkUserPassWord);
        model.addAttribute("checkUserName", checkUserName);
        model.addAttribute("checkUserPhoneNumber", checkUserPhoneNumber);
        model.addAttribute("checkUserRole", checkUserRole);

        return "admin/adminRegistration";
    }
}
