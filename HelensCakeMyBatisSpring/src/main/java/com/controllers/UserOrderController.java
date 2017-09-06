package com.controllers;

import com.services.UserCakeOrderService;
import com.services.UserPrintOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dreawalker on 06.09.2017.
 */
@Controller(value = "/userOrderController/**")
public class UserOrderController {

    @Autowired
    private UserCakeOrderService userCakeOrderService;

    @Autowired
    private UserPrintOrderService userPrintOrderService;

    @RequestMapping(value = "/userOrderController/getToUserOrdersPage")
    public String getToUserOrderPage(@Param("userLogin") String userLogin, Model model) {
        return "userOrders";
    }
}
