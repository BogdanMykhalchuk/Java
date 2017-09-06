package com.services;

import com.dao.IncisionDAO;
import com.models.Incision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dreawalker on 28.07.2017.
 */
@Service
public class IncisionService {

    @Autowired
    private IncisionDAO incisionDAO;

    public boolean addIncisionToDB(String name, String description, String pathToImg, double price) {
        Incision incision = new Incision(name, description, pathToImg, price);
        return incisionDAO.insertIncision(incision);
    }

    public List<Incision> getIncisionsFromDB() {
        return incisionDAO.selectIncisionsFromDB();
    }

    public boolean deleteIncision(Integer id) {
        incisionDAO.deleteIncision(id);
        return true;
    }
}
