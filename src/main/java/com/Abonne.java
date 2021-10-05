package com;

public class Abonne extends Client {
    private CarteInfidelite carteInfidelite;
    private boolean vup;
    

    public Abonne(String nom, CarteInfidelite carte) {
        super(nom);
        this.carteInfidelite = carte;
        vup = false;
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
}
