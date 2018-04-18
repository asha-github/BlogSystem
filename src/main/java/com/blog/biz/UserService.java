package com.blog.biz;

import java.util.logging.Logger;

import com.blog.api.BlogServiceException;
import com.blog.api.IUserService;
import com.blog.api.User;
import com.blog.data.IUserDAO;
import com.blog.data.JpaUserDAO;
import com.blog.security.JWTTokenUtil;

public class UserService implements IUserService {
	private static final Logger logger = Logger.getLogger(UserService.class.getSimpleName());
	private IUserDAO dao = new JpaUserDAO();

	@Override
	public void addUser(User user) {
		logger.info("\nNew user details received!!");
		if (user == null || user.getUserName().trim().isEmpty()) {
			throw new BlogServiceException(BlogServiceException.BlogError.USER_NAME_EMPTY);
		}
		dao.addUser(user);
		logger.info(
				"\nNew user created with name - " + user.getUserName() + " with profile name " + user.getProfileName());
	}

	@Override
	public void editUser(String userName, User user) {
		logger.info("\nRequest for user update received!!");
		if (user == null || user.getPassword().trim().isEmpty()) {
			throw new BlogServiceException(BlogServiceException.BlogError.PASSWORD_EMPTY);
		}
		boolean isEditSuccessful = dao.editUser(userName, user);
		if (isEditSuccessful) {
			logger.info("\nBlog with ID - " + user.getUserName() + " is updated ");
		} else {
			throw new BlogServiceException(BlogServiceException.BlogError.USER_UPDATE_FAILED);
		}
	}

	@Override
	public User getUserDetails(String userName) {
		return dao.getUserDetails(userName);
	}

	@Override
	public String authenticateUser(User user) {
		String token = null;
		logger.info("\nAuthenticate request for user received!!");
		if (dao.isValidUser(user)) {
			token = JWTTokenUtil.issueToken(user.getUserName());
		} else {
			throw new BlogServiceException(BlogServiceException.BlogError.USER_NOT_FOUND);
		}
		return token;
	}

}
