package com.blog.security;


import java.io.IOException;
import java.util.logging.Logger;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
 
@Provider
@PreMatching
public class CorsResponseFilter implements ContainerResponseFilter {
 
    private final static Logger log = Logger.getLogger( CorsResponseFilter.class.getName() );
 
    @Override
    public void filter( ContainerRequestContext requestCtx, ContainerResponseContext responseCtx ) throws IOException {
        log.info( "Executing REST response filter" );
 
        responseCtx.getHeaders().add( "Access-Control-Allow-Origin", "*" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Credentials", "true" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
        responseCtx.getHeaders().add("Access-Control-Allow-Headers", "X-PINGOTHER, Content-Type, Authorization, Content-Length, X-Requested-With");
        responseCtx.getHeaders().add("Access-Control-Expose-Headers", "Content-Type, Authorization, Content-Length");
    }
}