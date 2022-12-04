package Entity;

import java.io.Serializable;

public abstract class Compte implements Serializable {
    protected String numeroCompte;
    protected String sensCompte; //débiteur ou créditeur
    protected double solde;
    protected Client client;



    public Compte(String numeroCompte){
        this.numeroCompte = numeroCompte;
        this.sensCompte = "C";
        this.solde = 0;
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

    public abstract void afficher();
    public abstract void updateAccount();

}
