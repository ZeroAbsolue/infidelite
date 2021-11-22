package com.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.Modele.ItemFacturer;
import com.Modele.ItemFactureObserver;
import com.Modele.Produit;
import com.Modele.ItemFactureSubject;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditSelectedProductQuantityController implements Initializable, ItemFactureSubject {
    Produit selectedProduit;
    int quantite;
    Stage stage = new Stage();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private ArrayList<ItemFactureObserver> observers;

    @FXML
    private JFXTextField Qte;

    @FXML
    private Text productDesc = new Text();

    public void setSelectedProduct(Produit produit) {
        selectedProduit = produit;
    }

    @FXML
    void save(ActionEvent event) {
        quantite = Integer.parseInt(Qte.getText());
        notifyObservers();
        stage.close();
    }

    public EditSelectedProductQuantityController() {
        observers = new ArrayList<ItemFactureObserver>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void register(ItemFactureObserver newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(ItemFactureObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println(observers.size());
        for (ItemFactureObserver observer : observers) {
            observer.update(new ItemFacturer(selectedProduit, quantite));
        }
    }

}
