package com.code.croissant.DTO;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DonDto {
    private Long id;
    private double montant;



}
