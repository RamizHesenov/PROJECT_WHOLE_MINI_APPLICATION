package com.ramiz.spring_boot_security.Models;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter  //tells jpa that this class will change read and write rules of selected column
@Component 
public class DiaryEncryptionConverter implements AttributeConverter<String, String> {

     private final TextEncryptor encryptor;//this is an interface of spring security which has two methods encrypt and decrypt

    public DiaryEncryptionConverter(@Value("${diary.password}") String password,//it tells spring take this values from application.properties and use it
                                    @Value("${diary.salt}") String salt) {
        this.encryptor = Encryptors.delux(password, salt);//it sets password and salt
    }

    @Override
    public String convertToDatabaseColumn(String plainText) {
        return plainText == null ? null : encryptor.encrypt(plainText); 
    }

    @Override
    public String convertToEntityAttribute(String dbValue) {
        return dbValue == null ? null : encryptor.decrypt(dbValue);
    }
}
