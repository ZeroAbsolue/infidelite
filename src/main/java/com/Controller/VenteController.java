package com.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Modele.Abonne;
import com.Modele.AbonneObserver;
import com.Modele.Database;
import com.Modele.FactureTableView;
import com.Modele.ItemFacturer;
import com.Modele.Partenaire;
import com.Modele.Produit;
import com.jfoenix.controls.JFXButton;

import org.hibernate.Session;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class VenteController implements AbonneObserver {
    private Abonne selectedAbonne;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Produit> tableProduits;

    @FXML
    private JFXButton buttonPayer;

    @FXML
    private TableColumn<Produit, String> colNom = new TableColumn<>("Nom");

    @FXML
    private TableColumn<Produit, Double> colPrix = new TableColumn<>("Prix");

    @FXML
    private TableColumn<Produit, String> colAction = new TableColumn<>("Action");

    @FXML
    private TableView<ItemFacturer> tableFacture;

    @FXML
    private TableColumn<ItemFacturer, String> fctNom;

    @FXML
    private TableColumn<ItemFacturer, Integer> fctQuantite;

    @FXML
    private TableColumn<ItemFacturer, Double> fctPrix;

    @FXML
    private TableColumn<ItemFacturer, String> actionFactureColumn;

    @FXML
    private Text totalFacture;

    EditSelectedProductQuantityController selectedProductQuantityController;
    FactureTableView factureTableViewController = new FactureTableView();
    AbonneListController abonneListController;
    Stage editStage = new Stage();
    Stage clientStage = new Stage();
    Stage abonneStage = new Stage();
    Stage offreStage = new Stage();
    Partenaire partenaire;

    @FXML
    void btnAbonneClicked(ActionEvent event) throws IOException {
        launchListOfAbonne();
    }

    private void launchListOfAbonne() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Vue/AbonneList.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        abonneListController = loader.getController();
        abonneListController.register(this);

        abonneStage.setScene(scene);
        abonneStage.setResizable(false);
        abonneStage.sizeToScene();
        abonneStage.setTitle("Liste des abonn??es");
        abonneStage.show();
    }

    @FXML
    void buttonOffreClidked(ActionEvent event) throws IOException {
        launchListOfCadeau();
    }

    private void launchListOfCadeau() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Vue/OffreList.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        offreStage.setScene(scene);
        offreStage.setResizable(false);
        offreStage.sizeToScene();
        offreStage.setTitle("Liste des cadeaux");
        offreStage.show();
    }

    @FXML
    void buttonClientsClicked(ActionEvent event) throws IOException {
        launchListOfAbonneAndTransactionPerAbonne();
    }

    private void launchListOfAbonneAndTransactionPerAbonne() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Vue/AbonneListAndTransaction.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        clientStage.setScene(scene);
        clientStage.setResizable(false);
        clientStage.sizeToScene();
        clientStage.setTitle("Liste des clients");
        clientStage.show();
    }

    @FXML
    void buttonPayerAbonneClicked(ActionEvent event) {
        double montantFacture = calculerMontantTotalFacture();
        if (selectedAbonne.verifierSiSoldeSuperieurOuEgale(montantFacture)) {
            partenaire.enregistrerItemsFacturerCommeVente(tableFacture.getItems().toArray(), selectedAbonne);
            double nombrePointsCadeau = calculerNombreDePointsCadeau();
            double nombrePointsProduit = calculerNombreDePointsDesProduits();
            if (nombrePointsProduit > 0)
                selectedAbonne.incrementerNombreDePoints(nombrePointsProduit, partenaire);
            if (nombrePointsCadeau > 0)
                selectedAbonne.reduireNombreDePoints(nombrePointsCadeau, partenaire);
            if (montantFacture > 0)
                selectedAbonne.reduireSolde(montantFacture, partenaire);
            selectedAbonne.checkAndUpdateStatutVup();
            factureTableViewController.clear();
            
        }
    }

    private double calculerNombreDePointsDesProduits() {
        return factureTableViewController.calculerNombreDePointsDesProduits();
    }

    private double calculerNombreDePointsCadeau() {
        return factureTableViewController.calculerNombreDePointsCadeau();
    }

    private double calculerMontantTotalFacture() {
        return factureTableViewController.calulerMontantTotalFacture();
    }

    @FXML
    void tableMouseCliecked(MouseEvent event) {
        Produit produit = tableProduits.getSelectionModel().getSelectedItem();
        factureTableViewController.addAndUpdateAllElement(new ItemFacturer(produit, 1));
    }

    @FXML
    void initialize() {
        colNom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
        colPrix.setCellValueFactory(new PropertyValueFactory<Produit, Double>("prix"));
        tableProduits.setItems(getProducts());
        Callback<TableColumn<Produit, String>, TableCell<Produit, String>> cellFactory = addAbuttonQuantiteToEachProductToSell();
        colAction.setCellFactory(cellFactory);
        initializeFactureController();

    }

    private Callback<TableColumn<Produit, String>, TableCell<Produit, String>> addAbuttonQuantiteToEachProductToSell() {
        Callback<TableColumn<Produit, String>, TableCell<Produit, String>> cellFactory = (param) -> {
            // Make the tablecell containing button
            final TableCell<Produit, String> cell = new TableCell<Produit, String>() {
                // Override updateItem
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    // Ensure that cell is created only on non empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        final JFXButton editButton = new JFXButton("Quantite");
                        editButton.setOnAction(event -> {
                            launchQuantityInterface();
                        });
                        HBox managedButton = new HBox(editButton);
                        setGraphic(managedButton);
                        setText(null);
                    }
                }

                private void launchQuantityInterface() {
                    Produit produit = getTableView().getItems().get(getIndex());
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("../Vue/EditSelectedProductQuantity.fxml"));
                    try {
                        loader.load();
                    } catch (IOException ex) {
                        Logger.getLogger(VenteController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    Parent parent = loader.getRoot();
                    editStage.setScene(new Scene(parent));
                    editStage.setTitle(produit.toString());
                    editStage.show();

                    selectedProductQuantityController = loader.getController();
                    selectedProductQuantityController.setSelectedProduct(produit);
                    selectedProductQuantityController.register(factureTableViewController);
                    selectedProductQuantityController.setStage(editStage);
                }
            };
            return cell;
        };
        return cellFactory;
    }

    private void initializeFactureController() {
        factureTableViewController.setNameColumn(fctNom);
        factureTableViewController.setQuantityColumn(fctQuantite);
        factureTableViewController.setPriceColumn(fctPrix);
        addAbuttonSupprimerToEachItemFacturerAdd();
        factureTableViewController.setTotalFacture(totalFacture);
        factureTableViewController.setTableFacture(tableFacture);
        factureTableViewController.initiliaze();
    }

    public ObservableList<Produit> getProducts() {
        ObservableList<Produit> produits = FXCollections.observableArrayList();
        Database database = new Database();
        Session session = database.getSession();
        partenaire = (Partenaire) session.createQuery("from Partenaire where id = 1").uniqueResult();
        session.getTransaction().commit();
        for (Produit produit : partenaire.getListeDesProduits()) {
            produits.add(produit);
        }
        return produits;
    }

    public void addAbuttonSupprimerToEachItemFacturerAdd() {
        Callback<TableColumn<ItemFacturer, String>, TableCell<ItemFacturer, String>> actionFactureCellFactory = (
                param) -> {
            // Make the tablecell containing button
            final TableCell<ItemFacturer, String> cell = new TableCell<ItemFacturer, String>() {
                // Override updateItem
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    // Ensure that cell is created only on non empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        final JFXButton editButton = new JFXButton("Supprimer");
                        editButton.setOnAction(event -> {
                            ItemFacturer selectedItemFacturer = getTableView().getItems().get(getIndex());
                            getTableView().getItems().remove(selectedItemFacturer);
                            factureTableViewController.mettreAJourTexteTotal();

                        });
                        HBox managedButton = new HBox(editButton);
                        setGraphic(managedButton);
                        setText(null);
                    }
                }
            };
            return cell;
        };
        actionFactureColumn.setCellFactory(actionFactureCellFactory);
    }

    @Override
    public void update(Abonne abonne) {
        selectedAbonne = abonne;
        abonneStage.close();
        buttonPayer.setVisible(true);
    }

}
