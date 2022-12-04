package Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable {
    private String matriculeClient;
    private String nomClient;
    private String prenomClient;
    private Agence agence;
    private static int inc=0;
    private ArrayList<Compte> listeComptes;

    public Client(String nomClient, String prenomClient) {
        inc++;
        this.matriculeClient = "CLIENT--"+ String.valueOf(inc);
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
    }

    public String getMatriculeClient() {
        return matriculeClient;
    }

    public void setMatriculeClient(String matriculeClient) {
        this.matriculeClient = matriculeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public ArrayList<Compte> getListeComptes() {
        return listeComptes;
    }

    public void setListeComptes(ArrayList<Compte> listeComptes) {
        this.listeComptes = listeComptes;
    }
}
