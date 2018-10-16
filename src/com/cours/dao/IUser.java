package com.cours.dao;

import com.cours.entities.User;

import java.util.List;

public interface IUser {
    public User connection(String email, String password);
    public int add(User user);
    public int delete(int id);
    public int update(User user);
    public User get(int id);
    public List<User> list();
}
