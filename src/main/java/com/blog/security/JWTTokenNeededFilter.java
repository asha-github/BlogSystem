package com.blog.security;

import java.io.IOException;
import java.security.Key;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.blog.api.BlogServiceException;

import io.jsonwebtoken.Jwts;

@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenNeededFilter implements ContainerRequestFilter {
	private static final Logger logger = Logger.getLogger(JWTTokenNeededFilter.class.getSimpleName());

	private KeyGenerator keyGenerator = SimpleKeyGenerator.getInstance();

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String token = null;
		try {
			String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
			logger.info("AuthorizationHeader : " + authorizationHeader);

			if (authorizationHeader == null || authorizationHeader.isEmpty()) {
				logger.severe("Invalid authorizationHeader : " + authorizationHeader);
				throw new BlogServiceException(BlogServiceException.BlogError.AUTH_HEADER_NOT_FOUND);
			}

			token = authorizationHeader.trim();

			// Validate the token
			Key key = keyGenerator.generateKey();
			logger.info("Key : " + key);
			Jwts.parser().setSigningKey(key).parseClaimsJws(token);
			logger.info("Valid token : " + token);

		} catch (Exception e) {
			logger.severe("Exception e  : " + e);
			logger.severe("Invalid token : " + token);
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}
}