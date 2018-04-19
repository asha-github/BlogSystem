package com.blog.data;

import java.util.List;

import com.blog.api.Comment;

public interface ICommentsDAO {
	
	public void addComment(Comment comment);

	public void editComment(long commentId, Comment comment);

	public List<Comment> getCommentsForBlog(long blogId);

}
