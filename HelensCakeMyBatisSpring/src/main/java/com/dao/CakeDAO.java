package com.dao;

import com.mappers.CakeMapper;
import com.models.Cake;
import com.models.Type;
import com.utils.MyBatisUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dreawalker on 06.08.2017.
 */
@Repository
public class CakeDAO {

    public List<Cake> selectCakesFromDB() {
        List<Cake> cakes = MyBatisUtil.testSearch(CakeMapper.class, (m) -> m.selectCakesFromDB());
        return cakes;
    }

    public Cake selectCakeById(Integer id) {
        Cake cake = MyBatisUtil.testSearch(CakeMapper.class, (m) -> m.selectCakeById(id));
        return cake;
    }

    public List<Cake> selectCakesFromDBByType(Type type) {
        List<Cake> cakes = MyBatisUtil.testSearch(CakeMapper.class, (m) -> m.selectCakesFromDBByType(type));
        return cakes;
    }

    public boolean insertCake(Cake cake){
        MyBatisUtil.test(CakeMapper.class, (m) -> m.insertCake(cake));
        return true;
    }
    public boolean updateCake(Cake cake){
        MyBatisUtil.test(CakeMapper.class, (m) -> m.updateCake(cake));
        return true;
    }
    public boolean deleteCake(Integer id){
        MyBatisUtil.test(CakeMapper.class, (m) -> m.deleteCake(id));
        return true;
    }
}
