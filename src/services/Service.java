package services;

import entities.AbstractEntity;

public abstract class Service<T extends AbstractEntity > implements IService<T>{
    protected static final int N = 5;
    protected T[] tab;
    protected int nbr;

    public String generateNumero(int nbr,String format) {
        int size = String.valueOf(nbr).length();
        return format+"0".repeat((4-size)<0?0:4-size)+nbr;
    }

    public T[] lister() {
        return tab;
    }

    public T getRvByNumero(String numero) {
        for (T rv : tab) {
            if(rv != null && rv.getNumero().compareToIgnoreCase(numero) == 0) {
                return rv;
            }
        }
        return null;
    }
}
