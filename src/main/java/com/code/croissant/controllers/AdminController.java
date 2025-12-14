package com.code.croissant.controllers;
import com.code.croissant.model.Donnateur;
import com.code.croissant.model.Don;
import com.code.croissant.model.Element;
import com.code.croissant.repositories.DonRepository;
import com.code.croissant.repositories.DonnateurRepository;
import com.code.croissant.repositories.ElementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") // to allow Angular access
@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    private DonnateurRepository donnateurRepository;
    @Autowired
    private DonRepository donRepository;
    @Autowired
    private ElementRepository elementRepository;


    //voir les elements possibles dans la page acceuil
    @GetMapping("")
    public List<Element> getElement() {
        return elementRepository.findAll();
    }

    @PutMapping("/add")
    public Element addElement(@RequestBody Element newElement) {
        return elementRepository.save(newElement);
    }

    @GetMapping("/dons")
    public List<Don> getDons() {
        return donRepository.findAll();
    }
    //confirmer un don
    @PutMapping("/{donId}/confirmer")
    public Don confirmerDon(@PathVariable Long donId) { //récupere le ID don
        Don don = donRepository.findById(donId).orElseThrow();
        don.setStatus(Don.DonStatus.CONFIRME);
        return donRepository.save(don);
    }

}
