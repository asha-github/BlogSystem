package com.blog.biz;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.blog.api.Blog;
import com.blog.api.BlogServiceException;
import com.blog.data.JpaBlogDAO;

import junit.framework.TestCase;

@RunWith(PowerMockRunner.class)
@PrepareForTest({JpaBlogDAO.class,BlogService.class})
public class BlogServiceTest extends TestCase {
	JpaBlogDAO mockedJpaBlogDAO;
	@Before
    public void setUp() throws Exception {
	     mockedJpaBlogDAO = PowerMockito.mock(JpaBlogDAO.class);
		PowerMockito.whenNew(JpaBlogDAO.class).withNoArguments().thenReturn(mockedJpaBlogDAO);
    }

	@Test
	public void test_addBlog() throws Exception {

		String content = "BlogContent";
		String title = "BlogTitle";
		Blog blog = new Blog();
		blog.setBlogContent(content);
		blog.setBlogTitle(title);
		//set user id
		blog.setUserId("bloguser");

		BlogService blogService = new BlogService();

		blogService.addBlog(blog);

		Mockito.verify(mockedJpaBlogDAO).addBlog(blog);
	}

	@Test(expected = BlogServiceException.class)
	public void test_addBlog_WithEmptyBlog() {
		BlogService blogService = new BlogService();

		blogService.addBlog(null);

		Mockito.verify(mockedJpaBlogDAO, Mockito.times(0)).addBlog(Mockito.any());
	}
}
