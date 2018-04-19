package com.blog.api;

import java.util.List;

public interface ICommentsService {

public void addComment(Comment comment);

public void editComment(long commentId, Comment comment);

public List<Comment> getCommentsForBlog(long blogId);


}
