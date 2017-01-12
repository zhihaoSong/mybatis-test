package com.szh.mapper;

import com.szh.po.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    public Role getRole(Long id);

    public Role getRoleToHandler(Long id);

    public Role findRoleByAnnotation(@Param("roleName") String roleName, @Param("note") String note);

    public int addRoleParam(@Param("roleName") String roleName, @Param("note") String note);

    public int addRole(Role role);

    public int deleteRole(Long id);

}