package com.Controller;

import java.util.List;

import com.Modele.Abonne;
import com.Modele.Cadeau;
import com.Modele.CarteInfidelite;
import com.Modele.Database;
import com.Modele.Partenaire;
import com.Modele.Produit;
import com.Modele.Ville;
import com.Modele.Zone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        InterfaceGraphique.lancer(args);
        // Ville montreal = new Ville("Montreal", 36565);
        // Zone sherbrooke = new Zone("Sherbrooke Bromptonville", "J1C");
        // Zone sainteCatherine = new Zone("Sainte catherine", "J5C");
        // Partenaire stm = new Partenaire("Societe de transport de montreal",
        //         "800 Rue De La Gauchetière O, Montréal, QC H5A 1J6");
        // Partenaire saq = new Partenaire("Société des alcools du Québec",
        //         "1747 Rue De La Rue Berri, Montréal, QC H3L 2H3");
        // Produit ticketParking = new Produit("Parking UQAM Pavillon SH 45 MINUTE", 25);
        // Produit ticketTransportEnCommun = new Produit("Transport commun", 75);
        // CarteInfidelite carte = new CarteInfidelite(1000, 100);
        // Abonne nicolas = new Abonne("Nicolas", carte);
        // Cadeau naya = new Cadeau("Eau mineral naya", 300, stm);

        // montreal.ajouterZone(sainteCatherine);
        // montreal.ajouterZone(sherbrooke);

        // sainteCatherine.ajouterPartenaire(stm);
        // sainteCatherine.ajouterPartenaire(saq);

        // stm.ajouterProduit(ticketParking);
        // stm.ajouterProduit(ticketTransportEnCommun);
        // stm.ajouterProduit(naya);
        // stm.vendre(ticketParking, 1, nicolas);
        // stm.offrir(naya, nicolas);

        // Database database = new Database();
        // database.save(sherbrooke);
        // database.save(sainteCatherine);
        // database.save(montreal);
        // database.save(ticketParking);
        // database.save(naya);
        // database.save(stm);
        // database.save(ticketTransportEnCommun);
        // database.save(saq);
        // database.save(carte);
        // database.save(nicolas);
        // carte.charger(200);
        // database.save(carte);
    }
}
