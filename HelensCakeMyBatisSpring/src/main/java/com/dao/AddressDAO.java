package com.dao;

import com.mappers.AddressMapper;
import com.models.Address;
import com.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDAO {

    public List<Address> selectAddressesFromDB() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        AddressMapper mapper = session.getMapper(AddressMapper.class);
        List<Address> addresses = mapper.selectAddressesFromDB();
        session.close();
        return addresses;
    }

    public Address selectAddressByOrderId(Integer id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        AddressMapper mapper = session.getMapper(AddressMapper.class);
        Address address = mapper.selectAddressByOrderId(id);
        session.close();
        return address;
    }

    public Address selectAddressesById(Integer id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        AddressMapper mapper = session.getMapper(AddressMapper.class);
        Address address = mapper.selectAddressesById(id);
        session.close();
        return address;
    }

    public boolean insertAddressByOrderId(Address address, Integer orderId) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        AddressMapper mapper = session.getMapper(AddressMapper.class);
        mapper.insertAddressByOrderId(address,orderId);
        session.close();
        return false;
    }

    public boolean updateAddress(Address address){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        AddressMapper mapper = session.getMapper(AddressMapper.class);
        mapper.updateAddress(address);
        session.commit();
        session.close();
        return true;
    }
    public boolean deleteAddress(Integer id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        AddressMapper mapper = session.getMapper(AddressMapper.class);
        mapper.deleteAddress(id);
        session.commit();
        session.close();
        return true;
    }
}
