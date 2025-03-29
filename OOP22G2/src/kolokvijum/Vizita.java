package kolokvijum;

public class Vizita extends Aktivnosti{

    public Vizita(String naziv) {
        SMER smer = SMER.LEKAR;
        super(naziv, smer, 1, 5);
    }

    @Override
    public int izracunajOcenu(double brPoena) {
        double ocena = (brPoena * 0.75 + 1.25);
        return (int)ocena;
    }
}
