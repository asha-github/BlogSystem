package com.blog.api;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class User {
@Id
private String userName;
private String profileName;
private String password;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getProfileName() {
	return profileName;
}
public void setProfileName(String profileName) {
	this.profileName = profileName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
