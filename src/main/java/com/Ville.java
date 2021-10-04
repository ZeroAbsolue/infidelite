package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* Classe permettant d'identifier les informations d'une ville */
public class Ville {
    protected String nom;
    protected double superficie;
    protected List<Zone> listeDesZones;

    public Ville() {
    }

    public Ville(String nom, double superficie) {
        listeDesZones = new ArrayList<Zone>();
        this.nom = nom;
        this.superficie = superficie;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSuperficie() {
        return this.superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    /* Permet d'ajouter une nouvelle zone a la liste des zones de la ville */
    public void ajouterZone(Zone zone) {
        this.listeDesZones.add(zone);
    }

    /* Permet de retirer une zone a la liste des zones de la ville */
    public void retirerZone(Zone zone) {
        this.listeDesZones.remove(zone);
    }

    /* Permet de lister les zones d'une ville */
    public String listerLesZones() {
        String result = toString() + "/n";
        if (listeDesZones.size() == 0)
            result += "Aucune zone";
        else {
            result += "Liste des zones:/n";
            Iterator<Zone> iterator = listeDesZones.iterator();
            while (iterator.hasNext()) {
                Zone zone = iterator.next();
                result += zone;
                if (iterator.hasNext())
                    result += "/n";
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Ville de " + getNom() + ", Superficie: " + getSuperficie();
    }

}
