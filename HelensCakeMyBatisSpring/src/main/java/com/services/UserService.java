package com.services;

import com.dao.UserDAO;
import com.models.User;
import com.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public boolean isUserExists(String login, String password) {
        User user = userDAO.selectUserByLoginPassword(login, password);
        return user != null;
    }

    public boolean registerUser(User user) {
        if(isUserExists(user.getLogin(), user.getPassword())) {
            return false;
        } else {
            userDAO.insertUser(user);
        }
        return true;
    }

    public boolean registerAdmin(String userLogin, String userPassword, String userName,
                                 String userPhoneNumber, UserRole userRole) {
        User user = User.createUserWithRole(userLogin, userPassword, userName, userPhoneNumber, userRole);
        if(isUserExists(user.getLogin(), user.getPassword())) {
            return false;
        } else {
            userDAO.insertUser(user);
        }
        return true;
    }

    public boolean deleteUser(User user) {
        userDAO.deleteUser(user.getId());
        return true;
    }

    public List<User> getUsersFromDb() {
        return userDAO.selectUsersFromDB();
    }
}
