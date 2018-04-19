package com.blog.data;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.blog.api.Blog;
import com.blog.api.User;
import com.blog.rest.BlogRootResource;

public class JpaBlogDAO implements IBlogDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("blogdb");
	private EntityManager em;
	private static final Logger logger = Logger.getLogger(JpaBlogDAO.class.getSimpleName());
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
		List<Blog> list = em.createQuery("from " + Blog.class.getName()+" order by publishDate DESC")
				.getResultList();
		em.close();
		return list;
	}
	@Override
	public List<Blog> searchBlogs(String key) {
		em = emf.createEntityManager();
		TypedQuery<Blog> query = em.createNamedQuery(Blog.SEARCH_BY_KEY,Blog.class);
        query.setParameter("key", "%"+key.toLowerCase()+"%");
        List<Blog>  blogs = query.getResultList();
        logger.info("Search Key - "+key);
        if(blogs != null) {
        	for(int i=0;i<blogs.size();i++) {
        		logger.info("Search Blogs Results - "+blogs.get(i).getBlogTitle());
        	}
        }
        em.close();
		return blogs;
	}
	@Override
	public List<Blog> getBlogsByUser(String userName) {
		em = emf.createEntityManager();
		TypedQuery<Blog> query = em.createNamedQuery(Blog.SEARCH_BY_USER,Blog.class);
        query.setParameter("userName", userName);
        List<Blog>  blogs = query.getResultList();
        logger.info("userName - "+userName);
        if(blogs != null) {
        	for(int i=0;i<blogs.size();i++) {
        		logger.info("Blogs for user"+userName+". Results - "+blogs.get(i).getBlogTitle());
        	}
        }
        em.close();
		return blogs;
	}
	@Override
	public Blog getBlogDetails(long blogId){ 
		em = emf.createEntityManager();
		Blog blog = em.find(Blog.class, blogId);
		em.close();
		return blog;
	}

}
