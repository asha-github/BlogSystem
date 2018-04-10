package com.blog.biz;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.blog.api.BlogServiceException;
import com.blog.api.Comment;
import com.blog.api.ICommentsService;
import com.blog.data.ICommentsDAO;
import com.blog.data.JpaCommentsDAO;

public class CommentsService implements ICommentsService {
	private static final Logger logger = Logger.getLogger(BlogService.class.getSimpleName());
	private ICommentsDAO dao = new JpaCommentsDAO();
	@Override
	public void addComment(Comment comment) {
		logger.info("\nNew comment received!!");
		if (comment == null || comment.getCommentContent().trim().isEmpty()) {
			throw new BlogServiceException(BlogServiceException.BlogError.COMMENT_CONTENT_EMPTY);
		}
		comment.setCommentAddedDate(new Date());
		dao.addComment(comment);
		logger.info("\nNew comment created with ID - "+comment.getCommentId() +" for blog "+comment.getBlogId() +" with content "+comment.getCommentContent()+" and comment added date is "+comment.getCommentContent());
	
	}

	@Override
	public void editComment(Comment comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Comment> getComments(long blogId) {
		// TODO Auto-generated method stub
		return null;

	}

}
