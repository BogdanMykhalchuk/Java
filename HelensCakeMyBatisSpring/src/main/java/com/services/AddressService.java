package com.services;

import com.dao.AddressDAO;
import com.models.Address;
import com.models.UserCakeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dreawalker on 28.08.2017.
 */
@Service
public class AddressService {

    @Autowired
    private AddressDAO addressDAO;

    public List<Address> getAddressesFromDb() {
        return addressDAO.selectAddressesFromDB();
    }

    // can return null
    public Address getAddressFromDb(UserCakeOrder userCakeOrder) {
        return addressDAO.selectAddressesById(userCakeOrder.getAddress().getId());
    }

    public boolean updateAddress(Address address) {
        addressDAO.updateAddress(address);
        return true;
    }

    public boolean deleteAddress(Address address) {
        addressDAO.deleteAddress(address.getId());
        return true;
    }
}
