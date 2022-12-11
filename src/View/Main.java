package View;

import Dao.AccesBd;
import Entity.*;
import Service.Traitement;

import java.util.Scanner;

public class Main {

    private static AccesBd bd = new AccesBd();
    private static Traitement traitement = new Traitement();
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        String nomClient, prenomClient, nomAgence, codeAgence, matriculeClient, numeroCompte, sensOperation;
        Agence ag = null;
        Client client = null;
        Compte compte = null;
        Operation operation = null;
        double tia, agios;
        int montantOperation;
        do {
            System.out.println("1- Creer une agence");
            System.out.println("2- Lister des agences");
            System.out.println("3- Creer un client");
            System.out.println("4- Lister les clients de la banque");
            System.out.println("5- Lister les clients d'une agence");
            System.out.println("6- Creer un compte epargne");
            System.out.println("7- Creer un compte courant");
            System.out.println("8- Lister les comptes epargnes");
            System.out.println("9- Lister les comptes courant");
            System.out.println("10- Lister tous les comptes");
            System.out.println("11- Mise à jour des comptes");
            System.out.println("12- Afficher le(s) comptes d'un client");
            System.out.println("13- Effectuer une opération");
            System.out.println("14- Afficher le relever bancaire d'un compte ");
            System.out.println("13- Quitter le programme ");

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
                        client = new Client(nomClient, prenomClient);
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
                    System.out.println("Saisir le matricule du client");
                    matriculeClient = sc.nextLine();
                    client = bd.searchClientByNumber(matriculeClient);
                    if (client==null)
                        System.out.println("Numéro de client inconnu");
                    else {
                        System.out.println("Saisir le numéro de compte");
                        numeroCompte = sc.nextLine();
                        System.out.println("Saisir le taux d'interêt annuel");
                        tia = sc.nextDouble();
                        sc.nextLine();
                        CompteEpargne compteEpargne = new CompteEpargne(numeroCompte, tia);
                        bd.addCompteEparge(compteEpargne, client);
                    }
                    break;
                case 7:
                    System.out.println("Saisir le matricule du client");
                    matriculeClient = sc.nextLine();
                    client = bd.searchClientByNumber(matriculeClient);
                    if (client==null)
                        System.out.println("Numéro de client inconnu");
                    else {
                        System.out.println("Saisir le numéro de compte");
                        numeroCompte = sc.nextLine();
                        System.out.println("Saisir le taux agios");
                        agios = sc.nextDouble();
                        sc.nextLine();
                        CompteCourant compteEpargne = new CompteCourant(numeroCompte, agios);
                        bd.addCompteCoutant(compteEpargne, client);
                    }
                    break;
                case 8:
                    bd.showCompteEpargne();
                    break;
                case 9:
                    bd.showCompteCourant();
                    break;
                case 10:
                    bd.showAllAccount();
                    break;
                case  11:
                    bd.updateAllAccount();
                    break;
                case 12:
                    System.out.println("Saisir le matricule du client");
                    matriculeClient = sc.nextLine();
                    client = bd.searchClientByNumber(matriculeClient);
                    if (client==null)
                        System.out.println("Matricule invalide");
                    else {
                        bd.showAccountByClient(client);
                    }
                    break;
                case 13:
                    System.out.println("Numéro de compte");
                    numeroCompte = sc.nextLine();
                    compte = bd.searchAccount(numeroCompte);
                    if (compte==null){
                        System.out.println("Compte innexistant");
                    }
                    else {
                        System.out.println("Montant de l'opération");
                        montantOperation = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Sens de de l'opération [DB ou CR]");
                        sensOperation = sc.nextLine();
                        operation = new Operation(sensOperation, montantOperation);
                        bd.addOperation(compte, operation);
                    }
                    break;
                case 14:
                    System.out.println("Numéro de compte");
                    numeroCompte = sc.nextLine();
                    compte = bd.searchAccount(numeroCompte);
                    if (compte==null){
                        System.out.println("Compte innexistant");
                    }
                    else {
                        traitement.getBankStatement(compte);
                    }

                    break;
                case 15:
                    break;
                default:
                    System.out.println("Choix invalide !!!");
            }
        } while (choice != 15);
        System.out.println("Fin de l'application");
    }
}