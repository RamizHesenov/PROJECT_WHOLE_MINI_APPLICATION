package com.ramiz.spring_boot_security.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Data
@Table(name = "Users")
public class Users {
    @Id 
    @Column(name = "username")
    private String username;
    private String userpassword;
    private int userid;
    private int age;

}
