package Dao;

import Entity.*;

import java.util.ArrayList;

public class AccesBd {

    private ArrayList<Client> listeClientDb = new ArrayList<Client>();
    private ArrayList<Agence> listeAgenceDb = new ArrayList<Agence>();
    private ArrayList<Compte> listeCompteDb = new ArrayList<Compte>();

    public Client searchClientByNumber(String matricule)
    {
        Client client = null;
        for (Client x : listeClientDb)
        {
            if (x.getMatriculeClient().equals(matricule)){
                client = x;
            }
        }
        return client;
    }

    public void addCompteEparge(CompteEpargne epargne, Client client){
        epargne.setClient(client);
        client.getListeComptes().add(epargne);
        listeCompteDb.add(epargne);
    }

    public void showCompteEpargne(){
        for (Compte compte : listeCompteDb){
            if ( compte instanceof CompteEpargne){
                //casting
                CompteEpargne epargne = (CompteEpargne) compte;
                System.out.println("____________________");
                epargne.afficher();
            }
        }
        System.out.println("____________________");
    }

    public void updateAllAccount(){
        for (Compte y : listeCompteDb){
            y.updateAccount();
        }
    }

    public void showCompteCourant(){
        for (Compte compte : listeCompteDb){
            if ( compte instanceof CompteCourant){
                //casting
                CompteCourant courant = (CompteCourant) compte;
                System.out.println("____________________");
                courant.afficher();
            }
        }
        System.out.println("____________________");
    }

    public void addCompteCoutant(CompteCourant courant, Client client){
        courant.setClient(client);
        client.getListeComptes().add(courant);
        listeCompteDb.add(courant);
    }

    public Agence searchAgencyByNumber(String numAg)
    {
        Agence ag = null;
        for (Agence x : listeAgenceDb)
        {
            if (x.getCodeAg().equals(numAg)){
                ag = x;
            }
        }
        return ag;
    }

    public void showAllAccount(){
        for (Compte compte : listeCompteDb){
            System.out.println("____________________");
            compte.afficher();
        }
        System.out.println("____________________");
    }

    public void showAccountByClient(Client client){
        ArrayList<Compte>  accountList = client.getListeComptes();
        for (Compte compte : accountList){
            System.out.println("____________________");
            compte.afficher();
        }
        System.out.println("____________________");

    }

    public void addClient(Client client, Agence agence)
    {

            client.setAgence(agence);
            listeClientDb.add(client);
            agence.getListeClients().add(client);

        //listeClientDb.add(client);
    }

    public void addAgence(Agence agence)
    {
        listeAgenceDb.add(agence);
        System.out.println("Agence crée avec succès");
    }

    public void showAgences(){
        for (Agence ag : listeAgenceDb){
            System.out.println("____________________");
            System.out.println("Code agence : "+ ag.getCodeAg());
            System.out.println("Nom agence : "+ ag.getNomAg());
        }
        System.out.println("____________________");
    }

    public void showClients(){
        for (Client cl : listeClientDb){
            System.out.println("____________________");
            System.out.println("Numéro du client : " + cl.getMatriculeClient());
            System.out.println("Nom client : "+ cl.getNomClient());
            System.out.println("Prenom du client : "+cl.getPrenomClient());
            System.out.println("Nom de l'agence : "+ cl.getAgence().getNomAg());
        }
        System.out.println("____________________");
    }

    public void showClientsByAgency(String numAg){
        Agence ag = searchAgencyByNumber(numAg);
        if (ag == null){
            System.out.println("Agence innexistante");
        } else {
           ArrayList<Client> listClients = ag.getListeClients();
           if (listClients.size()==0) {
               System.out.println("Liste des clients vide");
           } else {
               for (Client cl : listClients) {
                   System.out.println("____________________");
                   System.out.println("Numéro du client : " + cl.getMatriculeClient());
                   System.out.println("Nom client : " + cl.getNomClient());
                   System.out.println("Prenom du client : " + cl.getPrenomClient());
                   System.out.println("Nom de l'agence : " + cl.getAgence().getNomAg());
               }
               System.out.println("____________________");
           }
        }
    }
}
