package com;

public class Partenaire {
    protected String nom;
    protected String adresse;

    public Partenaire(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public Partenaire() {
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Partenaire nom(String nom) {
        setNom(nom);
        return this;
    }

    public Partenaire adresse(String adresse) {
        setAdresse(adresse);
        return this;
    }


    @Override
    public String toString() {
        return  "Partenaire: "+getNom()+", adresse: "+getAdresse();
    }

}
