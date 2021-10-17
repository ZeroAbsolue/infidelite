package com;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class Abonne extends Client {
    private CarteInfidelite carteInfidelite;
    private boolean vup;
    private List<Operation> operations;

    public Abonne(String nom, CarteInfidelite carte) {
        super(nom);
        this.carteInfidelite = carte;
        vup = false;
        operations = new ArrayList<Operation>();
    }

    public boolean isVup() {
        return vup;
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

    public void ajouterAListeDesPartenairesDuMois(Partenaire partenaire) {
        boolean existe = false;
        for (Operation operation : operations) {
            existe = operation.getPartenaire() == partenaire;
        }
        if (!existe)
            operations.add(new Operation(partenaire, new Date()));
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
}
