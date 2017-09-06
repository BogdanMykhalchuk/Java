package com.services;

import com.dao.UserCakeOrderDAO;
import com.models.User;
import com.models.UserCakeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserCakeOrderService {

    @Autowired
    private UserCakeOrderDAO userCakeOrderDAO;

    public boolean createUserCakeOrder(User user, UserCakeOrder  userCakeOrder) {
        userCakeOrderDAO.insertUserCakeOrderByUserId(userCakeOrder, user.getId());
        return true;
    }

    public boolean updateUserCakeOrder(UserCakeOrder userCakeOrder) {
        userCakeOrderDAO.updateUserCakeOrderById(userCakeOrder);
        return true;
    }

    public boolean deleteUserCakeOrder(UserCakeOrder userCakeOrder) {
        userCakeOrderDAO.deleteUserCakeOrder(userCakeOrder.getId());
        return true;
    }

    public List<UserCakeOrder> getUserCakeOrdersByUserId(User user) {
        return userCakeOrderDAO.selectUserCakeOrdersByUserId(user.getId());
    }

    public List<UserCakeOrder> getUserCakeOrdersByDate(LocalDateTime localDateTime) {
        return userCakeOrderDAO.selectUserCakeOrdersByDate(localDateTime);
    }
}
