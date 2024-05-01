package views;

import entities.Patient;

public class PatientVue extends View {

    public static Patient saisiePatient() {
        scanner.nextLine();
        System.out.println("Entrer votre nom et prenom:");
        String nomComplet = scanner.nextLine();
        System.out.println("Entrer votre tel:");
        String tel = scanner.nextLine();
        return new Patient(nomComplet, tel);
    }

    public static void afficherPatient(Patient[] patients){
        for (Patient patient : patients) {
            if(patient == null) return;
            System.out.println(patient);
        }
    }
}
