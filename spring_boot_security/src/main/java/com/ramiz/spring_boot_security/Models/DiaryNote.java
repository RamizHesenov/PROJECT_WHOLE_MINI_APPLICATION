package com.ramiz.spring_boot_security.Models;



import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "diary_notes")
public class DiaryNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id will be generated automatically
    private Long id;

    @Convert(converter = DiaryEncryptionConverter.class)//this cals converter class
    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @ManyToOne(optional = false)
    @JoinColumn(name = "username")   // it will join Users username cuz @Id is username there
    private Users user;
}
