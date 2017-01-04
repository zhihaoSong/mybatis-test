package com.szh.mapper;

import com.szh.po.Role;

public interface RoleMapper {
    public Role getRole(Long id);

    public Role addRole(String roleName, String note);

    public int addRole(Role role);

    public int deleteRole(Long id);

}