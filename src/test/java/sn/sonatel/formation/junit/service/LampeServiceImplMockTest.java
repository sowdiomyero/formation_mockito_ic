package sn.sonatel.formation.junit.service;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import sn.sonatel.formation.junit.dao.LampeDao;
import sn.sonatel.formation.junit.dao.LampeDaoImpl;
import sn.sonatel.formation.junit.exception.NullLampeException;
import sn.sonatel.formation.junit.modele.Lampe;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ext_sow18 on 05/01/2018.
 */

public class LampeServiceImplMockTest {

    static LampeDao dao;

    @BeforeClass
    public static void setUp() throws NullLampeException {

        dao = mock(LampeDaoImpl.class);

        Lampe l  =  new Lampe(Lampe.STATE.OFF,"Salon");
        Lampe lc1 = new Lampe(Lampe.STATE.OFF,"Chambre01");
        Lampe lc2 = new Lampe(Lampe.STATE.OFF,"Chambre02");

        when(dao.rechercher("Salon")).thenReturn(Arrays.asList(l));
        when(dao.rechercher("Chambre01")).thenReturn(Arrays.asList(lc1));
        when(dao.rechercher("Chambre02")).thenReturn(Arrays.asList(lc2));

/*        LampeService spy = Mockito.spy(new LampeServiceImpl(dao));

        doAnswer( new Answer<Void>(){
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                Lampe lp = (Lampe) invocationOnMock.getArguments()[0];
                if(lp.getEtat() == Lampe.STATE.OFF)
                    lp.setEtat(Lampe.STATE.ON);
                else
                    lp.setEtat(Lampe.STATE.OFF);
                return null;
            }

        }).when(spy).allumer(l);*/

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