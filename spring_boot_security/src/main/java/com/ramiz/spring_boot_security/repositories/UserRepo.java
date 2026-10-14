package com.ramiz.spring_boot_security.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramiz.spring_boot_security.Models.Users;

@Repository 
public interface UserRepo extends JpaRepository<Users,String>{

    public Users findByUsername(String username);
}