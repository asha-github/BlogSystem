package com.blog.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.blog.api.Blog;
import com.blog.api.User;

public class JpaUserDAO implements IUserDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("blogdb");
	private EntityManager em;

	@Override
	public void addUser(User user) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public boolean editUser(String userName, User user) {
		boolean isEditSuccessful = false;
		em = emf.createEntityManager();
		em.getTransaction().begin();
		User userFromDb = em.find(User.class, userName);
		if(userFromDb != null) {
			userFromDb.setPassword(user.getPassword());
			userFromDb.setProfileName(user.getProfileName());
			em.getTransaction().commit();
			isEditSuccessful = true;
		}else {
			em.getTransaction().rollback();
		}
		em.close();
		return isEditSuccessful;
	}

	@Override
	public User getUserDetails(String userName) {
		em = emf.createEntityManager();
		User userFromDb = em.find(User.class, userName);
		em.close();
		return userFromDb;
	}
	@Override
	public boolean isValidUser(User user) {
		boolean isValidUser = false;
		em = emf.createEntityManager();
		TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_LOGIN_PASSWORD, User.class);
        query.setParameter("userName", user.getUserName());
        query.setParameter("password", user.getPassword());
        User userFromDb = query.getSingleResult();

        if (userFromDb != null) {
        	isValidUser = true;
        }
        em.close();
        return isValidUser;
	}
}
