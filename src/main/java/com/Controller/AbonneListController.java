package com.Controller;

import java.util.ArrayList;
import java.util.List;

import com.Modele.Abonne;
import com.Modele.AbonneObserver;
import com.Modele.AbonneSubject;
import com.Modele.Database;

import org.hibernate.Session;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AbonneListController implements AbonneSubject {

    private List<AbonneObserver> observers = new ArrayList<AbonneObserver>();
    private Abonne abonne;

    @FXML
    private TableView<Abonne> tableAbonne = new TableView<>();

    @FXML
    private TableColumn<Abonne, String> abonneColNom = new TableColumn<>("Nom");

    @FXML
    void tableAbonneOnMouseClicked(MouseEvent event) {
        abonne = tableAbonne.getSelectionModel().getSelectedItem();
        notifyObservers();
    }

    @FXML
    void initialize() {

        abonneColNom.setCellValueFactory(new PropertyValueFactory<Abonne, String>("nom"));
        tableAbonne.setItems(getClients());

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

    @Override
    public void register(AbonneObserver newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(AbonneObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (AbonneObserver abonneObserver : observers) {
            abonneObserver.update(abonne);
        }
    }

}
