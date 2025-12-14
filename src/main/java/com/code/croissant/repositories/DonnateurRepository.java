package com.code.croissant.repositories;

import com.code.croissant.model.Donnateur;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DonnateurRepository extends JpaRepository<Donnateur, Long> {
    Optional<Donnateur> findByEmail(String email);

}

