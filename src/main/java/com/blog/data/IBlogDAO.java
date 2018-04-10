package com.blog.data;

import java.util.List;

import com.blog.api.Blog;
import com.blog.api.User;

public interface IBlogDAO {
	public void addBlog(Blog blog);

	public void editBlog(Blog blog);

	public List<Blog> getAllBlogs();

	public Blog getBlog(User user);
}
