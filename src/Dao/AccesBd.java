package Dao;

import Entity.Agence;
import Entity.Client;

import java.util.ArrayList;

public class AccesBd {

    private ArrayList<Client> listeClientDb = new ArrayList<Client>();
    private ArrayList<Agence> listeAgenceDb = new ArrayList<Agence>();

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
               for (Client cl : listeClientDb) {
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
