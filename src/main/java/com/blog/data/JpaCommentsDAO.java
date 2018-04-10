package com.blog.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.blog.api.Comment;

public class JpaCommentsDAO implements ICommentsDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("blogdb");
	private EntityManager em;
	@Override
	public void addComment(Comment comment) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(comment);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void editComment(Comment comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Comment> getComments(long blogId) {
		// TODO Auto-generated method stub
		return null;
	}

}
