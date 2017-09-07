package com.controllers;

import com.models.SpringSecurityCustomUser;;
import com.models.UserPrintOrder;
import com.services.UserPrintOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Dreawalker on 22.08.2017.
 */
@Controller(value = "/userPrintOrderController/**")
public class UserPrintOrderController {

    @Autowired
    private UserPrintOrderService userPrintOrderService;

    @RequestMapping(value = "/userPrintOrderController/createPrintOrder")
    public String createPrintOrder(@RequestParam Map<String, String> requestParam, Model model) {
        SpringSecurityCustomUser userDetails =
                (SpringSecurityCustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserPrintOrder userPrintOrder = new UserPrintOrder();
        userPrintOrderService.createUserPrintOrder(userDetails.getId(), userPrintOrder);
        return "order";
    }

    @RequestMapping(value = "/userPrintOrderController/getToCreatePrintOrderPage")
    public String getToCreatePrintOrderPage(Model model) {

        return "printOrder";
    }
}
