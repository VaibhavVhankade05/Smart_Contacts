package com.smart.contact.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Reqiured")
	@Size(min = 2, max = 50,message = "Extend size")
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String password; 
	
	private String role;
	
	@Column(length = 500)
	private String about;
	
	private String imageUrl;
	
	private boolean enabled;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Contacts> contacts = new ArrayList<>();

	public User() {
		super();
	}



	public User(int id, String name, String email, String password, String role, String about, String imageUrl,
			boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.about = about;
		this.imageUrl = imageUrl;
		this.enabled = enabled;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}



	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}



	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public List<Contacts> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", about=" + about + ", imageUrl=" + imageUrl + ", enabled=" + enabled + ", contacts=" + contacts
				+ "]";
	}
	
	
}
