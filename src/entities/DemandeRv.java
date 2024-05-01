package entities;

import java.time.LocalDate;
import java.time.LocalTime;

import enums.Etat;
import enums.Specialite;

public class DemandeRv extends AbstractEntity{
    private static int nbreDemande;
    private String motif;
    private LocalDate date;
    private LocalTime heure;
    private Etat etat;
    private Specialite specialite;
    private Patient patient;

    public DemandeRv(String motif, LocalDate date, LocalTime heure, Specialite specialite) {
        this.motif = motif;
        this.date = date;
        this.heure = heure;
        this.specialite = specialite;
    }

    public DemandeRv() {

    }

    public static int getNbreDemande() {
        return ++nbreDemande;
    }

    public String getMotif() {
        return motif;
    }
    public void setMotif(String motif) {
        this.motif = motif;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getHeure() {
        return heure;
    }
    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }
    public Etat getEtat() {
        return etat;
    }
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
    public Specialite getSpecialite() {
        return specialite;
    }
    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    @Override
    public String toString() {
        return "DemandeRv [id=" + id + ", motif=" + motif + ", date=" + date + ", heure=" + heure + ", + \", numero" + numero +", etat=" + etat
                + ", specialite=" + specialite + ", patient=" + patient + "]";
    }

    

}
