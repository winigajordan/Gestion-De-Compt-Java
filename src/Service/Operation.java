package Service;

import Entity.Compte;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operation implements Serializable {
    private String numeroOperation;
    private String sensOperation;
    private int montant;
    private String dateOperation;
    private Compte compte;
    private static int incrementeur=0;

    public Operation(String sensOperation, int montant) {
        numeroOperation = "OPERATION--"+(++incrementeur);
        this.sensOperation = sensOperation;
        this.montant = montant;
        DateTimeFormatter fr = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");
        dateOperation = LocalDateTime.now().format(fr);
    }

    public String getNumeroOperation() {
        return numeroOperation;
    }

    public void setNumeroOperation(String numeroOperation) {
        this.numeroOperation = numeroOperation;
    }

    public String getSensOperation() {
        return sensOperation;
    }

    public void setSensOperation(String sensOperation) {
        this.sensOperation = sensOperation;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public static int getIncrementeur() {
        return incrementeur;
    }

    public static void setIncrementeur(int incrementeur) {
        Operation.incrementeur = incrementeur;
    }
}
