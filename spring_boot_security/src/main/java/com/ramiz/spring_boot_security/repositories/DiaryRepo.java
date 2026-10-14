package com.ramiz.spring_boot_security.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ramiz.spring_boot_security.Models.DiaryNote;

@Repository 
public interface DiaryRepo extends JpaRepository<DiaryNote, Long> {
    List<DiaryNote> findByUserUsernameOrderByIdDesc(String username);
}