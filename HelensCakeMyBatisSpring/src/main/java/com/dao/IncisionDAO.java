package com.dao;

import com.mappers.IncisionMapper;
import com.models.Incision;
import com.utils.MyBatisUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dreawalker on 05.08.2017.
 */
@Repository
public class IncisionDAO {

    public List<Incision> selectIncisionsFromDB() {
        List<Incision> list = MyBatisUtil.testSearch(IncisionMapper.class, (m) -> m.selectIncisionsFromDB());
        return list;
    }

    public Incision selectIncisionById(Integer id) {
        Incision incision = MyBatisUtil.testSearch(IncisionMapper.class, (m) -> m.selectIncisionById(id));
        return incision;
    }

    public boolean insertIncision(Incision incision){
        MyBatisUtil.test(IncisionMapper.class, (m) -> m.insertIncision(incision));
        return true;
    }
    public boolean updateIncision(Incision incision){
        MyBatisUtil.test(IncisionMapper.class, (m) -> m.updateIncision(incision));
        return true;
    }

    public boolean deleteIncision(Integer id){
        MyBatisUtil.test(IncisionMapper.class, (m) -> m.deleteIncision(id));
        return true;
    }
}
