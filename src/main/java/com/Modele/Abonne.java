package com.Modele;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Abonne extends Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    private CarteInfidelite carteInfidelite;
    private boolean vup;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "abonne")
    private Set<Operation> operations;

    public Abonne(String nom, CarteInfidelite carte) {
        super(nom);
        this.carteInfidelite = carte;
        vup = false;
        operations = new LinkedHashSet<Operation>();
    }

    public boolean isVup() {
        return vup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVup(boolean vup) {
        this.vup = vup;
    }

    public CarteInfidelite getCarteInfidelite() {
        return this.carteInfidelite;
    }

    public void setCarteInfidelite(CarteInfidelite carteInfidelite) {
        this.carteInfidelite = carteInfidelite;
    }

    public void ajouterOperation(Partenaire partenaire, String type) {
        operations.add(new Operation(partenaire, new Date(), this, type));
    }

    public void deduirePoint(double nombrePoints) {
        carteInfidelite.deduirePoint(nombrePoints);
    }

    /* Calcul le bonus d'infidelite */
    public void calculerBonusInfidelite() {
        double nbrePoints = carteInfidelite.getNombrePoints();
        int nbreOperation = 0;
        Date date = new Date();
        for (Operation operation : operations) {
            if (operation.getDate().getMonth() == date.getMonth() && operation.getDate().getYear() == date.getYear()) {
                nbreOperation++;
            }
        }
        carteInfidelite.setNombrePoints(nbrePoints + nbreOperation * 10);
    }

    public double getNombrePoints() {
        return carteInfidelite.getNombrePoints();
    }

    public void majStatutVup() {
        // TODO Ici mettre en place l'algorithme permettant de verifier si on a deja
        // atteinds les 100 $ de depense et mettre a jour le statut vup
    }

    public boolean verifierSiSoldeSuperieurOuEgale(double montant) {
        return carteInfidelite.verifierSiSoldeSuperieurOuEgale(montant);
    }

    public void incrementerNombreDePoints(double nombrePoints,Partenaire partenaire) {
        carteInfidelite.augmenterPoint(nombrePoints);
        Operation operation = new Operation(partenaire, new Date(), this, Type.CREDIT.toString(),0,nombrePoints);
        Database database = new Database();
        database.save(carteInfidelite);
        database.save(operation);
    }

    public Abonne(String nom) {
        super(nom);
    }

    public Abonne() {
    }

    public void reduireSolde(double montant, Partenaire partenaire) {
        carteInfidelite.deduireSolde(montant); 
        Operation operation = new Operation(partenaire, new Date(), this, Type.DEBIT.toString(),montant);
        Database database = new Database();
        database.save(carteInfidelite);
        database.save(operation);
    }

    public String getNom() {
        return super.getNom();
    }

    public double getSolde(){
        return carteInfidelite.getSolde();
    }

    public double  getPoints() {
        return carteInfidelite.getNombrePoints();
    }

    public String getStatut() {
        return isVup() ? "vup" : "not vup";
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
