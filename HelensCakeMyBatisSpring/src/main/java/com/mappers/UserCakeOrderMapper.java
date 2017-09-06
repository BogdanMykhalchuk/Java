package com.mappers;

import com.models.UserCakeOrder;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.apache.ibatis.type.JdbcType.TIMESTAMP;

public interface UserCakeOrderMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "recipe", column = "recipe"),                                        // could be null
            @Result(property = "linkToImg", column = "linkToImg"),                                  // could be null
            @Result(property = "incision", column = "incisionId",                                   // could be null
                    javaType = com.models.Incision.class,
                    one = @One(select = "com.mappers.Incision.selectIncisionById")),
            @Result(property = "cake", column = "cakeId", javaType = com.models.Cake.class,         // could be null
                    one = @One(select = "com.mappers.Cake.selectCakeById")),
            @Result(property = "weight", column = "weight"),
            @Result(property = "price", column = "price"),                                          // could be null
            @Result(property = "needDelivery", column = "needDelivery"),
            @Result(property = "address", column = "id", javaType = com.models.Address.class,       // could be null
                    one = @One(select = "com.mappers.AddressMapper.selectAddressByOrderId")),
            @Result(property = "localDateTime", column = "localDateTime", jdbcType= TIMESTAMP,
                    javaType=java.time.LocalDateTime.class),
            @Result(property = "orderStatus", column = "orderStatus",
                    javaType = com.models.OrderStatus.class)
    })
    @Select("SELECT * FROM usercakeorders")
    List<UserCakeOrder> selectUserCakeOrdersFromDB();

    @Select("SELECT * FROM usercakeorders WHERE id = #{id}")
    UserCakeOrder selectUserCakeOrderById(Integer id);

    @Select("SELECT * FROM usercakeorders WHERE userId = #{userId}")
    List<UserCakeOrder> selectUserCakeOrdersByUserId(Integer userId);

    @Select("SELECT * FROM usercakeorders WHERE date = #{localDateTime}")
    List<UserCakeOrder> selectUserCakeOrdersByDate(LocalDateTime localDateTime);

    @Insert("INSERT INTO usercakeorders(recipe, linkToImg, incisionId, cakeId, weight, price, needDelivery, " +
            " localDateTime, orderStatus) VALUES(#{userCakeOrder.recipe}, #{userCakeOrder.linkToImg}," +
            " #{userCakeOrder.incision.getId}, #{userCakeOrder.cake.getId}, #{userCakeOrder.weight}," +
            " #{userCakeOrder.price}, #{userCakeOrder.needDelivery}, #{userCakeOrder.localDateTime}," +
            " #{userCakeOrder.orderStatus.ordinal}, #{userId})")
    @Options(useGeneratedKeys = true)
    boolean insertUserCakeOrderByUserId(@Param("userCakeOrder") UserCakeOrder userCakeOrder, @Param("userId") Integer userId);

    @Update("UPDATE usercakeorders SET recipe =#{recipe}, linkToImg =#{linkToImg}," +
            " incisionId =#{incision.getId}, cakeId =#{cake.getId}, weight =#{weight}," +
            " price =#{price}, needDelivery =#{needDelivery}, localDateTime =#{localDateTime}," +
            " orderStatus =#{orderStatus.ordinal} WHERE id =#{id}")
    boolean updateUserCakeOrderById(UserCakeOrder userCakeOrder);

    @Delete("DELETE FROM usercakeorders WHERE id =#{id}")
    boolean deleteUserCakeOrder(Integer id);
}
