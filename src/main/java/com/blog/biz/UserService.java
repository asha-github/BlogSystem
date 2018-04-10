package com.blog.biz;

import java.util.logging.Logger;

import com.blog.api.BlogServiceException;
import com.blog.api.IUserService;
import com.blog.api.User;
import com.blog.data.IUserDAO;
import com.blog.data.JpaUserDAO;

public class UserService implements IUserService {
	private static final Logger logger = Logger.getLogger(UserService.class.getSimpleName());
	private IUserDAO dao = new JpaUserDAO();
	@Override
	public void addUser(User user) {
		logger.info("\nNew blog received!!");
		if (user == null || user.getUserName().trim().isEmpty()) {
			throw new BlogServiceException(BlogServiceException.BlogError.USER_NAME_EMPTY); 
		}
		dao.addUser(user);
		logger.info("\nNew user created with name - "+user.getUserName() +" with profile name "+user.getProfileName());
	}

	@Override
	public void editUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserDetails(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
