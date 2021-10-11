package com;

public class Cadeau extends Produit {
    private Partenaire partenaire;
    private double point;

    public Cadeau(String nom, double point) {
        super(nom, 0);
        this.point = point;
    }

    public Cadeau(String nom, double point, Partenaire partenaire) {
        super(nom, 0);
        this.point = point;
        this.partenaire = partenaire;
    }

    @Override
    public String description() {
        return super.toString() + ", point(s): " + point + ", " + partenaire;
    }

    @Override
    public double getCout() {
        return 0;
    }
}
