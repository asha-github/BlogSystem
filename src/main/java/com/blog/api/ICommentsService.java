package com.blog.api;

import java.util.List;

public interface ICommentsService {

public void addComment(Comment comment);

public void editComment(Comment comment);

public List<Comment> getComments(long blogId);


}
