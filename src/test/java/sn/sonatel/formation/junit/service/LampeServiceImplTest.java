package sn.sonatel.formation.junit.service;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import sn.sonatel.formation.junit.dao.LampeDao;
import sn.sonatel.formation.junit.dao.LampeDaoImpl;
import sn.sonatel.formation.junit.exception.NullLampeException;
import sn.sonatel.formation.junit.modele.Lampe;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ext_sow18 on 05/01/2018.
 */
public class LampeServiceImplTest {

    static LampeDao dao;

    @BeforeClass
    public static void setUp(){
        dao = new LampeDaoImpl();
        Lampe l = new Lampe(Lampe.STATE.OFF,"Salon");
        Lampe lc1 = new Lampe(Lampe.STATE.OFF,"Chambre01");
        Lampe lc2 = new Lampe(Lampe.STATE.OFF,"Chambre02");
        dao.ajouter(l);
        dao.ajouter(lc1);
        dao.ajouter(lc2);
    }

    @Test(expected = NullLampeException.class)
    public void allumerShouldThrowNullLampeException() throws Exception {
        LampeService service = new LampeServiceImpl(dao);
        service.allumer(null);
    }

    @Test
    public void allumerShouldSuccess() throws Exception {
        LampeService service = new LampeServiceImpl(dao);
        List<Lampe> l = dao.rechercher("Salon");
        service.allumer(l.get(0));
        assertEquals(Lampe.STATE.ON, l.get(0).getEtat());
    }

    @Test(expected = IllegalArgumentException.class)
    public void allumerShouldThrowExceptionBecauseStateIsOn() throws Exception {
        LampeService service = new LampeServiceImpl(dao);
        List<Lampe> l = dao.rechercher("Salon");
        l.get(0).setEtat(Lampe.STATE.ON);
        service.allumer(l.get(0));
    }

    @Test @Ignore
    public void eteindre() throws Exception {
    }

    @Test  @Ignore
    public void eteindre1() throws Exception {
    }

}