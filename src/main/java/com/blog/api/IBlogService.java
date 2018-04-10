package com.blog.api;

import java.util.List;

public interface IBlogService {

public void addBlog(Blog blog);

public void editBlog(Blog blog);

public List<Blog> getAllBlogs();

public Blog getBlog(User user);

}
