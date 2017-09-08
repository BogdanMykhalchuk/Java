package com.dao;

import com.mappers.AddressMapper;
import com.models.Address;
import com.utils.MyBatisUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDAO {

    public List<Address> selectAddressesFromDB() {
        List<Address> addresses = MyBatisUtil.testSearch(AddressMapper.class, (m) -> m.selectAddressesFromDB());
        return addresses;
    }

    public Address selectAddressByOrderId(Integer id) {
        Address address = MyBatisUtil.testSearch(AddressMapper.class, (m) -> m.selectAddressByOrderId(id));
        return address;
    }

    public Address selectAddressesById(Integer id) {
        Address address = MyBatisUtil.testSearch(AddressMapper.class, (m) -> m.selectAddressesById(id));
        return address;
    }

    public boolean insertAddressByOrderId(Address address, Integer orderId) {
        MyBatisUtil.test(AddressMapper.class, (m) -> m.insertAddressByOrderId(address, orderId));
        return false;
    }

    public boolean updateAddress(Address address){
        MyBatisUtil.test(AddressMapper.class, (m) -> m.updateAddress(address));
        return true;
    }
    public boolean deleteAddress(Integer id){
        MyBatisUtil.test(AddressMapper.class, (m) -> m.deleteAddress(id));
        return true;
    }
}
