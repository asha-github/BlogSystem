package com.blog.data;

import java.util.List;

import com.blog.api.Blog;
import com.blog.api.User;

public interface IBlogDAO {
	public void addBlog(Blog blog);

	public boolean editBlog(long blogId, Blog blog);

	public List<Blog> getAllBlogs();
	
	public List<Blog> searchBlogs(String key);

	public Blog getBlog(User user);
	public Blog getBlogDetails(long blogId);
}
