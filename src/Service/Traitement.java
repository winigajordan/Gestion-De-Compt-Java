package Service;

import Dao.AccesBd;
import Entity.Client;
import Entity.Compte;
import Entity.Operation;

import java.util.ArrayList;

public  class Traitement {
    private static AccesBd db = new AccesBd();

    public void getBankStatement(Compte compte){
        ArrayList<Operation> operations = db.showOperationByAccount(compte);
        int sommeCred = 0;
        int sommeDeb = 0;
        System.out.println("Rélevé du compte numéro : " + compte.getNumeroCompte());
        for (Operation operation : operations){
            System.out.println("____________________");
            System.out.println("Numéro d'opération : "+operation.getNumeroOperation());
            System.out.println("Sens opération : "+operation.getSensOperation());
            System.out.println("Date operation : " + operation.getDateOperation());
            System.out.println("Montant de l'opération : "+operation.getMontant());
            if (operation.getSensOperation().equals("CR"))  {
                sommeCred += operation.getMontant();
            } else {
                sommeDeb += operation.getMontant();
            }
        }
        System.out.println("____________________");
        compte.setSolde(Math.abs(sommeCred-sommeDeb));
        if (sommeDeb>=sommeDeb){
            compte.setSensCompte("CR");
        } else {
            compte.setSensCompte("DB");
        }
        System.out.println("Solde global du compte : " + compte.getSolde());
        System.out.println("Sens du compte : " + compte.getSensCompte());

    }
}
