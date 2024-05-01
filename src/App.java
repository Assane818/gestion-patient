import java.util.Scanner;

import entities.DemandeRv;
import entities.Patient;
import enums.Etat;
import services.DemandeRvService;
import services.PatientService;
import views.DemandeRvVue;
import views.PatientVue;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        PatientVue.setScanner(scanner);
        DemandeRvVue.setScanner(scanner);
        PatientService patientService = new PatientService();
        DemandeRvService demandeRvService = new DemandeRvService();
        int choix;
        do {
            choix = showMenu();
            switch (choix) {
                case 1 ->{
                    patientService.add(PatientVue.saisiePatient());
                }
                case 2 ->{
                    PatientVue.afficherPatient(patientService.lister());
                } 
                case 3 ->{
                   Patient p = patientService.getRvByNumero(PatientVue.saisieNumero());
                   if(p == null) {
                    System.out.println("Erreur sur le numero");
                   } else {
                    DemandeRv rv = DemandeRvVue.saisieRv();
                    rv.setPatient(p);
                    demandeRvService.add(rv);
                   }
                }
                case 4 ->{
                    DemandeRvVue.afficherRv(demandeRvService.lister(DemandeRvVue.demanderEtat()));
                }
                case 5 ->{
                    DemandeRvVue.afficherRv(demandeRvService.lister(DemandeRvVue.demanderSpecialite()));
                } 
                case 6 ->{
                   DemandeRv rv = demandeRvService.getRvByNumero(DemandeRvVue.saisieNumero());
                   if(rv == null) {
                    System.out.println("Erreur sur le numero");
                   } else {
                        if(rv.getEtat() != Etat.encours) {
                            System.out.println("Ce RV est dejas traiter");
                    } else {
                        System.out.println(rv);
                        demandeRvService.traiterRv(rv, DemandeRvVue.validerEtat());
                    }
                   }
                }    
                default->{
                    System.out.println("Choix invalide");
                }
            }
        } while (choix != 7);
    }

    public static int showMenu() {
        System.out.println("1-Ajouter un Patient dans le Tableau");
        System.out.println("2-Lister tous les patients du Tableau");
        System.out.println("3-Enregistrer un RV pour un patient");
        System.out.println("4-Lister tous les RV par Etat");
        System.out.println("5-Lister tous les RV par Spécialité");
        System.out.println("6-Traiter RV");
        System.out.println("7-Quitter");
        System.out.println("Entrez votre choix:");
        return scanner.nextInt();
    }
}
