package com.ramiz.spring_boot_security.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ramiz.spring_boot_security.Models.Users;
import com.ramiz.spring_boot_security.repositories.UserRepo;

@Service 
public class RegisterService {

    @Autowired 
    private UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);//we created a bcrypt encoder object which will encode our password with 12 strength


    public Users SaveUser(Users user){

        user.setUserpassword(encoder.encode(user.getUserpassword()));//it will get userpassword and encode it then set the encoded password
        return repo.save(user);//then save it
    }

    public boolean exists(String username){
        return repo.existsById(username);//it check whether there is dublicate or not
    }
}
