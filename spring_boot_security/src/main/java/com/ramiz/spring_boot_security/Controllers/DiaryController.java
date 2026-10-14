package com.ramiz.spring_boot_security.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramiz.spring_boot_security.Configurations.AppLogger;
import com.ramiz.spring_boot_security.Models.DiaryNote;
import com.ramiz.spring_boot_security.repositories.DiaryRepo;
import com.ramiz.spring_boot_security.repositories.UserRepo;

@Controller
public class DiaryController {

    @Autowired
    private DiaryRepo diaryRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/diary")
    public String diaryPage(){
        return "diary";
    }


    @Autowired
    private AppLogger appLogger;

    @PostMapping("/diary/save")
    public String saveDiary(@RequestParam String diaryText, Principal principal){//principal means current logged in user which ive given as userprincipal in myuserdetailedservice
        DiaryNote note = new DiaryNote();
        note.setText(diaryText);
        note.setUser(userRepo.findByUsername(principal.getName()));
        try {
            diaryRepo.save(note);
            appLogger.dataSaved(principal.getName());
        }
        catch (Exception e) {
            appLogger.dataSaveFailed(principal.getName(), e);
        }
        return "redirect:/diary/notes";
    }

    @GetMapping("/diary/notes")
    public String notesPage(Model model, Principal principal){
        model.addAttribute("notes", diaryRepo.findByUserUsernameOrderByIdDesc(principal.getName()));
        return "diary-notes";
    }
}
