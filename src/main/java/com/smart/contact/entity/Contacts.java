package com.smart.contact.entity;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.boot.jaxb.mapping.marshall.LockModeTypeMarshalling;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Contacts 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cid;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String phone;
	
	private String work;
	
	private String image;
	
	@Column(length = 100)
	private String description;
	
	@ManyToOne
	private User user;

	public Contacts() {
		super();

	}

	public Contacts(long cid, String name, String email, String phone, String work, String image, String description) {
		super();
		this.cid = cid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.work = work;
		this.image = image;
		this.description = description;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
