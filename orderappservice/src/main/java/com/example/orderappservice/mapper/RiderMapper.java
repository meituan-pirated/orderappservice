package com.example.orderappservice.mapper;

import com.example.orderappservice.bean.RiderForM;
import com.example.orderappservice.pojo.Rider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RiderMapper {

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
