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

    // RELAZIONI

    @ManyToOne
    private Strumento strumento;

    // GETTER E SETTER

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public Strumento getStrumento() {
        return strumento;
    }

    public void setStrumento(Strumento strumento) {
        this.strumento = strumento;
    }
}
