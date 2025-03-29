package kolokvijum;

public class Praksa extends Aktivnosti{

    public Praksa(String naziv) {
        SMER smer = SMER.APOTEKAR;
        super(naziv, smer, 0, 100);
    }

    @Override
    public int izracunajOcenu(double brPoena) {
        int ocena = 0;
        if(brPoena <= 52){
            ocena = 1;
        } else if (brPoena <= 64) {
            ocena = 2;
        } else if (brPoena <= 76) {
            ocena = 3;
        } else if (brPoena <= 88) {
            ocena = 4;
        } else if (brPoena <= 100) {
            ocena = 5;
        }

        return ocena;
    }
}
