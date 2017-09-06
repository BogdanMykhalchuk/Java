package com.services;

import com.dao.CakeDAO;
import com.models.Cake;
import com.models.CoverType;
import com.models.DecorComplexity;
import com.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dreawalker on 28.07.2017.
 */
@Service
public class CakeService {

    @Autowired
    private CakeDAO cakeDAO;

    public boolean addCakeToDB(Type type, CoverType cover, String pathToImg, DecorComplexity complexity) {
        Cake cake = new Cake(type, cover, pathToImg, complexity);
        return cakeDAO.insertCake(cake);
    }

    public List<Cake> getCakesFromDB() {
        return cakeDAO.selectCakesFromDB();
    }

    public boolean deleteCake(Integer id) {
        return cakeDAO.deleteCake(id);
    }

    public List<Cake> getCakesFromDbByType(Type type) {
        return cakeDAO.selectCakesFromDBByType(type);
    }
}
