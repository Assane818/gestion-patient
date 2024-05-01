package services;

import entities.DemandeRv;
import enums.Etat;
import enums.Specialite;

public class DemandeRvService extends Service<DemandeRv>{
    public DemandeRvService() {
        tab = new DemandeRv[N];
    }

    public int generateId() {
        return DemandeRv.getNbreDemande();
    }

    public DemandeRv[] lister(Etat etat){
        DemandeRv[] rvEtat = new DemandeRv[N];
        int nbrEtat = 0;
        for (DemandeRv demandeRv : tab) {
            if(demandeRv != null && demandeRv.getEtat() == etat) {
                rvEtat[nbrEtat++] = demandeRv;
            }
        }
        return rvEtat;
    }

    public DemandeRv[] lister(Specialite specialite){
        DemandeRv[] rvSpe = new DemandeRv[N];
        int nbrSpe = 0;
        for (DemandeRv demandeRv : tab) {
            if(demandeRv != null && demandeRv.getSpecialite() == specialite) {
                rvSpe[nbrSpe++] = demandeRv;
            }
        }
        return rvSpe;
    }

    @Override
    public boolean add(DemandeRv rv) {
        if(nbr < N) {
            int id = generateId();
            rv.setId(id);
            rv.setNumero(generateNumero(id, "RV"));
            rv.setEtat(Etat.encours);
            tab[nbr++] = rv;
            return true;
        }
        return false;
    }

    public boolean traiterRv(DemandeRv rv, Etat etat){
        boolean result = false;
        switch (rv.getEtat()) {
            case encours:
                rv.setEtat(etat);
                result = true;
                break;
        
            default:
                break;
        }
        return result;
    }
}
