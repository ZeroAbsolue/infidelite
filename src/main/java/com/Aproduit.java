package com;

public abstract class Aproduit {
    /*
     * protected String nom; protected double prix;
     */

    public abstract double getCout();

    public abstract double getNombrePoints();

    public abstract double getCout(Client client);

    public abstract double getNombrePoints(Client client);

}
