package Entity;

import java.io.Serializable;

public class CompteCourant extends Compte implements Serializable{
    private double agios;
    public CompteCourant(String numeroCompte, double agios) {
        super(numeroCompte);

    }

    @Override
    public void afficher() {
        System.out.println("Numéro du compte : "+ numeroCompte);
        System.out.println("Solde du compte : "+ solde);
        System.out.println("Sens du compte : "+ sensCompte);
        System.out.println("Agios : "+ agios);
        System.out.println("Numéro du client : "+ client.getMatriculeClient());
        System.out.println("Nom du client : "+ client.getNomClient());
        System.out.println("Prenom du client : "+ client.getPrenomClient());

    }

    @Override
    public void updateAccount() {
        solde = solde - (agios/100)*solde;
    }
}
