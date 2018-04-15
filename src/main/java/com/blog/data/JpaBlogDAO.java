package com.blog.data;

import java.util.List;

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
	public boolean editBlog(long blogId, Blog blog) {
		boolean isEditSuccessful = false;
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Blog blogFromDb = em.find(Blog.class, blogId);
		if(blogFromDb != null) {
			blogFromDb.setBlogContent(blog.getBlogContent());
			blogFromDb.setBlogTitle(blog.getBlogTitle());
			em.getTransaction().commit();
			isEditSuccessful = true;
		}else {
			em.getTransaction().rollback();
		}
		em.close();
		return isEditSuccessful;
	}

	@Override
	public List<Blog> getAllBlogs(){
		em = emf.createEntityManager();
		List<Blog> list = em.createQuery("from " + Blog.class.getName()+" order by publishDate")
				.getResultList();
		em.close();
		return list;
	}

	@Override
	public Blog getBlog(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
