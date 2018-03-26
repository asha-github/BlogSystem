package com.blog.data;

import com.blog.api.Blog;
import com.blog.api.User;

public interface IBlogDAO {
	public void addBlog(Blog blog);

	public void editBlog(Blog blog);

	public Blog getBlog();

	public Blog getBlog(User user);
}
