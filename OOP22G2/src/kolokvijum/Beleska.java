package kolokvijum;

import java.time.LocalDate;
import java.util.Objects;

public class Beleska {

    private Ucenik ucenik;
    private Aktivnosti aktivnost;
    private int trajanje;
    private String opis;
    private double brojPoena;
    private LocalDate datum;

    public Beleska(Ucenik ucenik, Aktivnosti aktivnost, int trajanje, String opis, double brojPoena) {
        this.ucenik = ucenik;
        this.aktivnost = aktivnost;
        this.trajanje = trajanje;
        this.opis = opis;
        this.brojPoena = brojPoena;
        this.datum = LocalDate.now();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Beleska beleska = (Beleska) object;
        return trajanje == beleska.trajanje && Double.compare(brojPoena, beleska.brojPoena) == 0 && Objects.equals(ucenik, beleska.ucenik) && Objects.equals(aktivnost, beleska.aktivnost) && Objects.equals(opis, beleska.opis) && Objects.equals(datum, beleska.datum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ucenik, aktivnost, trajanje, opis, brojPoena, datum);
    }

    public Ucenik getUcenik() {
        return ucenik;
    }

    public void setUcenik(Ucenik ucenik) {
        this.ucenik = ucenik;
    }

    public Aktivnosti getAktivnost() {
        return aktivnost;
    }

    public void setAktivnost(Aktivnosti aktivnost) {
        this.aktivnost = aktivnost;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getBrojPoena() {
        return brojPoena;
    }

    public void setBrojPoena(double brojPoena) {
        this.brojPoena = brojPoena;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
