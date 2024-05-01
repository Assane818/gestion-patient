package views;

import java.time.LocalDate;
import java.time.LocalTime;

import entities.DemandeRv;
import enums.Etat;
import enums.Specialite;

public class DemandeRvVue extends View {

    public static DemandeRv saisieRv() {
        LocalDate date;
        LocalTime heure;
        String motif;
        Specialite specialite;
        System.out.println("Entrer la date:");
        date = formatDate(scanner.nextLine());
        System.out.println("Entrer l'heure:");
        heure = formatHeure(scanner.nextLine());
        specialite = demanderSpecialite();
        scanner.nextLine();
        System.out.println("Entrer le motif:");
        motif = scanner.nextLine();
        return new DemandeRv(motif, date, heure, specialite);
    }
    public static void afficherRv(DemandeRv[] demandes){
        for (DemandeRv rv : demandes) {
            if(rv == null) return;
            System.out.println(rv);
        }
    }
     

    public static Specialite demanderSpecialite() {
        int spe;
        do {
            System.out.println("1 - Cardiologie");
            System.out.println("2 - Ophtalmologie");
            System.out.println("3 - Urologie");
            System.out.println("Entrez le numéro de la spécialité:");
            spe = scanner.nextInt();
        } while (spe < 1 || spe > 3);
        return Specialite.values()[spe - 1];
    }
    public static Etat demanderEtat() {
        int etat;
        do {
            System.out.println("1 - Encours");
            System.out.println("2 - Valider");
            System.out.println("3 - Annuler");
            System.out.println("Entrez le numéro de l'état:");
            etat = scanner.nextInt();
        } while (etat < 1 || etat > 3);

        return Etat.values()[etat - 1];
    }

    public static Etat validerEtat() {
        int etat;
        do {
            System.out.println("1 - Valider");
            System.out.println("2 - Annuler");
            System.out.println("Entrez le numéro de l'etat:");
            etat = scanner.nextInt();
        } while (etat < 1 || etat > 2);

        return Etat.values()[etat];
    }
}
