package Entity;

import java.io.Serializable;

public class CompteEpargne  extends Compte {

    private double tauxInteret;

    public CompteEpargne(String numeroCompte, double tauxInteret) {
        super(numeroCompte);
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
    @Override
    public void afficher() {
        System.out.println("Numéro du compte : "+ numeroCompte);
        System.out.println("Solde du compte : "+ solde);
        System.out.println("Sens du compte : "+ sensCompte);
    }

    @Override
    public void updateAccount() {
        double tim = tauxInteret/1200;
    }
}
