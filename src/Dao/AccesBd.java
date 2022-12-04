package Dao;

import Entity.Agence;
import Entity.Client;

import java.util.ArrayList;

public class AccesBd {

    private ArrayList<Client> listeClientDb = new ArrayList<Client>();
    private ArrayList<Agence> listeAgenceDb = new ArrayList<Agence>();

    public Agence searchByNumber(String numAg)
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

    public void addClient(Client client, String numAgence)
    {
        Agence ag = searchByNumber(numAgence);
        if (ag == null){
            System.out.println("Agence innexistante");
        } else {
            client.setAgence(ag);
            listeClientDb.add(client);
            ag.addClientToAgency(client);
        }
        //listeClientDb.add(client);
    }

    public void addAgence(Agence agence)
    {

    }
}
