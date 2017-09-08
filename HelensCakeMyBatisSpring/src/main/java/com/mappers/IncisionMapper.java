package com.mappers;

import com.models.Incision;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface  IncisionMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "pathToImg", column = "pathToImg"),
            @Result(property = "price", column = "price")
    })
    @Select("SELECT * FROM incisions")
    List<Incision> selectIncisionsFromDB();

    @Select("SELECT id, name, description, price from incisions WHERE id = #{id}")
    Incision selectIncisionById(Integer id);

    @Insert("INSERT into incisions(name, description, pathToImg, price) VALUES(#{name}," +
            " #{description}, #{pathToImg}, #{price})")
    boolean insertIncision(Incision incision);

    @Update("UPDATE incisions SET name=#{name}, description =#{description}, pathToInt =#{pathToInt}," +
            " price =#{price} WHERE id =#{id}")
    boolean updateIncision(Incision incision);

    @Delete("DELETE FROM incisions WHERE id =#{id}")
    boolean deleteIncision(Integer id);
}
