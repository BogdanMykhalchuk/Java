package com.mappers;

import com.models.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "login", column = "login"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name"),
            @Result(property = "phoneNumber", column = "phoneNumber"),
            @Result(property = "userRole", column = "userRole", javaType = UserRole.class),

            @Result(property = "cakeOrders", column = "id", javaType = List.class,
                    many = @Many(select="com.mappers.UserCakeOrderMapper.selectUserCakeOrdersByUserId")),

            @Result(property = "printOrders", column = "id", javaType = List.class,
                    many = @Many(select="com.mappers.UserPrintOrderMapper.selectUserPrintOrdersByUserId"))

    })
    @Select("SELECT * FROM users")
    List<User> selectUsersFromDB();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User selectUserById(Integer id);

    @Select("SELECT * FROM users WHERE phoneNumber = #{phoneNumber}")
    User selectUserFromDbByPhoneNumber(String phoneNumber);

    @Select("SELECT * FROM users WHERE login = #{login} AND password = #{password}")
    User selectUserByLoginPassword(@Param("login")String login, @Param("password")String password);

    @Select("SELECT * FROM users WHERE login = #{login}")
    User selectUserByUserName(String login);

    @Insert("INSERT INTO users(login, password, name, phoneNumber, userRole)" +
            " VALUES(#{login}, #{password}, #{name}, #{phoneNumber}, #{userRole.ordinal})")
    boolean insertUser(User user);

    @Update("UPDATE users SET login =#{login}, password =#{password}, name =#{name}," +
            " phoneNumber =#{phoneNumber}, userRole =#{userRole.ordinal} WHERE id =#{id}")
    boolean updateUser(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    boolean deleteUser(Integer id);
}
