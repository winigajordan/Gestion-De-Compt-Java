package View;

import Dao.AccesBd;
import Entity.Agence;
import Entity.Client;

import java.util.Scanner;

public class Main {

    private static AccesBd bd = new AccesBd();
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        String nomClient, prenomClient, nomAgence, codeAgence;
        Agence ag = null;
        do {
            System.out.println("1- Creer une agence");
            System.out.println("2- Lister des agences");
            System.out.println("3- Creer un client");
            System.out.println("4- Lister les clients de la banque");
            System.out.println("5- Lister les clients d'une agence");
            System.out.println("6- Quitter le programme ");
            System.out.print("\n Faites un choix : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Saisir le code de l'agence");
                    codeAgence = sc.nextLine();
                    System.out.println("Saisir le nom de l'agence");
                    nomAgence = sc.nextLine();
                    ag = new Agence(codeAgence, nomAgence);
                    bd.addAgence(ag);
                    break;
                case 2:
                    bd.showAgences();
                    break;
                case 3:
                    System.out.println("Saisir le code de l'agence");
                    codeAgence = sc.nextLine();
                    ag = bd.searchAgencyByNumber(codeAgence);
                    if (ag==null){
                        System.out.println("Agence inexistante");
                    } else {
                        System.out.println("Saisir le nom du client");
                        nomClient = sc.nextLine();
                        System.out.println("Saisir le prenom du client");
                        prenomClient = sc.nextLine();
                        Client client = new Client(nomClient, prenomClient);
                        bd.addClient(client, ag);
                    }
                    break;
                case 4:
                    bd.showClients();
                    break;
                case 5:
                    System.out.println("Saisir le code de l'agence");
                    codeAgence = sc.nextLine();
                    bd.showClientsByAgency(codeAgence);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (choice != 6);
        System.out.println("Fin de l'application");
    }
}