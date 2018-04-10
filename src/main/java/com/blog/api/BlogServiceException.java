package com.blog.api;

public class BlogServiceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum BlogError {
		BLOG_CONTENT_EMPTY("Blog content is empty."),
		USER_NAME_EMPTY("User name is empty."),
		COMMENT_CONTENT_EMPTY("Comment content is empty."),
		INTERNAL_SERVER_ERROR("Internal server error");
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
