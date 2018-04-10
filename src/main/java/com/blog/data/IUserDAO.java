package com.blog.data;

import com.blog.api.User;

public interface IUserDAO {
	public void addUser(User user);

	public void editUser(User user);

	public User getUserDetails(String userName);
}
