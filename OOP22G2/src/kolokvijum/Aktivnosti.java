package kolokvijum;

public abstract class Aktivnosti {
    private String naziv;
    private double minimum;
    private double maximum;
    private SMER smer;

    public Aktivnosti(String naziv,SMER smer, double minimum, double maximum) {

    }
    public abstract int izracunajOcenu(double brojPoena);

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Aktivnosti aktivnost = (Aktivnosti) obj;
        return this.smer.equals(aktivnost.smer) && this.naziv.equals(aktivnost.naziv);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    public SMER getSmer() {
        return smer;
    }

    public void setSmer(SMER smer) {
        this.smer = smer;
    }
}
