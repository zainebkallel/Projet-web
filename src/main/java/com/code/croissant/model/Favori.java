package com.code.croissant.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Favori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation avec le donateur
    private Long donateurId; // si tu n’as pas d’entité Donateur

    // Relation avec l'élément
    @ManyToOne
    @JoinColumn(name = "element_id")
    private Element element;
}
