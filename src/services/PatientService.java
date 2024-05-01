package services;

import entities.Patient;

public class PatientService extends Service<Patient> {

    public PatientService () {
        tab = new Patient[N];
    }
    @Override
    public boolean add(Patient p){
        if(nbr < N){
            int id = generateId();
            p.setId(id);
            p.setNumero(generateNumero(id, "PAT"));
            tab[nbr++] = p;
            return true;
        }
        else{
            return false;
        }
    }

    public int generateId() {
        return Patient.getNbrePatient();
    }
}
