package com.Modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/* Permet d'identifier un partenaire */
@Entity
public class Partenaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private String nom;
    private String adresse;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "partenaire_produit", joinColumns = @JoinColumn(name = "partenaire_id"), inverseJoinColumns = @JoinColumn(name = "produit_id"))
    private Set<Produit> listeDesProduits;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "partenaire")
    private Set<Vente> listeDesVentes;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "partenaire_offre", joinColumns = @JoinColumn(name = "partenaire_id"), inverseJoinColumns = @JoinColumn(name = "produit_id"))
    private Set<Cadeau> listeDesOffres;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "zone_id")
    private Zone zone;

    public Partenaire() {
    }

    public Partenaire(String nom, String adresse, Zone zone) {
        this.nom = nom;
        this.adresse = adresse;
        this.zone = zone;
    }

    public Partenaire(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        listeDesProduits = new LinkedHashSet<Produit>();
        listeDesVentes = new LinkedHashSet<Vente>();
        listeDesOffres = new LinkedHashSet<Cadeau>();
    }

    public Partenaire nom(String nom) {
        setNom(nom);
        return this;
    }

    public Partenaire adresse(String adresse) {
        setAdresse(adresse);
        return this;
    }

    public Set<Produit> getListeDesProduits() {
        return listeDesProduits;
    }

    public void setListeDesProduits(Set<Produit> listeDesProduits) {
        this.listeDesProduits = listeDesProduits;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /* Permet d'ajouter un produit a la liste des produits du partenaire */
    public void ajouterProduit(Produit produit) {
        listeDesProduits.add(produit);
    }

    /* Permet de retirer un produit a la liste des produits du partenaire */
    public void retirerProduit(Produit produit) {
        listeDesProduits.remove(produit);
    }

    /* Permet le catalogue de produits du partenaire */
    public String catalogueProduits() {
        String result = toString() + "\n";
        if (listeDesProduits.size() == 0)
            result += "Aucun produit";
        else {
            result += "Catalogue des produits:\n";
            Iterator<Produit> iterator = listeDesProduits.iterator();
            while (iterator.hasNext()) {
                Produit produit = iterator.next();
                result += produit;
                if (iterator.hasNext())
                    result += "\n";
            }
        }
        return result;
    }

    public String toString() {
        return "Partenaire: " + getNom() + "," + " adresse: " + getAdresse();
    }

    /* Permet de vendre un produit */
    public void vendre(Produit produit, int quantite, Abonne client) throws CloneNotSupportedException {
        Produit cloneProduit = (Produit) produit.clone();
        cloneProduit.setPrix(produit.getCout());
        if (client instanceof Abonne) {
            Abonne abonne = ((Abonne) client);
            if (validerMontant(abonne.getCarteInfidelite(), produit.getCout())) {
                listeDesVentes.add(new Vente(cloneProduit, quantite, new Date(), this));
                abonne.ajouterOperation(this, Type.CREDIT.toString());
                abonne.checkAndUpdateStatutVup();
            }
        } else {
            listeDesVentes.add(new Vente(cloneProduit, quantite, new Date(), this));

        }
    }

    // Permet de vendre une collection de produit
    public boolean vendre(ArrayList<Vente> ventes, Double montant, Abonne client) throws CloneNotSupportedException {
        Iterator<Vente> produitsIterator = ventes.iterator();
        while (produitsIterator.hasNext()) {
            Vente iterator = (Vente) produitsIterator.next();
            if (client instanceof Abonne) {
                Abonne abonne = ((Abonne) client);
                if (validerMontant(abonne.getCarteInfidelite(), montant)) {
                    abonne.ajouterOperation(this, Type.CREDIT.toString());
                    listeDesVentes.add(iterator);
                    abonne.checkAndUpdateStatutVup();
                }
                return false;
            } else {
                listeDesVentes.add(iterator);
            }
        }
        return true;
    }

    /*
     * Permet d'ajouter un produit a la liste des produits offert par le partenaire
     */
    public void offrir(Cadeau produit, Abonne client) {
        listeDesOffres.add(produit);
        if (client instanceof Abonne) {
            Abonne abonne = ((Abonne) client);
            if (validerPoint(abonne.getCarteInfidelite(), produit.getNombrePoints())) {
                abonne.deduirePoint(produit.getNombrePoints());
                abonne.ajouterOperation(this, Type.DEBIT.toString());
            }

        }
    }

    /*
     * /* Permet de valider une carte
     */
    public boolean validerPoint(CarteInfidelite carte, double point) {
        return carte.getNombrePoints() >= point;
    }

    /* Permet de valider une carte */
    public boolean validerMontant(CarteInfidelite carte, double montant) {
        return carte.getSolde() >= montant;
    }

    public void enregistrerItemsFacturerCommeVente(Object[] itemFacturers, Abonne abonne) {
        for (Object item : itemFacturers) {
            ItemFacturer itemFacturer = (ItemFacturer) item;
            Vente nouvelleVete = new Vente(itemFacturer.getProduit(), itemFacturer.getQuantite(), new Date(), this);
            Database database = new Database();
            database.save(nouvelleVete);
            abonne.checkAndUpdateStatutVup();
        }
    }

}
