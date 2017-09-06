package com.services;

import com.dao.UserPrintOrderDAO;
import com.models.User;
import com.models.UserPrintOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserPrintOrderService {

    @Autowired
    private UserPrintOrderDAO userPrintOrderDAO;

    public boolean createUserPrintOrder(User user, UserPrintOrder userPrintOrder) {
        userPrintOrderDAO.insertUserPrintOrderByUserId(userPrintOrder, user.getId());
        return true;
    }

    public boolean updateUserPrintOrder(UserPrintOrder userPrintOrder) {
        userPrintOrderDAO.updateUserPrintOrder(userPrintOrder);
        return true;
    }

    public boolean deleteUserPrintOrder(UserPrintOrder userPrintOrder) {
        userPrintOrderDAO.deleteUserPrintOrder(userPrintOrder.getId());
        return true;
    }

    public List<UserPrintOrder> getUserPrintOrdersByUserId(User user) {
        return userPrintOrderDAO.selectUserPrintOrdersByUserId(user.getId());
    }

    public List<UserPrintOrder> getUserPrintOrdersByDate(LocalDateTime localDateTime) {
        return userPrintOrderDAO.selectUserPrintOrdersByDate(localDateTime);
    }
}
