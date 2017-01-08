package com.szh.mapper;

import com.szh.po.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper2 {
    @Select(value = "select id,role_name as roleName ,note from t_role " +
            "where id=#{id} ")
    public Role getRole(Long id);

    public Role addRole(String roleName, String note);

    public int addRole(Role role);

    public int deleteRole(Long id);

}