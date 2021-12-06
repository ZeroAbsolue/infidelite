package com.Modele;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.Session;

@Entity
public class Abonne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    private CarteInfidelite carteInfidelite;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "abonne")
    private Set<Operation> operations;

    private String nom;
    private boolean vup;

    public Abonne() {
    }

    public Abonne(String nom) {
        this.nom = nom;
    }

    public Abonne(String nom, CarteInfidelite carte) {
        this.nom = nom;
        this.carteInfidelite = carte;
        vup = false;
        operations = new LinkedHashSet<Operation>();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isVup() {
        return vup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVup(boolean vup) {
        this.vup = vup;
    }

    public CarteInfidelite getCarteInfidelite() {
        return this.carteInfidelite;
    }

    public void setCarteInfidelite(CarteInfidelite carteInfidelite) {
        this.carteInfidelite = carteInfidelite;
    }

    public void ajouterOperation(Partenaire partenaire, String type) {
        operations.add(new Operation(partenaire, new Date(), this, type));
    }

    public String getNom() {
        return this.nom;
    }

    public double getSolde() {
        return carteInfidelite.getSolde();
    }

    public double getPoints() {
        return carteInfidelite.getNombrePoints();
    }

    public String getStatut() {
        return isVup() ? "vup" : "not vup";
    }

    public void deduirePoint(double nombrePoints) {
        carteInfidelite.deduirePoint(nombrePoints);
    }

    public double getNombrePoints() {
        return carteInfidelite.getNombrePoints();
    }

    public void checkAndUpdateStatutVup() {
        if (hasMadeHundredOperation()) {
            setVup();
        } else
            setNotVup();
    }

    private void setNotVup() {
        Database database = new Database();
        this.setVup(false);
        database.save(this);
    }

    private void setVup() {
        Database database = new Database();
        this.setVup(true);
        database.save(this);
    }

    private boolean hasMadeHundredOperation() {

        Double weekAmountTotal = getTotalAmountSpendInWeekFromDatabase();
        return weekAmountTotal >= 100;
    }

    private Double getTotalAmountSpendInWeekFromDatabase() {
        try {
            int weekOfYear = getWeekOfYear();
            Database database = new Database();
            String queryString = "SELECT SUM(montant) as montant FROM Operation where DATE_FORMAT(date, '%v') = "
                    + weekOfYear + " and abonne_id =" + this.id;
            Session session = database.getSession();
            session.beginTransaction();
            Double weekAmountTotal = (double) session.createQuery(queryString).uniqueResult();
            session.getTransaction().commit();
            return weekAmountTotal;
        } catch (Exception e) {
            return 0.0;
        }

    }

    private int getWeekOfYear() {
        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = targetFormat.format(new Date());
        Locale userLocale = Locale.GERMANY;
        WeekFields weekNumbering = WeekFields.of(userLocale);
        LocalDate date = LocalDate.parse(formatted);
        int currentWeek = date.get(weekNumbering.weekOfWeekBasedYear());
        return currentWeek;
    }

    public boolean verifierSiSoldeSuperieurOuEgale(double montant) {
        return carteInfidelite.verifierSiSoldeSuperieurOuEgale(montant);
    }

    public void incrementerNombreDePoints(double nombrePoints, Partenaire partenaire) {
        carteInfidelite.augmenterPoint(nombrePoints);
        Operation operation = new Operation(partenaire, new Date(), this, Type.CREDIT.toString(), 0, nombrePoints);
        Database database = new Database();
        database.save(carteInfidelite);
        database.save(operation);
    }

    public void reduireSolde(double montant, Partenaire partenaire) {
        carteInfidelite.deduireSolde(montant);
        Operation operation = new Operation(partenaire, new Date(), this, Type.DEBIT.toString(), montant);
        Database database = new Database();
        database.save(carteInfidelite);
        database.save(operation);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void reduireNombreDePoints(double nombrePointsCadeau, Partenaire partenaire) {
        carteInfidelite.deduirePoint(nombrePointsCadeau );
        Operation operation = new Operation(partenaire, new Date(), this, Type.DEBIT.toString(), 0, nombrePointsCadeau );
        Database database = new Database();
        database.save(carteInfidelite);
        database.save(operation);
    }
}
