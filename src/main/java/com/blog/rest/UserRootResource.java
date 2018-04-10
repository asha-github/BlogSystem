package com.blog.rest;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blog.api.BlogServiceException;
import com.blog.api.IUserService;
import com.blog.api.User;
import com.blog.biz.UserService;

@Path("/userService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON })
public class UserRootResource {
	private static final Logger logger = Logger.getLogger(UserRootResource.class.getSimpleName());
	private IUserService userService = new UserService();

	@POST
	@Path("/user")
	public Response addBlog(User user) {
		try {
			userService.addUser(user);
			return Response.status(201).entity(user).build();
		} catch (BlogServiceException e) {
			throw e;
		}catch (Exception e) {
			logger.info("Exception  - "+e);
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
