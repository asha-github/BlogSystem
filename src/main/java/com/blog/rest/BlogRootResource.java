package com.blog.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
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
import com.blog.api.IBlogService;
import com.blog.biz.BlogService;

@Path("/blogService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON })
public class BlogRootResource {
	private static final Logger logger = Logger.getLogger(BlogRootResource.class.getSimpleName());
	private IBlogService blogService = new BlogService();

	
	@POST
	@Path("/blog")
	public Response addBlog(Blog blog) {
		try {
			logger.info("Create request received for blog");
			blogService.addBlog(blog);
			return Response.status(Response.Status.CREATED).entity(blog).build();
		} catch (BlogServiceException e) {
			throw e;
		}catch (Exception e) {
			logger.info("Exception  - "+e);
			throw new BlogServiceException(BlogServiceException.BlogError.INTERNAL_SERVER_ERROR);
		}
	}
	@PUT
	@Path("/blog/{blogId}")
	public Response editBlog(@PathParam("blogId") long blogId, Blog blog) {
		try {
			logger.info("Update request received for blog");
			blogService.editBlog(blogId, blog);
			return Response.status(Response.Status.OK).entity(blog).build();
		} catch (BlogServiceException e) {
			throw e;
		}catch (Exception e) {
			logger.info("Exception  - "+e);
			throw new BlogServiceException(BlogServiceException.BlogError.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Path("/blogs")
	public Response getAllBlogs(@QueryParam("locator") @DefaultValue("1") int locator) {
		List<Blog> blogs = blogService.getAllBlogs();
		return Response.ok().entity(blogs).build();
	}
}
