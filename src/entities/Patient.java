package entities;

public class Patient extends AbstractEntity{
    private String nomComplet,tel;
    private static int nbrePatient;

    public Patient() {

    }
    public Patient(String nomComplet, String tel) {
        this.nomComplet = nomComplet;
        this.tel = tel;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public static int getNbrePatient() {
        return ++nbrePatient;
    }
    @Override
    public String toString() {
        return "Patient [nomComplet=" + nomComplet + ", tel=" + tel + ", numero=" + numero + "]";
    }

    
}
