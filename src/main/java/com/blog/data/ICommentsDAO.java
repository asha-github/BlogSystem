package com.blog.data;

import java.util.List;

import com.blog.api.Comment;

public interface ICommentsDAO {
	
	public void addComment(Comment comment);

	public void editComment(Comment comment);

	public List<Comment> getComments(long blogId);
}
