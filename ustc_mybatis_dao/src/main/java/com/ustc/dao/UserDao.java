package com.ustc.dao;

import com.ustc.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    List<User> findAll() throws IOException;
}
