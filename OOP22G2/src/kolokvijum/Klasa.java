package kolokvijum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klasa implements ImaProsek{
    private int razred;
    private int odeljenje;
    private String razredniStaresina;
    private List<Ucenik> ucenici = new ArrayList<>();
    private SMER smer;

    public Klasa(SMER smer, int razred, int odeljenje, String razredniStaresina) {
        this.smer = smer;
        this.razred = razred;
        this.odeljenje = odeljenje;
        this.razredniStaresina = razredniStaresina;
    }

    public void addUcenik(Ucenik ucenik) {
        for(Ucenik u : ucenici){
            if(u.equals(ucenik)){
                return;
            }
        }
        ucenici.add(ucenik);
    }

    @Override
    public double prosek(){
        int brBeleski = 0;
        int brUcenika = ucenici.size();
        for(Ucenik u : ucenici){
            brBeleski += u.getBeleske().size();
        }
        return (double)brBeleski/brUcenika;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Klasa klasa = (Klasa) obj;
        return this.smer.equals(klasa.smer) && this.razred == klasa.razred && this.odeljenje == klasa.odeljenje;
    }

    public int getRazred() {
        return razred;
    }

    public void setRazred(int razred) {
        this.razred = razred;
    }

    public int getOdeljenje() {
        return odeljenje;
    }

    public void setOdeljenje(int odeljenje) {
        this.odeljenje = odeljenje;
    }

    public String getRazredniStaresina() {
        return razredniStaresina;
    }

    public void setRazredniStaresina(String razredniStaresina) {
        this.razredniStaresina = razredniStaresina;
    }

    public List<Ucenik> getUcenici() {
        return ucenici;
    }

    public void setUcenici(List<Ucenik> ucenici) {
        this.ucenici = ucenici;
    }

    public SMER getSmer() {
        return smer;
    }

    public void setSmer(SMER smer) {
        this.smer = smer;
    }
}
