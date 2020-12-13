package com.ustc.dao.impl;

import com.ustc.dao.RoleDao;
import com.ustc.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Role> getRoleList() {
        if (jdbcTemplate != null){
            List<Role> list = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
            return list;
        }
        return null;
    }

    public boolean save(Role role) {
        jdbcTemplate.update("insert into sys_role values (?, ?, ?)", null, role.getRoleName(), role.getRoleDesc());
        return true;
    }

    public List<Role> findRoleByUserId(Long id) {
        List<Role> roles = jdbcTemplate.query("select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return roles;
    }
}
