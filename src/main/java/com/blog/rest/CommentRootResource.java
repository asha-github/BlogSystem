package com.blog.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blog.api.BlogServiceException;
import com.blog.api.Comment;
import com.blog.api.ICommentsService;
import com.blog.biz.CommentsService;

@Path("/commentService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON })
public class CommentRootResource {
	private ICommentsService commentService = new CommentsService();

	@POST
	@Path("/comment")
	public Response addComment(Comment comment) {
		try {
			commentService.addComment(comment);
			return Response.status(201).entity(comment).build();
		} catch (BlogServiceException e) {
			throw e;
		}catch (Exception e) {
			throw new BlogServiceException(BlogServiceException.BlogError.INTERNAL_SERVER_ERROR);
		}
	}

//	@GET
//	@Path("/book/{isbn}")
//	public Response findBlog(@PathParam("blogId") int blogId) {
//		Blog blog = blogService.findBlog(blogId);
//		return Response.ok().entity(blog).build();
//	}
//
//	@GET
//	@Path("/book")
//	public Response search(@QueryParam("key") @DefaultValue("") String key) {
//		List<Blog> blogs = blogService.search(key);
//		return Response.ok().entity(blogs).build();
//	}
}
