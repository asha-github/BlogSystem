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
import com.blog.security.JWTTokenNeeded;

@Path("/blogService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON })
public class BlogRootResource {
	private static final Logger logger = Logger.getLogger(BlogRootResource.class.getSimpleName());
	private IBlogService blogService = new BlogService();

	
	@POST
	@Path("/blog")
	@JWTTokenNeeded
	public Response addBlog(Blog blog) {
		try {
			logger.info("Create request received for blog");
			blogService.addBlog(blog);
			return Response.status(Response.Status.CREATED).entity(blog).header("Access-Control-Allow-Origin", "*").build();
		} catch (BlogServiceException e) {
			throw e;
		}catch (Exception e) {
			logger.info("Exception  - "+e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*").build();
		}
	}
	@PUT
	@Path("/blog/{blogId}")
	@JWTTokenNeeded
	public Response editBlog(@PathParam("blogId") long blogId, Blog blog) {
		try {
			logger.info("Update request received for blog");
			blogService.editBlog(blogId, blog);
			return Response.status(Response.Status.OK).entity(blog).header("Access-Control-Allow-Origin", "*").build();
		} catch (BlogServiceException e) {
			throw e;
		}catch (Exception e) {
			logger.info("Exception  - "+e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*").build();
		}
	}

	@GET
	@Path("/blogs")
	public Response getAllBlogs() {
		try {
			List<Blog> blogs = blogService.getAllBlogs();
			return Response.ok().entity(blogs).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			logger.info("Exception  - "+e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@GET
	@Path("/search")
	public Response search(@QueryParam("key") @DefaultValue("") String searchKey) {
		try {
		List<Blog> blogs = blogService.searchBlogs(searchKey);
		return Response.ok().entity(blogs).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			logger.info("Exception  - "+e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@GET
	@Path("/blog")
	public Response getBlogDetails(@QueryParam("blogId") long blogId) {
		try {
		Blog blog = blogService.getBlogDetails(blogId);
		return Response.ok().entity(blog).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			logger.info("Exception  - "+e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@GET
	@Path("/blogsByUser")
	public Response getBlogsByUser(@QueryParam("user") String userName) {
		try {
		List<Blog> blogs = blogService.getBlogsByUser(userName);
		return Response.ok().entity(blogs).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			logger.info("Exception  - "+e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*").build();
		}
	}
}
