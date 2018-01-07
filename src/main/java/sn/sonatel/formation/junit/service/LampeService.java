package sn.sonatel.formation.junit.service;

import sn.sonatel.formation.junit.exception.NullLampeException;
import sn.sonatel.formation.junit.modele.Lampe;

import java.util.List;

/**
 * Created by ext_sow18 on 03/01/2018.
 */
public interface LampeService {

    void allumerListe(List<Lampe> lampes) throws NullLampeException;
    void allumer(Lampe lampe) throws NullLampeException;
    void eteindreListe(List<Lampe> lampes) throws NullLampeException;
    void eteindre(Lampe lampe) throws NullLampeException;

}
