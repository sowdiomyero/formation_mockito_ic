package sn.sonatel.formation.junit.service;

import sn.sonatel.formation.junit.dao.LampeDao;
import sn.sonatel.formation.junit.exception.NullLampeException;
import sn.sonatel.formation.junit.modele.Lampe;

import java.util.List;

/**
 * Created by ext_sow18 on 05/01/2018.
 */
public class LampeServiceImpl implements LampeService {

    private LampeDao dao;

    public LampeServiceImpl(LampeDao dao) {
        this.dao = dao;
    }

    public void allumerListe(List<Lampe> lampes) throws NullLampeException {
        if (lampes ==null || lampes.isEmpty()) throw new NullLampeException();
        for (Lampe l : lampes) {
            allumer(l);
        }
    }

    public void allumer(Lampe lampe) throws NullLampeException {
        if (lampe ==null) throw new NullLampeException();
        if (lampe.getEtat() == Lampe.STATE.ON)
            throw new IllegalArgumentException("Cette Lampe est dejà allumée : " + lampe.getId());
        lampe.setEtat(Lampe.STATE.ON);
        dao.modifier(lampe);
    }

    public void eteindreListe(List<Lampe> lampes) throws NullLampeException {
        if (lampes ==null || lampes.isEmpty()) throw new NullLampeException();
        for (Lampe l : lampes) {
            eteindre(l);
        }
    }

    public void eteindre(Lampe lampe) throws NullLampeException {
        if (lampe ==null) throw new NullLampeException();
        if (lampe.getEtat() == Lampe.STATE.OFF)
            throw new IllegalArgumentException("Cette Lampe est dejà eteinte : " + lampe.getId());
        lampe.setEtat(Lampe.STATE.OFF);
        dao.modifier(lampe);
    }
}
