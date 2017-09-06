package com.controllers;

import com.dataValidation.DataValidation;
import com.models.Incision;
import com.services.IncisionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Dreawalker on 14.08.2017.
 */
@Controller
@RequestMapping(value = "/incisionController/**")
public class IncisionController {

    @Autowired
    private IncisionService incisionService;

    @RequestMapping(value = "/incisionController/getToIncisionsPage")
    public String getToIncisionsPage(Model model) {
        List<Incision> incisions = incisionService.getIncisionsFromDB();
        model.addAttribute("incisions", incisions);
        return "public/recipes";
    }

    @RequestMapping(value = "/incisionController/saveIncisionToDB")
    public String saveIncisionToDB(@RequestParam Map<String,String> requestParams, Model model) {
        boolean checkIncisionName = true;
        boolean checkIncisionDescription = true;
        boolean checkIncisionPath = true;
        boolean checkIncisionPrice = true;

        String name = requestParams.get("incisionName");
        if(!DataValidation.isContainValidCharsOnly(name)) {
            checkIncisionName = false;
        }
        String description = requestParams.get("incisionDescription");
        if(!DataValidation.isContainValidCharsOnly(name)) {
            checkIncisionDescription = false;
        }
        String pathToImg = requestParams.get("incisionPathToImg");
        if(!DataValidation.isContainValidCharsOnly(name)) {
            checkIncisionPath = false;
        }
        String priceString = requestParams.get("incisionPrice");
        double price = 0.0;
        if(!DataValidation.isContainValidCharsOnly(name)) {
            checkIncisionPrice = false;
        } else {
            price = Double.parseDouble(priceString);
        }

        boolean isIncisionSaved = false;
        if(checkIncisionName && checkIncisionDescription && checkIncisionPath && checkIncisionPrice) {
            isIncisionSaved = incisionService.addIncisionToDB(name, description, pathToImg, price);
        }

        model.addAttribute("isIncisionSaved", isIncisionSaved);
        model.addAttribute("checkIncisionName", checkIncisionName);
        model.addAttribute("checkIncisionDescription", checkIncisionDescription);
        model.addAttribute("checkIncisionPath", checkIncisionPath);
        model.addAttribute("checkIncisionPrice", checkIncisionPrice);

        return "admin/admin";
    }

    @RequestMapping(value = "/incisionController/deleteIncision")
    public String deleteIncision(@RequestParam("incisionId") String incisionId, Model model) {
        boolean checkIncisionId = true;
        boolean isIncisionDeleted = false;
        int intIncisionId = 0;
        if(!StringUtils.isNumeric(incisionId)) {
            checkIncisionId = false;
        } else {
            intIncisionId = Integer.parseInt(incisionId);
        }
        if(checkIncisionId) {
            isIncisionDeleted = incisionService.deleteIncision(intIncisionId);
        }

        model.addAttribute("isIncisionDeleted", isIncisionDeleted);
        model.addAttribute("checkIncisionId", checkIncisionId);

        return "admin/admin";
    }

}
