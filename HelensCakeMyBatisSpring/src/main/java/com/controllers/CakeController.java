package com.controllers;

import com.dataValidation.DataValidation;
import com.models.Cake;
import com.models.CoverType;
import com.models.DecorComplexity;
import com.models.Type;
import com.services.CakeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Dreawalker on 16.08.2017.
 */
@Controller
@RequestMapping(value = "/cakeController/**")
public class CakeController {

    @Autowired
    private CakeService cakeService;

    @RequestMapping(value = "/cakeController/saveCake")
    public String saveCake(@RequestParam Map<String, String> requestParam, Model model) {
        boolean checkCakeType = true;
        boolean checkCakeCoverType = true;
        boolean checkCakePathToImg = true;
        boolean checkCakeDecorComplexity = true;

        Type cakeType = null;
        CoverType cakeCoverType = null;
        String cakePathToImg;
        DecorComplexity cakeDecorComplexity = null;

        String stringCakeType = requestParam.get("cakeType");
        if(!Type.checkCakeType(stringCakeType)) {
            checkCakeType = false;
        } else {
            cakeType = Type.valueOf(stringCakeType);
        }
        String stringCakeCoverType = requestParam.get("cakeCoverType");
        if(!CoverType.checkCakeCoverType(stringCakeCoverType)) {
            checkCakeCoverType = false;
        } else {
            cakeCoverType = CoverType.valueOf(stringCakeCoverType);
        }
        cakePathToImg = requestParam.get("cakePathToImg");
        if(!DataValidation.isContainValidCharsOnly(cakePathToImg)) {
            checkCakePathToImg = false;
        }
        String stringCakeDecorComplexity = requestParam.get("cakeDecorComplexity");
        if(!DecorComplexity.checkCakeDecorComplexity(stringCakeDecorComplexity)) {
            checkCakeDecorComplexity = false;
        } else {
            cakeDecorComplexity = DecorComplexity.valueOf(stringCakeDecorComplexity);
        }


        boolean isCakeSaved = false;
        if(checkCakeType && checkCakeCoverType && checkCakePathToImg && checkCakeDecorComplexity) {
            isCakeSaved = cakeService.addCakeToDB(cakeType, cakeCoverType, cakePathToImg, cakeDecorComplexity);
        }

        model.addAttribute("isCakeSaved", isCakeSaved);
        model.addAttribute("checkCakeType", checkCakeType);
        model.addAttribute("checkCakeCoverType", checkCakeCoverType);
        model.addAttribute("checkCakePathToImg", checkCakePathToImg);
        model.addAttribute("checkCakeDecorComplexity", checkCakeDecorComplexity);

        return "admin/admin";
    }

    @RequestMapping(value = "/cakeController/getCakes")
    public String getCakes(Model model) {
        List<Cake> cakes = cakeService.getCakesFromDB();
        model.addAttribute("cakes", cakes);
        return "public/galleryByType";
    }

    @RequestMapping(value = "/cakeController/getCakesByType")
    public String getCakesByType(@RequestParam("cakeType") String cakeType, Model model) {
        Type type;
        List<Cake> cakes = new ArrayList<>();
        if(Type.checkCakeType(cakeType)) {
            type = Type.valueOf(cakeType);
            cakes = cakeService.getCakesFromDbByType(type);
        }
        model.addAttribute("cakes", cakes);
        return "public/galleryByType";
    }

    @RequestMapping(value = "/cakeController/deleteCake")
    public String deleteCake(@RequestParam("cakeId") String cakeId, Model model) {
        boolean checkCakeId = true;
        boolean isCakeDeleted = false;
        int intCakeId = 0;
        if (!StringUtils.isNumeric(cakeId)) {
            checkCakeId = false;
        } else {
            intCakeId = Integer.parseInt(cakeId);
        }
        if (checkCakeId) {
            isCakeDeleted = cakeService.deleteCake(intCakeId);
        }

        model.addAttribute("isCakeDeleted", isCakeDeleted);
        model.addAttribute("checkCakeId", checkCakeId);
        return "admin/admin";
    }
}
