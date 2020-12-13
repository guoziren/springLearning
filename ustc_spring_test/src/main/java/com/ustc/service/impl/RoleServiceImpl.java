package com.ustc.service.impl;

import com.ustc.dao.RoleDao;
import com.ustc.domain.Role;
import com.ustc.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> getRoleList() {
        return roleDao.getRoleList();
    }

    public boolean save(Role role) {
        return roleDao.save(role);
    }
}
