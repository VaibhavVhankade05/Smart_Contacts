package com.smart.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.contact.entity.User;



public interface UserRepository extends JpaRepository<User, Integer>
{

}
