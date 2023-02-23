package com.example.provincies.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CacauDor_Ciutat {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "cacauDorCiutat", cascade = CascadeType.ALL)
    private List<CacauDor> cacauDorList;


    @OneToMany(mappedBy = "cacauDorCiutat", cascade = CascadeType.ALL)
    private List<Ciutat> ciutat;


    public CacauDor_Ciutat(Long id, List<CacauDor> cacauDorList, List<Ciutat> ciutat) {
        this.id = id;
        this.cacauDorList = cacauDorList;
        this.ciutat = ciutat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CacauDor> getCacauDorList() {
        return cacauDorList;
    }

    public void setCacauDorList(List<CacauDor> cacauDorList) {
        this.cacauDorList = cacauDorList;
    }

    public List<Ciutat> getCiutat() {
        return ciutat;
    }

    public void setCiutat(List<Ciutat> ciutat) {
        this.ciutat = ciutat;
    }

    @Override
    public String toString() {
        return "CacauDorCiutat{" +
                "id=" + id +
                ", cacauDorList=" + cacauDorList +
                ", ciutat=" + ciutat +
                '}';
    }
}
