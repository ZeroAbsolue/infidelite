package com.Vue;

import java.util.List;

import com.Modele.Abonne;
import com.Modele.Cadeau;
import com.Modele.CarteInfidelite;
import com.Modele.Client;
import com.Modele.Parking;
import com.Modele.Partenaire;
import com.Modele.Produit;
import com.Modele.TransportCommun;
import com.Modele.Type;
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
        // Produit ticketParking = new Parking("Parking UQAM Pavillon SH", 25, 0.15);
        // Produit ticketTransportEnCommun = new TransportCommun("Transport commun", Type.URBAIN, 75, 2);
        // CarteInfidelite  carte = new CarteInfidelite(1000,100);
        // Abonne nicolas = new Abonne("Nicolas", carte);
        // Client john = new Client("John Doe");
        // Cadeau naya = new Cadeau("Eau mineral naya", 300,stm);

        // montreal.ajouterZone(sainteCatherine);
        // montreal.ajouterZone(sherbrooke);

        // sainteCatherine.ajouterPartenaire(stm);
        // sainteCatherine.ajouterPartenaire(saq);

        // stm.ajouterProduit(ticketParking);
        // stm.ajouterProduit(ticketTransportEnCommun);
        // stm.ajouterProduit(naya);
        // stm.vendre(ticketParking, john);
        // stm.vendre(ticketParking, nicolas);
        // stm.offrir(naya, nicolas);
        

        // SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // Session session = sessionFactory.openSession();
        // session.beginTransaction();
        // session.save(montreal);
        // session.save(sherbrooke);
        // session.save(sainteCatherine);
        // session.save(ticketParking);
        // session.save(naya);
        // session.save(stm);
        // session.save(ticketTransportEnCommun);
        // session.save(saq);
        // session.save(carte);
        // session.save(nicolas);
        // session.save(john);
        // carte.charger(200);
        // session.save(carte);
        

        // List<Ville> ville = session.createQuery("from Ville").list();
        // session.getTransaction().commit();

        // System.out.println(ville);
        // System.out.println(ville.get(0).listerLesZones());
        // System.out.println(ville.get(0).listeDesZones.get(0).listerLesPartenaires());
    }
}
