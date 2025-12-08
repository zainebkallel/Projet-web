package com.code.croissant.controllers;

import com.code.croissant.model.Don;
import com.code.croissant.model.Element;
import com.code.croissant.repositories.ElementRepository;
import com.code.croissant.repositories.FavoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.code.croissant.model.Favori;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200") // to allow Angular access
@RestController
@RequestMapping("/api/favoris")

public class FavorisController {
    @Autowired
    private FavoriRepository favoriRepository;
    @Autowired
    private ElementRepository elementRepository;

    @PostMapping()
    public Favori ajouter(@RequestBody Favori favori ) {

        if(favori.getElement() != null && favori.getElement().getId() != null) {
            Optional<Element> elementOpt = elementRepository.findById(favori.getElement().getId());
            elementOpt.ifPresent(favori::setElement); // lie l’élément
        }
        if(favori.getDonateurId() == null) {
            throw new IllegalArgumentException("donateurId est obligatoire");
        }
        return favoriRepository.save(favori);

    }

    @GetMapping("/donateur/{donateurId}")
    public List<Favori> findAll(@PathVariable Long donateurId) {
        return favoriRepository.findByDonateurId(donateurId);
    }

    @DeleteMapping("/{favoriId}")
       void deleteFavori(@PathVariable long favoriId){
            favoriRepository.deleteById(favoriId);
        }

}