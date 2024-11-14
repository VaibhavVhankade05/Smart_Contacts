package com.smart.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.contact.entity.User;



public interface UserRepository extends JpaRepository<User, Integer>
{
	@Query("Select u from User u where u.email= :email")
	public User getUserBYUserEmail(@Param("email") String email);
}
