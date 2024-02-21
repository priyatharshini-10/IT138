package com.bookreview.loginpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookreview.loginpage.model.Login;

public interface LoginRepo extends JpaRepository<Login,Integer> {

    
} 
