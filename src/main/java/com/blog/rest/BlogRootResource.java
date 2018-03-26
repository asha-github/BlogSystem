package com.blog.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
	private IBlogService blogService = new BlogService();

	@POST
	@Path("/blog")
	public Response addBlog(Blog blog) {
		try {
			blogService.addBlog(blog);
			//return Response.created(new URI(blog.getBlogId() + "")).build();
			return Response.status(201).entity(blog).build();
		} catch (BlogServiceException e) {
			throw e;
		}catch (Exception e) {
			throw new BlogServiceException(BlogServiceException.BlogError.INTERNAL_SERVER_ERROR);
		}
	}

//	@GET
//	@Path("/book/{isbn}")
//	public Response find(@PathParam("isbn") int isbn) {
//		Book book = library.find(isbn);
//		return Response.ok().entity(book).build();
//	}
//
//	@GET
//	@Path("/book")
//	public Response search(@QueryParam("key") @DefaultValue("") String key) {
//		List<Book> books = library.search(key);
//		return Response.ok().entity(books).build();
//	}
}
