package com.blog.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blog.api.Blog;
import com.blog.api.BlogServiceException;
import com.blog.api.Comment;
import com.blog.api.ICommentsService;
import com.blog.biz.CommentsService;
import com.blog.security.JWTTokenNeeded;

//@Path("/commentService")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces({ MediaType.APPLICATION_JSON })
public class CommentsRootResource {
	private static final Logger logger = Logger.getLogger(CommentsRootResource.class.getSimpleName());
	private ICommentsService commentService = new CommentsService();
//
//	@POST
//	@Path("/comment")
//	@JWTTokenNeeded
//	public Response addComment(Comment comment) {
//		try {
//			commentService.addComment(comment);
//			return Response.status(Response.Status.CREATED).entity(comment).header("Access-Control-Allow-Origin", "*").build();
//		} catch (BlogServiceException e) {
//			throw e;
//		}catch (Exception e) {
//			logger.info("Exception  - "+e);
//			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*").build();
//		}
//	}
//	@PUT
//	@Path("/comment/{commentId}")
//	@JWTTokenNeeded
//	public Response editComment(@PathParam("commentId") long commentId, Comment comment) {
//		try {
//			logger.info("Update request received for blog");
//			commentService.editComment(commentId, comment);
//			return Response.status(Response.Status.OK).entity(comment).header("Access-Control-Allow-Origin", "*").build();
//		} catch (BlogServiceException e) {
//			throw e;
//		}catch (Exception e) {
//			logger.info("Exception  - "+e);
//			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*").build();
//		}
//	}
//	@GET
//	@Path("/commentsForBlog")
//	public Response getCommentsForBlog(@QueryParam("blogId") long blogId) {
//		try {
//		List<Comment> comments = commentService.getCommentsForBlog(blogId);
//		return Response.ok().entity(comments).header("Access-Control-Allow-Origin", "*").build();
//		} catch (Exception e) {
//			logger.info("Exception  - "+e);
//			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*").build();
//		}
//	}
}
