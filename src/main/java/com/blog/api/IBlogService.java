package com.blog.api;

import java.util.List;

public interface IBlogService {

public void addBlog(Blog blog);

public void editBlog(long blogId, Blog blog);

public List<Blog> getAllBlogs();

public List<Blog> searchBlogs(String key);

public Blog getBlog(User user);

public Blog getBlogDetails(long blogId);

}
