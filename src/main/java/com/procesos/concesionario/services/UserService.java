package com.procesos.concesionario.services;

import com.procesos.concesionario.models.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    List<User> allUser();
    User createUser(User user);
    User updateUser(long id,User user);
}
