package com.Modele;

public interface AbonneSubject {
    public void register(AbonneObserver o);
    public void unregister(AbonneObserver o);
    public void notifyObservers();
}
