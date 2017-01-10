package com.szh.mapper;

import com.szh.po.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Delete({
        "delete from tb_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_user (id, user_name, ",
        "birthday, sex, ",
        "email, mobile, note, ",
        "create_date, update_date)",
        "values (#{id,jdbcType=INTEGER}, #{user_name,jdbcType=VARCHAR}, ",
        "#{birthday,jdbcType=TIMESTAMP}, #{sex,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR}, ",
        "#{create_date,jdbcType=TIMESTAMP}, #{update_date,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    int insertSelective(User record);

    @Select({
        "select",
        "id, user_name, birthday, sex, email, mobile, note, create_date, update_date",
        "from tb_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update tb_user",
        "set user_name = #{user_name,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=TIMESTAMP},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
          "create_date = #{create_date,jdbcType=TIMESTAMP},",
          "update_date = #{update_date,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}