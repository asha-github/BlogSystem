package com.blog.api;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment implements Serializable{

private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long commentId;
private long blogId;
private String userName;
private String commentContent;
@Temporal(TemporalType.TIMESTAMP)
private Date commentAddedDate;
public long getCommentId() {
	return commentId;
}
public void setCommentId(long commentId) {
	this.commentId = commentId;
}
public long getBlogId() {
	return blogId;
}
public void setBlogId(long blogId) {
	this.blogId = blogId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getCommentContent() {
	return commentContent;
}
public void setCommentContent(String commentContent) {
	this.commentContent = commentContent;
}
public Date getCommentAddedDate() {
	return commentAddedDate;
}
public void setCommentAddedDate(Date commentAddedDate) {
	this.commentAddedDate = commentAddedDate;
}



}
