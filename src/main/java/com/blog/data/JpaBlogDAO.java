package com.blog.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.blog.api.Blog;
import com.blog.api.User;

public class JpaBlogDAO implements IBlogDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("blogdb");
	private EntityManager em;

	@Override
	public void addBlog(Blog blog) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(blog);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void editBlog(Blog blog) {
		// TODO Auto-generated method stub

	}

	@Override
	public Blog getBlog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blog getBlog(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
