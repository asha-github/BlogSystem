package com.blog.rest;

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
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blog.api.BlogServiceException;
import com.blog.api.IUserService;
import com.blog.api.User;
import com.blog.biz.UserService;
import com.blog.security.JWTTokenNeeded;

@Path("/userService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON })
public class UserRootResource {
	private static final Logger logger = Logger.getLogger(UserRootResource.class.getSimpleName());
	private IUserService userService = new UserService();

	@POST
	@Path("/user")
	public Response addUser(User user) {
		try {
			userService.addUser(user);
			return Response.status(Response.Status.CREATED).entity(user).build();
		} catch (BlogServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.info("Exception  - " + e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@POST
	@Path("/login")
	public Response authenticateUser(User user) {
		try {
			// Authenticate the user using the credentials provided
			String token = userService.authenticateUser(user);
			// Return the token on the response
			return Response.ok().header(HttpHeaders.AUTHORIZATION, token).build();
		} catch (Exception e) {
			logger.info("Exception  - " + e);
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

	@PUT
	@Path("/user/{userName}")
	@JWTTokenNeeded
	public Response editUser(@PathParam("userName") String userName, User user) {
		try {
			logger.info("Update request received for user");
			userService.editUser(userName, user);
			return Response.status(Response.Status.OK).entity(user).build();
		} catch (BlogServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.info("Exception  - " + e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Path("/user")
	@JWTTokenNeeded
	public Response getUser(@QueryParam("userName") @DefaultValue("") String userName) {
		try {
			User user = userService.getUserDetails(userName);
			return Response.ok().entity(user).build();
		} catch (Exception e) {
			logger.info("Exception  - " + e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
