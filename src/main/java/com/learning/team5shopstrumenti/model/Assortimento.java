package com.learning.team5shopstrumenti.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "assortimenti")
public class Assortimento {
    // ATTRIBUTI

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate data;

    private Integer quantita;

    private BigDecimal prezzo;

    // RELAZIONI

    @ManyToOne
    private Strumento strumento;
}
