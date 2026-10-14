package com.ramiz.spring_boot_security.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ramiz.spring_boot_security.Models.UserPrincipal;
import com.ramiz.spring_boot_security.Models.Users;
import com.ramiz.spring_boot_security.repositories.UserRepo;

@Service 
public class MyUserDetailedService implements UserDetailsService{//this is custom service class for retrieving users during authentication

    @Autowired 
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {//implemented method which recieves username and return user's details
    //Spring security needs to authenticate that user
        
        Users user = repo.findByUsername(username);

        if(user == null){
            System.out.println("User not found try again");
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return new UserPrincipal(user);//userprincipal means current user that we want to retrieve all authentication credentials about it


        
    }
    
}
