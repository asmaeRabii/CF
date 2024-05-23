package model;
import java.io.Serializable;
public class Employe implements Serializable {
    private final String nom, prenom, cin, fonction;
    private final int age, doti;
    public Employe(String n,String pn,String ci,String fon,int ag, int dot){
        nom = n;
        prenom = pn;
        cin = ci;
        fonction = fon;
        age = ag;
        doti = dot;
    }
    public int getAge() {
        return age;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getCin() {
        return cin;
    }
    public String getFonction() {
        return fonction;
    }
    public int getDoti() {
        return doti;
    }

}

