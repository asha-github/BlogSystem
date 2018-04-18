package com.blog.api;

public interface IUserService {

public void addUser(User user);

public String authenticateUser(User user);

public void editUser(String userName, User user);

public User getUserDetails(String userName);

}
