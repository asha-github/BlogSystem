package com.blog.api;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@NamedQueries({
    @NamedQuery(name = Blog.SEARCH_BY_KEY, query = "SELECT u FROM Blog u where (lower(u.blogTitle) like :key) OR (lower(u.blogTitle) like :key)"),
})
public class Blog implements Serializable{

private static final long serialVersionUID = 1L;
public static final String SEARCH_BY_KEY = "Blog.SEARCH";
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long blogId;
private String blogTitle;
private String blogContent;
@Temporal(TemporalType.TIMESTAMP)
private Date publishDate;
@Transient
private String userId;
@Transient
private List<String> comments;

public long getBlogId() {
	return blogId;
}
public void setBlogId(long blogId) {
	this.blogId = blogId;
}
public String getBlogTitle() {
	return blogTitle;
}
public void setBlogTitle(String blogTitle) {
	this.blogTitle = blogTitle;
}
public String getBlogContent() {
	return blogContent;
}
public void setBlogContent(String blogContent) {
	this.blogContent = blogContent;
}
public Date getPublishDate() {
	return publishDate;
}
public void setPublishDate(Date publishDate) {
	this.publishDate = publishDate;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public List<String> getComments() {
	return comments;
}
public void setComments(List<String> comments) {
	this.comments = comments;
}

}
