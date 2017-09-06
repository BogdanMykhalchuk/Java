package com.dao;

import com.mappers.IncisionMapper;
import com.models.Incision;
import com.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dreawalker on 05.08.2017.
 */
@Repository
public class IncisionDAO {

    public List<Incision> selectIncisionsFromDB() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        IncisionMapper mapper = session.getMapper(IncisionMapper.class);
        List<Incision> list = mapper.selectIncisionsFromDB();
        session.close();
        return list;
    }

    public Incision selectIncisionById(Integer id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        IncisionMapper mapper = session.getMapper(IncisionMapper.class);
        Incision incision = mapper.selectIncisionById(id);
        session.close();
        return incision;
    }

    public boolean insertIncision(Incision incision){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        IncisionMapper mapper = session.getMapper(IncisionMapper.class);
        mapper.insertIncision(incision);
        session.commit();
        session.close();
        return true;
    }
    public void updateIncision(Incision incision){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        IncisionMapper mapper = session.getMapper(IncisionMapper.class);
        mapper.updateIncision(incision);
        session.commit();
        session.close();
    }
    public void deleteIncision(Integer id){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        IncisionMapper mapper = session.getMapper(IncisionMapper.class);
        mapper.deleteIncision(id);
        session.commit();
        session.close();
    }
}
