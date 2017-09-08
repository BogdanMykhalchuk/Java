package com.dao;

import com.mappers.AddressMapper;
import com.mappers.UserCakeOrderMapper;
import com.models.UserCakeOrder;
import com.utils.MyBatisUtil;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserCakeOrderDAO {

    public List<UserCakeOrder> selectUserCakeOrdersFromDB() {
        List<UserCakeOrder> userCakeOrders =
                MyBatisUtil.testSearch(UserCakeOrderMapper.class, (m) -> m.selectUserCakeOrdersFromDB());
        return userCakeOrders;
    }

    public UserCakeOrder selectUserCakeOrderById(Integer id) {
        UserCakeOrder userCakeOrder =
                MyBatisUtil.testSearch(UserCakeOrderMapper.class, (m) -> m.selectUserCakeOrderById(id));
        return userCakeOrder;
    }

    public List<UserCakeOrder> selectUserCakeOrdersByUserId(Integer userId) {
        List<UserCakeOrder> userCakeOrders =
                MyBatisUtil.testSearch(UserCakeOrderMapper.class, (m) -> m.selectUserCakeOrdersByUserId(userId));
        return userCakeOrders;
    }

    public List<UserCakeOrder> selectUserCakeOrdersByDate(LocalDateTime localDateTime) {
        List<UserCakeOrder> userCakeOrders =
                MyBatisUtil.testSearch(UserCakeOrderMapper.class, (m) -> m.selectUserCakeOrdersByDate(localDateTime));
        return userCakeOrders;
    }

    public boolean insertUserCakeOrderByUserId(UserCakeOrder userCakeOrder, Integer userId) {
        MyBatisUtil.test(UserCakeOrderMapper.class, (m) -> m.insertUserCakeOrderByUserId(userCakeOrder, userId));
        if(userCakeOrder.getNeedDelivery()) {
            MyBatisUtil.testSearch(AddressMapper.class, (m) -> m.insertAddressByOrderId(userCakeOrder.getAddress(), userId));
        }
        return true;
    }

    public boolean updateUserCakeOrderById(UserCakeOrder userCakeOrder) {
        MyBatisUtil.test(UserCakeOrderMapper.class, (m) -> m.updateUserCakeOrderById(userCakeOrder));
        return true;
    }

    public boolean deleteUserCakeOrder(Integer id){
        MyBatisUtil.test(UserCakeOrderMapper.class, (m) -> m.deleteUserCakeOrder(id));
        return true;
    }
}
