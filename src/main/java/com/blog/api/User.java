package com.blog.api;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@Entity
@NamedQueries({
    @NamedQuery(name = User.FIND_BY_LOGIN_PASSWORD, query = "SELECT u FROM User u WHERE u.userName = :userName AND u.password = :password"),
})
public class User {
@Id
private String userName;
private String profileName;
private String password;
public static final String FIND_BY_LOGIN_PASSWORD = "User.findByLoginAndPassword";
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
