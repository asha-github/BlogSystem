package com.blog.biz;

import java.util.Date;
import java.util.logging.Logger;

import com.blog.api.Blog;
import com.blog.api.BlogServiceException;
import com.blog.api.IBlogService;
import com.blog.api.User;
import com.blog.data.IBlogDAO;
import com.blog.data.JpaBlogDAO;

public class BlogService implements IBlogService {
	private static final Logger logger = Logger.getLogger(BlogService.class.getSimpleName());
	private IBlogDAO dao = new JpaBlogDAO();
	@Override
	public void addBlog(Blog blog) {
		logger.info("\nNew blog received!!");
		if (blog == null || blog.getBlogContent().trim().isEmpty()) {
			throw new BlogServiceException(BlogServiceException.BlogError.BLOG_CONTENT_EMPTY); 
		}
		blog.setPublishDate(new Date());
		dao.addBlog(blog);
		logger.info("\nNew blog created with ID - "+blog.getBlogId() +" with content "+blog.getBlogContent()+" and published date is "+blog.getPublishDate());
	}

	@Override
	public void editBlog(Blog blog) {
		// TODO Auto-generated method stub

	}

	@Override
	public Blog getBlog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blog getBlog(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
