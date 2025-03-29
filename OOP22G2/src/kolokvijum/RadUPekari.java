package kolokvijum;

public class RadUPekari extends Aktivnosti{
    public RadUPekari(String naziv) {
        SMER smer = SMER.PEKAR;
        super(naziv, smer, 1, 10);
    }

    @Override
    public int izracunajOcenu(double brPoena) {
        double ocena = (brPoena * 0.75 - 1.75);
        return (int)ocena;
    }
}
