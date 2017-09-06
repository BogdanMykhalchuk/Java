package com.dao;

import com.mappers.AddressMapper;
import com.mappers.UserCakeOrderMapper;
import com.models.UserCakeOrder;
import com.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserCakeOrderDAO {

    public List<UserCakeOrder> selectUserCakeOrdersFromDB() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserCakeOrderMapper mapper = session.getMapper(UserCakeOrderMapper.class);
        List<UserCakeOrder> userCakeOrders = mapper.selectUserCakeOrdersFromDB();
        session.close();
        return userCakeOrders;
    }

    public UserCakeOrder selectUserCakeOrderById(Integer id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserCakeOrderMapper mapper = session.getMapper(UserCakeOrderMapper.class);
        UserCakeOrder userCakeOrder = mapper.selectUserCakeOrderById(id);
        session.close();
        return userCakeOrder;
    }

    public List<UserCakeOrder> selectUserCakeOrdersByUserId(Integer userId) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserCakeOrderMapper mapper = session.getMapper(UserCakeOrderMapper.class);
        List<UserCakeOrder> userCakeOrders = mapper.selectUserCakeOrdersByUserId(userId);
        session.close();
        return userCakeOrders;
    }

    public List<UserCakeOrder> selectUserCakeOrdersByDate(LocalDateTime localDateTime) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserCakeOrderMapper mapper = session.getMapper(UserCakeOrderMapper.class);
        List<UserCakeOrder> userCakeOrders = mapper.selectUserCakeOrdersByDate(localDateTime);
        session.close();
        return userCakeOrders;
    }

    public boolean insertUserCakeOrderByUserId(UserCakeOrder userCakeOrder, Integer userId) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserCakeOrderMapper userCakeOrderMapper = session.getMapper(UserCakeOrderMapper.class);
        userCakeOrderMapper.insertUserCakeOrderByUserId(userCakeOrder, userId);
        if(userCakeOrder.getNeedDelivery()) {
            AddressMapper addressMapper = session.getMapper(AddressMapper.class);
            addressMapper.insertAddressByOrderId(userCakeOrder.getAddress(), userId);
        }
        session.commit();
        session.close();
        return true;
    }

    public boolean updateUserCakeOrderById(UserCakeOrder userCakeOrder) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserCakeOrderMapper mapper = session.getMapper(UserCakeOrderMapper.class);
        mapper.updateUserCakeOrderById(userCakeOrder);
        session.commit();
        session.close();
        return true;
    }

    public boolean deleteUserCakeOrder(Integer id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserCakeOrderMapper mapper = session.getMapper(UserCakeOrderMapper.class);
        mapper.deleteUserCakeOrder(id);
        session.commit();
        session.close();
        return true;
    }
}
