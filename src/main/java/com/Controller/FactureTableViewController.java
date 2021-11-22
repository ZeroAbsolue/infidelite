package com.Controller;

import com.Modele.ItemFacturer;
import com.Modele.Cadeau;
import com.Modele.ItemFactureObserver;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class FactureTableViewController implements ItemFactureObserver {

    private TableView<ItemFacturer> tableFacture;
    public TableColumn<ItemFacturer, String> nameColumn = new TableColumn<>("Nom");
    private TableColumn<ItemFacturer, Integer> quantityColumn = new TableColumn<>("Quantite");
    private TableColumn<ItemFacturer, Double> priceColumn = new TableColumn<>("Prix");
    private TableColumn<ItemFacturer, String> actionColumn = new TableColumn<>("Action");
    private Text totalFacture;

    public FactureTableViewController() {
    }

    public Text getTotalFacture() {
        return totalFacture;
    }

    public void setTotalFacture(Text totalFacture) {
        this.totalFacture = totalFacture;
    }

    public TableView<ItemFacturer> getTableFacture() {
        return tableFacture;
    }

    public void setTableFacture(TableView<ItemFacturer> tableFacture) {
        this.tableFacture = tableFacture;
    }

    public TableColumn<ItemFacturer, String> getNameColumn() {
        return nameColumn;
    }

    public void setNameColumn(TableColumn<ItemFacturer, String> nameColumn) {
        this.nameColumn = nameColumn;
    }

    public TableColumn<ItemFacturer, Integer> getQuantityColumn() {
        return quantityColumn;
    }

    public void setQuantityColumn(TableColumn<ItemFacturer, Integer> quantityColumn) {
        this.quantityColumn = quantityColumn;
    }

    public TableColumn<ItemFacturer, Double> getPriceColumn() {
        return priceColumn;
    }

    public void setPriceColumn(TableColumn<ItemFacturer, Double> priceColumn) {
        this.priceColumn = priceColumn;
    }

    public TableColumn<ItemFacturer, String> getActionColumn() {
        return actionColumn;
    }

    public void setActionColumn(TableColumn<ItemFacturer, String> actionColumn) {
        this.actionColumn = actionColumn;
    }

    public double calulerMontantTotalFacture() {
        ObservableList<ItemFacturer> listeDesItemFacturers = tableFacture.getItems();
        double total = 0;
        for (ItemFacturer itemFacturer : listeDesItemFacturers) {
            total += itemFacturer.getQuantite() * itemFacturer.getProduit().getPrix();
        }
        return total;
    }

    public void mettreAJourTexteTotal() {
        totalFacture.setText(calulerMontantTotalFacture() + "");
    }

    public void addAndUpdateAllElement(ItemFacturer itemFacturer) {
        tableFacture.getItems().add(itemFacturer);
        calulerMontantTotalFacture();
        mettreAJourTexteTotal();
    }

    public void initiliaze() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<ItemFacturer, String>("nom"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<ItemFacturer, Integer>("quantite"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ItemFacturer, Double>("prix"));
    }

    @Override
    public void update(ItemFacturer itemFacturer) {
        addAndUpdateAllElement(itemFacturer);
    }

    public double calculerNombreDePointFacture() {
        ObservableList<ItemFacturer> listeDesItemFacturers = tableFacture.getItems();
        double total = 0;
        for (ItemFacturer itemFacturer : listeDesItemFacturers) {
            System.out.println((itemFacturer.getProduit() instanceof Cadeau) ? " Yes": "No");
            total += itemFacturer.getQuantite() * itemFacturer.getProduit().getNombrePoints();
        }
        return total;
    }

    public void clear() {
        tableFacture.getItems().clear();
    }
}
