package com.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceGraphique extends Application {
/**
     * Lance l'application
     * @param args les paramètres
     */
    public static void lancer(String[] args) {
        launch(args);
    }

    @Override
    /**
     * Charge les éléments nécéssaires à une application javafx
     */
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Vue/Vente.fxml"));
        
        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }

}
