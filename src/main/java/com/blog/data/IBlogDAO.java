package com.blog.data;

import java.util.List;

import com.blog.api.Blog;

public interface IBlogDAO {
	public void addBlog(Blog blog);

	public boolean editBlog(long blogId, Blog blog);

	public List<Blog> getAllBlogs();
	
	public List<Blog> searchBlogs(String key);

	public List<Blog> getBlogsByUser(String userName);
	
	public Blog getBlogDetails(long blogId);
}
