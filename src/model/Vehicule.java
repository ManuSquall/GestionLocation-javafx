package model;

public class Vehicule {

    private int id;
    private String matricule;
    private String couleur;
    private String numCarteGrise;
    private int nbrChvx;
    private Modele modele;

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getNumCarteGrise() {
        return numCarteGrise;
    }

    public void setNumCarteGrise(String numCarteGrise) {
        this.numCarteGrise = numCarteGrise;
    }

    public int getNbrChvx() {
        return nbrChvx;
    }

    public void setNbrChvx(int nbrChvx) {
        this.nbrChvx = nbrChvx;
    }

    @Override
    public String toString() {
        return  matricule ;
    }
}
