package com.mappers;

import com.models.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AddressMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "region", column = "region"),
            @Result(property = "city", column = "city"),                    // could be null
            @Result(property = "district", column = "district"),            // could be null
            @Result(property = "village", column = "village"),              // could be null
            @Result(property = "street", column = "street"),                // could be null
            @Result(property = "house", column = "house"),                  // could be null
            @Result(property = "flat", column = "flat"),                    // could be null
            @Result(property = "restaurant", column = "restaurant")         // could be null
    })
    @Select("SELECT * FROM addresses")
    List<Address> selectAddressesFromDB();

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "region", column = "region"),
            @Result(property = "city", column = "city"),                    // could be null
            @Result(property = "district", column = "district"),            // could be null
            @Result(property = "village", column = "village"),              // could be null
            @Result(property = "street", column = "street"),                // could be null
            @Result(property = "house", column = "house"),                  // could be null
            @Result(property = "flat", column = "flat"),                    // could be null
            @Result(property = "restaurant", column = "restaurant")         // could be null
    })
    @Select("SELECT * FROM addresses WHERE userCakeOrderId = #{userCakeOrderId}")
    Address selectAddressByOrderId(Integer userCakeOrderId);

    @Select("SELECT * FROM addresses WHERE id =#{id}")
    Address selectAddressesById(Integer id);

    @Insert("INSERT INTO addresses(region, city, district, village, street, house, flat, restaurant, userCakeOrderId})" +
            " VALUES(#{address.region}, #{address.city}, #{address.district}, #{address.village}, #{address.street}," +
            " #{address.house}, #{address.flat}, #{address.restaurant}, #{orderId})")
    boolean insertAddressByOrderId(@Param("address") Address address, @Param("orderId") Integer orderId);

    @Update("UPDATE addresses SET region =#{region}, city =#{city}, district =#{district}," +
            " village =#{village}, street =#{street}, house =#{house}, flat =#{flat}, restaurant =#{restaurant}" +
            " WHERE id =#{id}")
    boolean updateAddress(Address address);

    @Delete("DELETE FROM addresses WHERE id =#{id}")
    boolean deleteAddress(Integer id);
}
