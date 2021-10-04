// package com;

// import org.junit.Test;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;

// import org.junit.Before;

// public class PartenaireTest {
//     Partenaire stm;
//     Produit ticketParking;
//     Produit ticketTransportEnCommun;
//     Client john;
//     Client nicolas;
//     CarteInfidelite carte;

//     @Before
//     public void setup() {
//         stm = new Partenaire("Societe de transport de montreal", "800 Rue De La Gauchetière O, Montréal, QC H5A 1J6");
//         ticketParking = new Parking("Parking UQAM Pavillon SH", 25, 0.15);
//         ticketTransportEnCommun = new TransportCommun("Transport commun", Type.URBAIN, 3.50, 2);
//         carte = new CarteInfidelite(1000,100);
//         john = new Client("John Doe");
//         nicolas = new Abonne("Nicolas", carte);

//     }

//     @Test
//     public void constructorTest() {
//         assertEquals("Societe de transport de montreal", stm.getNom());
//         assertEquals("800 Rue De La Gauchetière O, Montréal, QC H5A 1J6", stm.getAdresse());
//     }

//     @Test
//     public void listeDesProduitsTest() {
//         stm.ajouterProduit(ticketParking);
//         stm.ajouterProduit(ticketTransportEnCommun);
//         assertEquals(
//                 "Partenaire: Societe de transport de montreal, adresse: 800 Rue De La Gauchetière O, Montréal, QC H5A 1J6/r/n"+
//                 "Catalogue des produits/r/n"+
//                 "Produit: Parking UQAM Pavillon SH, prix: 25$, duree: 0.15 heure(s), point(s): 2.5/r/n"+
//                 "Produit: Transport commun URBAIN, prix: 3.50$, duree: 2 heure(s), point(s): 0.35",
//                 stm.catalogueProduits());
//     }

//     @Test
//     public void vendreTest() {
//         stm.vendre(ticketParking, john);
//         assertEquals("Partenaire: Societe de transport de montreal, adresse: 800 Rue De La Gauchetière O, Montréal, QC H5A 1J6/r/n"+
//         "Produits vendu(s)/r/n"+
//         "Parking UQAM Pavillon SH, prix: 25$, duree: 0.15 heure(s)", stm.listeDesVentes());
//         stm.vendre(ticketParking, nicolas);
//         assertEquals(
//         "Partenaire: Societe de transport de montreal, adresse: 800 Rue De La Gauchetière O, Montréal, QC H5A 1J6/r/n"+
//         "Produits vendu(s)/r/n"+
//         "Parking UQAM Pavillon SH, prix: 25$, duree: 0.15 heure(s)/r/n"+
//         "Parking UQAM Pavillon SH, prix: 25$, duree: 0.15 heure(s)", stm.listeDesVentes());
        
//     }

//     @Test
//     public void offrirTest() {
//         stm.offrir(ticketParking, nicolas);
//         assertEquals(
//         "Partenaire: Societe de transport de montreal, adresse: 800 Rue De La Gauchetière O, Montréal, QC H5A 1J6/r/n"+
//         "Produits offert(s)/r/n"+
//         "Parking UQAM Pavillon SH, prix: 0$, duree: 0.15 heure(s), point(s): 2,5", stm.listeDesOffres());
//     }

//     @Test
//     private void validerCarteTest() {
//         assertTrue(stm.validerCarte(nicolas.getCarte()));
//     }
// }
