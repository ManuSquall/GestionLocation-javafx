package model;

import java.util.List;

public class Marque {
    private int id;
    private String libelle;

    private List<Modele> listeModele;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return  libelle ;
    }
}
