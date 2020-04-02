package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) " +
            "values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where account_id = #{accountId} limit 1")
    User findById(@Param("accountId") String accountId);

    @Update("update user set name=#{name}, token=#{token}, gmt_modified=#{gmtModified},avatar_url=#{avatarUrl}" +
            "where account_id = #{accountId};")
    void update(User user);

    //@Select("select * from user where account_id = #{accountId}")
    //User findByAccountId(String accountId);
}
