package kolokvijum;

import java.util.ArrayList;
import java.util.List;

public class Ucenik {
    private String ime;
    private String prezime;
    private String jmbg;
    private Klasa klasa;
    private List<Beleska> beleske = new ArrayList<>();

    public Ucenik(String ime, String prezime, String jmbg, Klasa klasa) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.klasa = klasa;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Ucenik ucenik = (Ucenik) obj;
        return this.jmbg.equals(ucenik.jmbg);
    }

    public void addBeleska(Beleska beleska) {
        for(Beleska b : beleske){
            if(b.equals(beleska)){
                return;
            }
        }
        beleske.add(beleska);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Klasa getKlasa() {
        return klasa;
    }

    public void setKlasa(Klasa klasa) {
        this.klasa = klasa;
    }

    public List<Beleska> getBeleske() {
        return beleske;
    }

    public void setBeleske(List<Beleska> beleske) {
        this.beleske = beleske;
    }
}
