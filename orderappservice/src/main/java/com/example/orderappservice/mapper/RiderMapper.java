package com.example.orderappservice.mapper;

import com.example.orderappservice.bean.RiderForM;
import com.example.orderappservice.pojo.Login;
import com.example.orderappservice.pojo.Rider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RiderMapper {

    @Select("select * from rider where rider_id = #{rider_id}")
    @Results({
            @Result(property = "rider_id", column = "rider_id")
    })
    Rider getRiderInfo(@Param("rider_id") Integer rider_id);

    @Update("update `rider` set sex = #{sex},password = #{password},nick_name=#{nick_name} where rider_id = #{rider_id}")
    int updateRiderByRiderId(@Param("sex") String sex,@Param("nick_name") String nick_name,@Param("password") String password,@Param("rider_id") Integer rider_id);


    @Select("select rider_id, name, phone_number from rider where rider_id = #{rider_id}")
    @Results({
            @Result(property = "rider_id", column = "rider_id"),
            @Result(property = "rider_name", column = "name"),
            @Result(property = "rider_phone", column = "phone_number")
    })
    RiderForM getRiderForMByRiderId(Integer rider_id);

    @Select("select * from rider where rider_id = #{rider_id}")
    @Results({
            @Result(property = "rider_id", column = "rider_id")
    })
    Rider getRiderByRiderId(Integer rider_id);
}
