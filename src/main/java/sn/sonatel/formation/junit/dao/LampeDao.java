package sn.sonatel.formation.junit.dao;

import sn.sonatel.formation.junit.modele.Lampe;

import java.util.List;

/**
 * Created by ext_sow18 on 05/01/2018.
 */
public interface LampeDao {

    public String ajouter(Lampe lampe);
    public Lampe modifier(Lampe lampe);
    public List<Lampe> rechercher (String emplacement);
    public List<Lampe> lister();

}
