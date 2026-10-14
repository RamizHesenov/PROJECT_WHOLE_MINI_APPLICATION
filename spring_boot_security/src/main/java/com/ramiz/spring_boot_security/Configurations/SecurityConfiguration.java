package com.ramiz.spring_boot_security.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableWebSecurity 
public class SecurityConfiguration {

    @Autowired 
        private UserDetailsService userDetailsService;//it means there is existing userDetailedService somewhere and take it from there for later use

    @Bean 
    public AuthenticationProvider authenticationProvider(){//this is used to get user credentials from db storage or inMemory storage 
        //that spring Security can use to authenticate the users

        
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);//this is the actual code which retrieves user credentials based on userDetailsService

        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));//its used to compare user authentication inputs with credentials stored in somewhere
        //we are using bcrypt here it means it will authenticate by encoded text not plaintext stored in db
        //all the plaintext format stored in db will not be authenticated because of this parameter that we give

        return provider;

    }
    
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http){ //by using this we say I will configure the security operations
         http
        .authorizeHttpRequests(request -> request
            .requestMatchers("/login", "/register", "/css/**").permitAll()
            .anyRequest().authenticated())
        .formLogin(form -> form
            .loginPage("/login")
            .defaultSuccessUrl("/diary", true)
            .permitAll())
        .logout(logout -> logout
            .logoutSuccessUrl("/login?logout")
            .permitAll());

    return http.build();
    }

}
