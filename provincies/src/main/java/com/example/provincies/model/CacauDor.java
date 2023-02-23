package com.example.provincies.model;

import jakarta.persistence.*;


@Entity
public class CacauDor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String descripcio;
    @ManyToOne
    @JoinColumn(name = "cacaudorciutat_id")
    private CacauDor_Ciutat cacauDorCiutat;

    @ManyToOne
    @JoinColumn(name = "Pais_id" )
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "Provincia_id")
    private Provincia provincia;

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

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public CacauDor_Ciutat getCacauDorCiutat() {
        return cacauDorCiutat;
    }

    public void setCacauDorCiutat(CacauDor_Ciutat cacauDorCiutat) {
        this.cacauDorCiutat = cacauDorCiutat;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public CacauDor(Long id, String nom, String descripcio, CacauDor_Ciutat cacauDorCiutat, Pais pais, Provincia provincia) {
        this.id = id;
        this.nom = nom;
        this.descripcio = descripcio;
        this.cacauDorCiutat = cacauDorCiutat;
        this.pais = pais;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "CacauDor{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", descripcio='" + descripcio + '\'' +
                ", cacauDorCiutat=" + cacauDorCiutat +
                ", pais=" + pais +
                ", provincia=" + provincia +
                '}';
    }
}
