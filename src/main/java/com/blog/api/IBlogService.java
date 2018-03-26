package com.blog.api;

public interface IBlogService {

public void addBlog(Blog blog);

public void editBlog(Blog blog);

public Blog getBlog();

public Blog getBlog(User user);

}
