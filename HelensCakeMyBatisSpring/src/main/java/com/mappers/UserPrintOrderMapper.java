package com.mappers;

import com.models.UserPrintOrder;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

public interface UserPrintOrderMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "linkToImg", column = "linkToImg"),
            @Result(property = "isTight", column = "isTight"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "orderStatus", column = "orderStatus",
                    javaType = com.models.OrderStatus.class),
            @Result(property = "description", column = "description")
    })
    @Select("SELECT * FROM userPrintOrders")
    List<UserPrintOrder> selectUserPrintOrdersFromDB();

    @Select("SELECT * FROM userPrintOrders WHERE id = #{id}")
    UserPrintOrder selectUserPrintOrderById(Integer id);
    
    @Select("SELECT * FROM userPrintOrders WHERE userId = #{userId}")
    List<UserPrintOrder> selectUserPrintOrdersByUserId(Integer userId);

    @Select("SELECT * FROM userPrintOrders WHERE date = #{localDateTime}")
    List<UserPrintOrder> selectUserPrintOrdersByDate(LocalDateTime localDateTime);

    @Insert("INSERT INTO userPrintOrders(linkToImg, isTight, quantity, orderStatus, description, userId" +
            " VALUES(#{userPrintOrder.linkToImg}, #{userPrintOrder.isTight}," +
            " #{userPrintOrder.quantity}, #{userPrintOrder.orderStatus}, #{userPrintOrder.description}, #{userId})")
    boolean insertUserPrintOrderByUserId(@Param("userPrintOrder") UserPrintOrder userPrintOrder, @Param("userId") Integer userId);

    @Update("UPDATE userPrintOrders SET linkToImg =#{linkToImg}," +
            " isTight =#{isTight}, quantity =#{quantity}, orderStatus =#{orderStatus}, description =#{description} WHERE id =#{id}")
    boolean updateUserPrintOrder(UserPrintOrder userPrintOrder);

    @Delete("DELETE FROM userPrintOrders WHERE id =#{id}")
    boolean deleteUserPrintOrder(Integer id);
}
