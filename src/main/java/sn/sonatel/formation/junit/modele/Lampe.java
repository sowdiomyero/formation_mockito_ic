package sn.sonatel.formation.junit.modele;

/**
 * Created by ext_sow18 on 05/01/2018.
 */
public class Lampe {

    public static enum STATE {ON, OFF}

    private String id;
    private STATE etat;
    private String emplacement;

    public Lampe() {
    }

    public Lampe(STATE etat, String emplacement) {
        this.etat = etat;
        this.emplacement = emplacement;
    }

    public STATE getEtat() {
        return etat;
    }

    public void setEtat(STATE etat) {
        this.etat = etat;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
