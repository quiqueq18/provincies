package com.example.provincies.model;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private List<Provincia> provincias;

    public Pais(Long id, String nom, List<Provincia> provincias) {
        this.id = id;
        this.nom = nom;
        this.provincias = provincias;
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

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", provincias=" + provincias +
                '}';
    }

    @ManyToOne(optional = false)
    private CacauDor cacauDors;

    public CacauDor getCacauDors() {
        return cacauDors;
    }

    public void setCacauDors(CacauDor cacauDors) {
        this.cacauDors = cacauDors;
    }
}
