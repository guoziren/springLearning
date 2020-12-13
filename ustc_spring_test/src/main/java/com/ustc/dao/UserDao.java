package com.ustc.dao;


import com.ustc.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

}
