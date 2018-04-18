package com.blog.data;

import com.blog.api.User;

public interface IUserDAO {
	public void addUser(User user);

	public boolean editUser(String userName, User user);

	public User getUserDetails(String userName);

	public boolean isValidUser(User user);
}
