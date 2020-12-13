package com.ustc.dao;

import com.ustc.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    List<User> findAll() throws IOException;
    User findById(int id);
    void add2(User user);
}
