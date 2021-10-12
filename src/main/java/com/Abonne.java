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

    public void ajouterAchatChezPartenaire(Partenaire partenaire){
        operations.add(new Operation(partenaire, new Date()));
    }
}
