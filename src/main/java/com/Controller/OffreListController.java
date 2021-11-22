package com.Controller;

import java.util.List;

import com.Modele.Cadeau;
import com.Modele.Database;

import org.hibernate.Session;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class OffreListController {

    @FXML
    private TableView<Cadeau> tableOffre = new TableView<>();

    @FXML
    private TableColumn<Cadeau, String> offreColNom = new TableColumn<>("Nom");

    @FXML
    private TableColumn<Cadeau, Double> offreColPoint = new TableColumn<>("Points");

    @FXML
    private TableColumn<Cadeau, String> OffreColPartenaire = new TableColumn<>("Partenaire");

    @FXML
    void initialize() {
        offreColNom.setCellValueFactory(new PropertyValueFactory<Cadeau, String>("nom"));
        offreColPoint.setCellValueFactory(new PropertyValueFactory<Cadeau, Double>("point"));
        OffreColPartenaire.setCellValueFactory(new PropertyValueFactory<Cadeau, String>("partenaire"));
        tableOffre.setItems(getListeDesOffres());
    }

    private ObservableList<Cadeau> getListeDesOffres() {
        ObservableList<Cadeau> cadeaux = FXCollections.observableArrayList();
        Database database = new Database();
        Session session = database.getSession();
        session.beginTransaction();
        List<Cadeau> cadeauList = session.createQuery("from Cadeau").list();
        session.getTransaction().commit();
        for (Cadeau cadeau : cadeauList) {
            cadeaux.add(cadeau);
        }
        return cadeaux;
    }
}
