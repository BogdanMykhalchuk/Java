package com.dao;

import com.mappers.CakeMapper;
import com.models.Cake;
import com.models.Type;
import com.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dreawalker on 06.08.2017.
 */
@Repository
public class CakeDAO {

    public List<Cake> selectCakesFromDB() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        CakeMapper mapper = session.getMapper(CakeMapper.class);
        List<Cake> cakes = mapper.selectCakesFromDB();
        session.close();
        return cakes;
    }

    public Cake selectCakeById(Integer id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        CakeMapper mapper = session.getMapper(CakeMapper.class);
        Cake cake = mapper.selectCakeById(id);
        session.close();
        return cake;
    }

    public List<Cake> selectCakesFromDBByType(Type type) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        CakeMapper mapper = session.getMapper(CakeMapper.class);
        List<Cake> cakes = mapper.selectCakesFromDBByType(type);
        session.close();
        return cakes;
    }

    public boolean insertCake(Cake cake){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        CakeMapper mapper = session.getMapper(CakeMapper.class);
        mapper.insertCake(cake);
        session.commit();
        session.close();
        return true;
    }
    public boolean updateCake(Cake cake){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        CakeMapper mapper = session.getMapper(CakeMapper.class);
        mapper.updateCake(cake);
        session.commit();
        session.close();
        return true;
    }
    public boolean deleteCake(Integer id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        CakeMapper mapper = session.getMapper(CakeMapper.class);
        mapper.deleteCake(id);
        session.commit();
        session.close();
        return true;
    }
}
