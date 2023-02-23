package com.example.provincies.model;

import jakarta.persistence.*;
@Entity
public class Ciutat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    @ManyToOne
    @JoinColumn(name = "cacaudorciutat_id")
    private CacauDor_Ciutat cacauDorCiutat;

    public Ciutat(Long id, String nom, Provincia provincia, CacauDor_Ciutat cacauDorCiutat) {
        this.id = id;
        this.nom = nom;
        this.provincia = provincia;
        this.cacauDorCiutat = cacauDorCiutat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public CacauDor_Ciutat getCacauDorCiutat() {
        return cacauDorCiutat;
    }

    public void setCacauDorCiutat(CacauDor_Ciutat cacauDorCiutat) {
        this.cacauDorCiutat = cacauDorCiutat;
    }

    @Override
    public String toString() {
        return "Ciutat{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", provincia=" + provincia +
                ", cacauDorCiutat=" + cacauDorCiutat +
                '}';
    }
}
