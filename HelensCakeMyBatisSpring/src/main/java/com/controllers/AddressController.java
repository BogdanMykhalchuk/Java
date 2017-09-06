package com.controllers;

import com.models.Address;
import com.models.UserCakeOrder;
import com.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Dreawalker on 28.08.2017.
 */
@Controller
@RequestMapping(value = "/addressController/**")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/addressController/getAddresses")
    public List<Address> getAddresses() {
        return addressService.getAddressesFromDb();
    }

    @RequestMapping(value = "/addressController/getAddress")
    public Address getAddress(UserCakeOrder userCakeOrder) {
        return addressService.getAddressFromDb(userCakeOrder);
    }

    @RequestMapping(value = "/addressController/updateAddress")
    public boolean updateAddress(Address address) {
        return addressService.updateAddress(address);
    }

    @RequestMapping(value = "/addressController/deleteAddress")
    public boolean deleteAddress(Address address) {
        return addressService.deleteAddress(address);
    }
}
