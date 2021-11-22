package com.Modele;

import java.util.List;

public class CollectionVente {
    private List<Vente> listeDesVentes;

    public List<Vente> getListeDesVentes() {
        return listeDesVentes;
    }

    public CollectionVente(List<Vente> listeDesVentes) {
        this.listeDesVentes = listeDesVentes;
    }

    public void setListeDesVentes(List<Vente> listeDesVentes) {
        this.listeDesVentes = listeDesVentes;
    }

    public void ajouterVente(Vente vente) {
        listeDesVentes.add(vente);
    }

    public void retirerVente(Vente vente) {
        listeDesVentes.remove(vente);
    }

    public double total() {
        double somme = 0;
        for (Vente vente : listeDesVentes) {
            somme += vente.getProduit().getCout();
        }
        return somme;
    }

    public CollectionVente() {
    }

    
}
