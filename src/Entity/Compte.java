package Entity;

import Service.Operation;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Compte implements Serializable {
    protected String numeroCompte;
    protected String sensCompte; //débiteur ou créditeur
    protected double solde;
    protected Client client;
    protected ArrayList<Operation> listeOperations;



    public Compte(String numeroCompte){
        this.numeroCompte = numeroCompte;
        this.sensCompte = "C";
        this.solde = 0;
        listeOperations = new ArrayList<Operation>();
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getSensCompte() {
        return sensCompte;
    }

    public void setSensCompte(String sensCompte) {
        this.sensCompte = sensCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public void setListeOperations(ArrayList<Operation> listeOperations) {
        this.listeOperations = listeOperations;
    }

    public abstract void afficher();
    public abstract void updateAccount();

}
