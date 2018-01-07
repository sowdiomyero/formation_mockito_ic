package sn.sonatel.formation.junit.dao;

import sn.sonatel.formation.junit.modele.Lampe;

import java.util.*;

/**
 * Created by ext_sow18 on 05/01/2018.
 */

public class LampeDaoImpl implements LampeDao {

    private Map<String, List<Lampe>> bddLampes ;

    public LampeDaoImpl() {
        this.bddLampes = new HashMap<String, List<Lampe>>();
    }


    public String ajouter(Lampe lampe) {

        lampe.setId(UUID.randomUUID().toString());

        if (bddLampes.containsKey(lampe.getEmplacement())){
            List lampes = bddLampes.get(lampe.getEmplacement());
            lampes.add(lampe);
        }else{
            List lampes =new ArrayList<Lampe>();
            lampes.add(lampe);
            bddLampes.put(lampe.getEmplacement(), lampes);
        }

        return lampe.getId();
    }

    public Lampe modifier(Lampe lampe) {
        if(lampe.getId() == null || lampe.getId().isEmpty())
            throw new IllegalArgumentException("Cette lampe n'existe pas");
        if(lampe.getEmplacement() == null || bddLampes.get(lampe.getEmplacement()) == null )
            throw new IllegalArgumentException("Cette lampe n'existe dans aucun emplacement");

        return null;
    }


    public List<Lampe> rechercher(String emplacement) {
        if (bddLampes.containsKey(emplacement)){
            return bddLampes.get(emplacement);
        }
        return null;
    }

    public List<Lampe> lister() {

        List<Lampe> listeLampes = new ArrayList<Lampe>();
        for (List<Lampe> l : bddLampes.values()){
            listeLampes.addAll(l);
        }
        return listeLampes;
    }
}
