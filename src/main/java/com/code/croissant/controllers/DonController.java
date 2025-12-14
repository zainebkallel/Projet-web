package com.code.croissant.controllers;
import com.code.croissant.mappers.DonMapper;
import com.code.croissant.model.Don;
import com.code.croissant.repositories.DonRepository;

import com.code.croissant.DTO.DonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/dons")
public class DonController {

    private final DonRepository donRepository;
    private final DonMapper donMapper;

    public DonController(DonRepository donRepository, DonMapper donMapper) {
        this.donRepository = donRepository;
        this.donMapper = donMapper;
    }

    // get les dons d'un donateur
    @GetMapping("/t")
    public List<DonDto> getDons() {
        return donRepository.findAll()
                .stream()
                .map(donMapper::toDonDto)
                .toList();
    }

}
