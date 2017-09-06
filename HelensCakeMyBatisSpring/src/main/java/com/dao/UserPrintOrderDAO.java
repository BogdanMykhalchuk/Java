package com.dao;

import com.mappers.UserPrintOrderMapper;
import com.models.UserPrintOrder;
import com.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserPrintOrderDAO {

    public List<UserPrintOrder> selectUserPrintOrdersFromDB() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserPrintOrderMapper mapper = session.getMapper(UserPrintOrderMapper.class);
        List<UserPrintOrder> userPrintOrders = mapper.selectUserPrintOrdersFromDB();
        session.close();
        return userPrintOrders;
    }

    public UserPrintOrder selectUserPrintOrderById(Integer id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserPrintOrderMapper mapper = session.getMapper(UserPrintOrderMapper.class);
        UserPrintOrder userPrintOrder = mapper.selectUserPrintOrderById(id);
        session.close();
        return userPrintOrder;
    }

    public List<UserPrintOrder> selectUserPrintOrdersByUserId(Integer userId) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserPrintOrderMapper mapper = session.getMapper(UserPrintOrderMapper.class);
        List<UserPrintOrder> userPrintOrders = mapper.selectUserPrintOrdersByUserId(userId);
        session.close();
        return userPrintOrders;
    }

    public List<UserPrintOrder> selectUserPrintOrdersByDate(LocalDateTime localDateTime) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserPrintOrderMapper mapper = session.getMapper(UserPrintOrderMapper.class);
        List<UserPrintOrder> userPrintOrders = mapper.selectUserPrintOrdersByDate(localDateTime);
        session.close();
        return userPrintOrders;
    }

    public boolean insertUserPrintOrderByUserId(UserPrintOrder userPrintOrder, Integer userId) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserPrintOrderMapper userPrintOrderMapper = session.getMapper(UserPrintOrderMapper.class);
        userPrintOrderMapper.insertUserPrintOrderByUserId(userPrintOrder, userId);
        session.commit();
        session.close();
        return true;
    }

    public boolean updateUserPrintOrder(UserPrintOrder userPrintOrder){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserPrintOrderMapper mapper = session.getMapper(UserPrintOrderMapper.class);
        mapper.updateUserPrintOrder(userPrintOrder);
        session.commit();
        session.close();
        return true;
    }
    public boolean deleteUserPrintOrder(Integer id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserPrintOrderMapper mapper = session.getMapper(UserPrintOrderMapper.class);
        mapper.deleteUserPrintOrder(id);
        session.commit();
        session.close();
        return true;
    }
}
