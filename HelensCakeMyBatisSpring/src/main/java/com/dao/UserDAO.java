package com.dao;

import com.mappers.UserMapper;
import com.models.User;
import com.utils.MyBatisUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    public List<User> selectUsersFromDB() {
        List<User> users = MyBatisUtil.testSearch(UserMapper.class, (m) -> m.selectUsersFromDB());
        return users;
    }

    public User selectUserById(Integer id) {
        User user = MyBatisUtil.testSearch(UserMapper.class, (m) -> m.selectUserById(id));
        return user;
    }

    public User selectUserFromDbByPhoneNumber(String phoneNumber) {
        User user = MyBatisUtil.testSearch(UserMapper.class, (m) -> m.selectUserFromDbByPhoneNumber(phoneNumber));
        return user;
    }

    public User selectUserByLoginPassword(String login, String password) {
        User user = MyBatisUtil.testSearch(UserMapper.class, (m) -> m.selectUserByLoginPassword(login, password));
        return user;
    }

    public User selectUserByUserName(String login) {
        User user = MyBatisUtil.testSearch(UserMapper.class, (m) -> m.selectUserByUserName(login));
        return user;
    }

    public boolean insertUser(User user){
        MyBatisUtil.test(UserMapper.class, (m) -> m.insertUser(user));
        return true;
    }

    public boolean updateUser(User user){
        MyBatisUtil.test(UserMapper.class, (m) -> m.updateUser(user));
        return true;
    }

    public boolean deleteUser(Integer id){
        MyBatisUtil.test(UserMapper.class, (m) -> m.deleteUser(id));
        return true;
    }
}
