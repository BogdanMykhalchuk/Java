package com.dao;

import com.mappers.UserPrintOrderMapper;
import com.models.UserPrintOrder;
import com.utils.MyBatisUtil;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserPrintOrderDAO {

    public List<UserPrintOrder> selectUserPrintOrdersFromDB() {
        List<UserPrintOrder> userPrintOrders =
                MyBatisUtil.testSearch(UserPrintOrderMapper.class, (m) -> m.selectUserPrintOrdersFromDB());
        return userPrintOrders;
    }

    public UserPrintOrder selectUserPrintOrderById(Integer id) {
        UserPrintOrder userPrintOrder =
                MyBatisUtil.testSearch(UserPrintOrderMapper.class, (m) -> m.selectUserPrintOrderById(id));
        return userPrintOrder;
    }

    public List<UserPrintOrder> selectUserPrintOrdersByUserId(Integer userId) {
        List<UserPrintOrder> userPrintOrders =
                MyBatisUtil.testSearch(UserPrintOrderMapper.class, (m) -> m.selectUserPrintOrdersByUserId(userId));
        return userPrintOrders;
    }

    public List<UserPrintOrder> selectUserPrintOrdersByDate(LocalDateTime localDateTime) {
        List<UserPrintOrder> userPrintOrders =
                MyBatisUtil.testSearch(UserPrintOrderMapper.class, (m) -> m.selectUserPrintOrdersByDate(localDateTime));
        return userPrintOrders;
    }

    public boolean insertUserPrintOrderByUserId(UserPrintOrder userPrintOrder, Integer userId) {
        MyBatisUtil.test(UserPrintOrderMapper.class, (m) -> m.insertUserPrintOrderByUserId(userPrintOrder, userId));
        return true;
    }

    public boolean updateUserPrintOrder(UserPrintOrder userPrintOrder){
        MyBatisUtil.test(UserPrintOrderMapper.class, (m) -> m.updateUserPrintOrder(userPrintOrder));
        return true;
    }
    public boolean deleteUserPrintOrder(Integer id){
        MyBatisUtil.test(UserPrintOrderMapper.class, (m) -> m.deleteUserPrintOrder(id));
        return true;
    }
}
