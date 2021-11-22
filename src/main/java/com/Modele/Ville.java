package com.Modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/* Classe permettant d'identifier les informations d'une ville */
@Entity
@Table(name = "ville")
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( unique = true, nullable = false)
    private int id;
    protected String nom;
    @Column(precision = 10, scale = 2)
    protected double superficie;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ville", cascade = CascadeType.ALL)
    public List<Zone> listeDesZones;

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
        zone.setVille(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /* Permet de retirer une zone a la liste des zones de la ville */
    public void retirerZone(Zone zone) {
        this.listeDesZones.remove(zone);
    }

    /* Permet de lister les zones d'une ville */
    public String listerLesZones() {
        String result = toString() + "\n";
        if (listeDesZones.size() == 0)
            result += "Aucune zone";
        else {
            result += "Liste des zones:\n";
            Iterator<Zone> iterator = listeDesZones.iterator();
            while (iterator.hasNext()) {
                Zone zone = iterator.next();
                result += zone;
                if (iterator.hasNext())
                    result += "\n";
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Ville de " + getNom() + ", Superficie: " + getSuperficie();

    }

}
