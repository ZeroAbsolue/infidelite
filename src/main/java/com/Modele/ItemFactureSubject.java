package com.Modele;

public interface ItemFactureSubject {
    public void register(ItemFactureObserver o);
    public void unregister(ItemFactureObserver o);
    public void notifyObservers();
}
