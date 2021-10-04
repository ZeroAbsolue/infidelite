package com;

public class Zone {

    private String nom;
    private String codePostal;

    public Zone(String nom, String codePostal) {
        this.nom = nom;
        this.codePostal = codePostal;
    }

    public Zone() {
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Zone nom(String nom) {
        setNom(nom);
        return this;
    }

    public Zone codePostal(String codePostal) {
        setCodePostal(codePostal);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " nom='" + getNom() + "'" +
            ", codePostal='" + getCodePostal() + "'" +
            "}";
    }
   

}
