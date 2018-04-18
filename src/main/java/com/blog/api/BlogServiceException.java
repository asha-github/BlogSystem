package com.blog.api;

public class BlogServiceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum BlogError {
		BLOG_CONTENT_EMPTY("Blog content is empty."),
		BLOG_NOT_FOUND("Blog not found."),
		USER_NAME_EMPTY("User name is empty."),
		PASSWORD_EMPTY("Password is empty."),
		USER_NOT_FOUND("User not found. Please check user name and password."),
		AUTH_HEADER_NOT_FOUND("Authorization header must be provided"),
		COMMENT_CONTENT_EMPTY("Comment content is empty."),
		INTERNAL_SERVER_ERROR("Internal server error"),
		SEARCH_KEY_NOT_PROVIDED("Search key is not provided"),
		USER_UPDATE_FAILED("User update failed."),
		BLOG_UPDATE_FAILED("Blog update failed.");
		private String errorMessage;
		BlogError(String msg) {
			this.errorMessage = msg;
		}
	}
	public BlogServiceException(BlogError error) {
		super(error.errorMessage);
	}
	public BlogServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BlogServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public BlogServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
