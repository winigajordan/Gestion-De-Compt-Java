package Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Agence implements Serializable {
    private String codeAg;
    private String nomAg;
    private ArrayList<Client> listeClients;


    public Agence(String codeAg, String nomAg) {
        listeClients = new ArrayList<Client>();
        this.codeAg = codeAg;
        this.nomAg = nomAg;
    }

    public ArrayList<Client> getListeClients() {
        return listeClients;
    }

    public void setListeClients(ArrayList<Client> listeClients) {
        this.listeClients = listeClients;
    }

    public String getCodeAg() {
        return codeAg;
    }

    public void setCodeAg(String codeAg) {
        this.codeAg = codeAg;
    }

    public String getNomAg() {
        return nomAg;
    }

    public void setNomAg(String nomAg) {
        this.nomAg = nomAg;
    }

    public void addClientToAgency(Client client){
        this.listeClients.add(client);
    }
}
