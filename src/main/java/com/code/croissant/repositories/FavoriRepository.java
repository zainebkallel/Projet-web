package com.code.croissant.repositories;
import com.code.croissant.model.Favori;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriRepository extends JpaRepository<Favori, Long> {
    List<Favori> findByDonateurId(Long donateurId);
    List<Favori> findAll();
    void deleteByDonateurId(Long donateurId);
}
