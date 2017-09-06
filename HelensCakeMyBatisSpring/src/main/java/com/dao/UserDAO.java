package com.dao;

import com.mappers.UserMapper;
import com.models.User;
import com.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    public List<User> selectUsersFromDB() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUsersFromDB();
        session.close();
        return users;
    }

    public User selectUserById(Integer id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(id);
        session.close();
        return user;
    }

    public User selectUserFromDbByPhoneNumber(String phoneNumber) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserFromDbByPhoneNumber(phoneNumber);
        session.close();
        return user;
    }

    public User selectUserByLoginPassword(String login, String password) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserByLoginPassword(login, password);
        session.close();
        return user;
    }

    public User selectUserByUserName(String login) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserByUserName(login);
        session.close();
        return user;
    }

    public boolean insertUser(User user){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.insertUser(user);
        session.commit();
        session.close();
        return true;
    }

    public boolean updateUser(User user){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateUser(user);
        session.commit();
        session.close();
        return true;
    }

    public boolean deleteUser(Integer id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUser(id);
        session.commit();
        session.close();
        return true;
    }
}
