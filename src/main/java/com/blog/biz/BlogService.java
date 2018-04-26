package com.blog.biz;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.blog.api.Blog;
import com.blog.api.BlogServiceException;
import com.blog.api.IBlogService;
import com.blog.data.IBlogDAO;
import com.blog.data.JpaBlogDAO;

public class BlogService implements IBlogService {
	private static final Logger logger = Logger.getLogger(BlogService.class.getSimpleName());
	private JpaBlogDAO dao = new JpaBlogDAO();
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
	public void editBlog(long blogId, Blog blog) {
		logger.info("\nRequest for blog update received!!");
		if (blog == null || blog.getBlogContent().trim().isEmpty()) {
			throw new BlogServiceException(BlogServiceException.BlogError.BLOG_CONTENT_EMPTY); 
		}
		boolean isEditSuccessful = dao.editBlog(blogId, blog);
		if(isEditSuccessful) {
		logger.info("\nBlog with ID - "+blog.getBlogId() +" is updated with content "+blog.getBlogContent());
		}else {
			throw new BlogServiceException(BlogServiceException.BlogError.BLOG_UPDATE_FAILED); 
		}
	}

	@Override
	public List<Blog> getAllBlogs(){
		List<Blog> blogs = dao.getAllBlogs();
		return blogs;
	}
	@Override
	public List<Blog> searchBlogs(String key) {
		logger.info("\nRequest for search blog received with search key - "+key);
		List<Blog> blogs = null;
		if(key != null && !key.isEmpty()) {
			blogs = dao.searchBlogs(key);
		} else {
			throw new BlogServiceException(BlogServiceException.BlogError.SEARCH_KEY_NOT_PROVIDED); 
		}
		return blogs;
	}
	@Override
	public List<Blog> getBlogsByUser(String userName) {
		logger.info("\nRequest for blog for user "+userName + " received.");
		List<Blog> blogs = null;
		if(userName != null && !userName.isEmpty()) {
			blogs = dao.getBlogsByUser(userName);
		} else {
			throw new BlogServiceException(BlogServiceException.BlogError.USER_NAME_EMPTY); 
		}
		return blogs;
	}
	@Override
	public Blog getBlogDetails(long blogId){
		Blog blog =  dao.getBlogDetails(blogId);
		if (blog == null || blog.getBlogContent().trim().isEmpty()) {
			throw new BlogServiceException(BlogServiceException.BlogError.BLOG_NOT_FOUND); 
		}
		return blog;
	}

}
