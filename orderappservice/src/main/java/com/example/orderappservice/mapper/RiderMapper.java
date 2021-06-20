package com.example.orderappservice.mapper;

<<<<<<< HEAD
import com.example.orderappservice.bean.MRider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RiderMapper {
    //骑手列表
    @Select("select rider_id,name,phone_number,password from rider where rider_state='on'")
    @Results({
            @Result(property = "rider_id", column = "rider_id"),
            @Result(property = "totalOrder",column = "rider_id",
            one = @One(select = "com.example.orderappservice.mapper.OrderMapper.getOrderCountByRiderId"))
    })
    List<MRider> getRiderList();

    //添加骑手信息
    @Insert(value = "insert into rider(rider_id,name,phone_number,password,rider_state) " +
            "values (#{r.rider_id},#{r.name},#{r.phoneNumber},#{r.password},'on')")
    //设置主键自增
    @Options(useGeneratedKeys = true,keyProperty = "rider_id",keyColumn = "rider_id")
    int addRider(@Param("r") MRider mRider);

    //根据id查询骑手
    @Select("select rider_id,name,phone_number,password,rider_state from rider " +
            "where rider_id=#{rider_id}")
    @Results({
            @Result(property = "rider_id", column = "rider_id"),
            @Result(property = "totalOrder",column = "rider_id",
                    one = @One(select = "com.example.orderappservice.mapper.OrderMapper.getOrderCountByRiderId"))
    })
    MRider getRiderByRiderId(Integer rider_id);

    //删除骑手
    @Update("update rider set rider_state='off' where rider_id=#{rider_id}")
    int deleteRiderByRiderId(@Param("rider_id") Integer rider_id);
//    @Delete("delete from rider where rider_id=#{rider_id}")
//    int deleteRider(Integer rider_id);

    //骑手数量
    @Select("select count(rider_id) as totalOrder from `rider`")
    int getRiderCount();
=======
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

    @Update("update `rider` set sex = #{sex},password = #{password},nick_name=#{nick_name},advatar=#{advatar}  where rider_id = #{rider_id}")
    int updateRiderByRiderId(@Param("sex") String sex,@Param("nick_name") String nick_name, @Param("password") String password,
                             @Param("advatar") String advatar,@Param("rider_id") Integer rider_id);


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
>>>>>>> origin/master
}
