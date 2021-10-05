package com;

public class Zone {
    protected String nom;
    protected String code_postal;


    public Zone() {
    }

    public Zone(String nom, String code_postal) {
        this.nom = nom;
        this.code_postal = code_postal;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePostal() {
        return this.code_postal;
    }

    public void setCodePostal(String code_postal) {
        this.code_postal = code_postal;
    }


    @Override
    public String toString() {
        return  "Zone de "+getNom()+", code postal: "+getCodePostal();
    }
    

}
