package com.ustc.dao;

import com.ustc.domain.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getRoleList();

    boolean save(Role role);

    List<Role> findRoleByUserId(Long id);
}
