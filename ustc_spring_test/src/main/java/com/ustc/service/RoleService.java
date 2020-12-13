package com.ustc.service;

import com.ustc.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleList();

    boolean save(Role role);
}
