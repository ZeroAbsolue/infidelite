package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Zone {

    protected String nom;
    protected String codePostal;
   protected List<Partenaire> listeDesPartenaires;


    public Zone(String nom, String codePostal) {
        this.nom = nom;
        this.codePostal = codePostal;
        listeDesPartenaires = new ArrayList<Partenaire>();
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
        return  "Zone de "+getNom()+", code postal: "+getCodePostal();
    }

    /* Permet d'ajouter un partenaire à la liste des partenaires de la ville */
    public void ajouterPartenaire(Partenaire partenaire) {
        this.listeDesPartenaires.add(partenaire);
    }

    /* Permet de retirer un partenaire à la liste des partenaires de la ville */
    public void retirerPartenaire(Partenaire partenaire) {
        this.listeDesPartenaires.remove(partenaire);
    }


    /* Permet de lister les partenaires d'une zone */
    public String listerLesPartenaires() {
        String result = toString() + "\n";
        if (listeDesPartenaires.size() == 0)
            result += "Aucun partenaire";
        else {
            result += "Liste des partenaires:\n";
            Iterator<Partenaire> iterator = listeDesPartenaires.iterator();
            while (iterator.hasNext()) {
                Partenaire partner = iterator.next();
                result += partner;
                if (iterator.hasNext())
                    result += "\n";
            }
        }
        return result;
    }


}
