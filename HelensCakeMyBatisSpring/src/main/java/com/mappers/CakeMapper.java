package com.mappers;

import com.models.Cake;
import com.models.CoverType;
import com.models.DecorComplexity;
import com.models.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Dreawalker on 06.08.2017.
 */
public interface CakeMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "type", column = "type", javaType = Type.class),
            @Result(property = "cover", column = "cover", javaType = CoverType.class),
            @Result(property = "pathToImg", column = "pathToImg"),
            @Result(property = "complexity", column = "complexity", javaType = DecorComplexity.class)
    })
    @Select("SELECT * FROM cakes")
    List<Cake> selectCakesFromDB();

    @Select("SELECT * FROM cakes WHERE id = #{id}")
    Cake selectCakeById(Integer id);

    @Select("SELECT * FROM cakes WHERE type = #{type}")
    List<Cake> selectCakesFromDBByType(Type type);

    @Insert("INSERT INTO cakes(type, cover, pathToImg, complexity)" +
            " VALUES(#{type.ordinal}, #{cover.ordinal}, #{pathToImg}, #{complexity.ordinal})")
    boolean insertCake(Cake cake);

    @Update("UPDATE cakes SET type =#{type.ordinal}, cover =#{cover.ordinal}, pathToImg =#{pathToImg}," +
            " complexity =#{complexity.ordinal} WHERE id =#{id}")
    boolean updateCake(Cake cake);

    @Delete("DELETE FROM cakes WHERE id =#{id}")
    boolean deleteCake(Integer id);
}
