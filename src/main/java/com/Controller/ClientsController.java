package com.Controller;

import java.util.List;

import com.Modele.Abonne;
import com.Modele.Database;
import com.Modele.Operation;

import org.hibernate.Session;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ClientsController {
    @FXML
    private TableView<Abonne> tblClient;

    @FXML
    private TableView<Operation> tblOperation;

    @FXML
    private TableColumn<Abonne, String> clientColNom = new TableColumn<>("Nom");

    @FXML
    private TableColumn<Abonne, Double> clientColSolde = new TableColumn<>("Solde");;

    @FXML
    private TableColumn<Abonne, Double> clientColPoints = new TableColumn<>("Points");

    @FXML
    private TableColumn<Abonne, String> clientColStatut = new TableColumn<>("Statut");

    @FXML
    private TableColumn<Operation, String> operationColAction = new TableColumn<>("Action");

    @FXML
    private TableColumn<Operation, Double> operationColSolde = new TableColumn<>("Solde");

    @FXML
    private TableColumn<Operation, Double> operationColPoints = new TableColumn<>("Points");

    @FXML
    private TableColumn<Operation, String> operationColDate = new TableColumn<>("Date");

    @FXML
    void tblClientOnMouseClicked(MouseEvent event) {
        Abonne abonne = tblClient.getSelectionModel().getSelectedItem();
        tblOperation.setItems(getOperations(abonne));
    }

    private ObservableList<Operation> getOperations(Abonne abonne) {
        ObservableList<Operation> operations = FXCollections.observableArrayList();
        Database database = new Database();
        Session session = database.getSession();
        session.beginTransaction();
        String query = "from Operation where abonne_id = " + abonne.getId();
        List<Operation> operationList = session.createQuery(query).list();
        session.getTransaction().commit();
        for (Operation operation : operationList) {
            operations.add(operation);
        }
        return operations;
    }

    @FXML
    void initialize() {
        clientColNom.setCellValueFactory(new PropertyValueFactory<Abonne, String>("nom"));
        clientColSolde.setCellValueFactory(new PropertyValueFactory<Abonne, Double>("solde"));
        clientColPoints.setCellValueFactory(new PropertyValueFactory<Abonne, Double>("points"));
        clientColStatut.setCellValueFactory(new PropertyValueFactory<Abonne, String>("statut"));
        tblClient.setItems(getClients());

        operationColAction.setCellValueFactory(new PropertyValueFactory<Operation, String>("type"));
        operationColSolde.setCellValueFactory(new PropertyValueFactory<Operation, Double>("montant"));
        operationColPoints.setCellValueFactory(new PropertyValueFactory<Operation, Double>("point"));
        operationColDate.setCellValueFactory(new PropertyValueFactory<Operation, String>("dateOperation"));

    }

    private ObservableList<Abonne> getClients() {
        ObservableList<Abonne> abonnes = FXCollections.observableArrayList();
        Database database = new Database();
        Session session = database.getSession();
        session.beginTransaction();
        List<Abonne> abonneList = session.createQuery("from Abonne").list();
        session.getTransaction().commit();
        for (Abonne abonne : abonneList) {
            abonnes.add(abonne);
        }
        return abonnes;
    }
}
