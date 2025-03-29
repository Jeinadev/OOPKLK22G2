package kolokvijum;

public class Test {
    public static void main(String[] args) {
        Dnevnik dnevnik = new Dnevnik();

        Klasa k1 = dnevnik.dodajKlasu(SMER.PEKAR,5,2,"Merdzan Ibraimi");
        Klasa k2 = dnevnik.dodajKlasu(SMER.LEKAR,7,2,"Slavica Nesic");
        Klasa k3 = dnevnik.dodajKlasu(SMER.APOTEKAR,2,5,"Branko Loncar");

        Praksa a1 = new Praksa("Probiotici praksa");
        Vizita a2 = new Vizita("Anatomija");
        Praksa a3 = new Praksa("Hemija");
        dnevnik.dodajAktivnosti(a1);
        dnevnik.dodajAktivnosti(a2);
        dnevnik.dodajAktivnosti(a3);

        Ucenik u1 = dnevnik.dodajUcenika("Ivan", "Jeina","4755623466", 8, 2, SMER.PEKAR);
        Ucenik u2 = dnevnik.dodajUcenika("Marija", "Saric","47215213466", 7, 2, SMER.LEKAR);
        Ucenik u3 = dnevnik.dodajUcenika("Nikola", "Joksimovic","1425333466", 7, 2, SMER.LEKAR);
        Ucenik u4 = dnevnik.dodajUcenika("Petar", "Peric","46326332466", 5, 2, SMER.PEKAR);
        Ucenik u5 = dnevnik.dodajUcenika("Iva", "Zivkovic","47556234266", 2, 5, SMER.APOTEKAR);
        Ucenik u6 = dnevnik.dodajUcenika("Ivana", "Djilas","46524323466", 5, 2, SMER.APOTEKAR);
        Ucenik u7 = dnevnik.dodajUcenika("Mateja", "Alibabic","43556234626", 8, 2, SMER.PEKAR);
        Ucenik u8 = dnevnik.dodajUcenika("Sara", "Guzina","23462346556", 2, 5, SMER.LEKAR);
        Ucenik u9 = dnevnik.dodajUcenika("Kosta", "Markovic","47783466676", 5, 2, SMER.APOTEKAR);

        Beleska b1 = dnevnik.dodajBelesku(u1, a1, 35, "Rad sa hidrogenom", 68);
        Beleska b2 = dnevnik.dodajBelesku(u1, a1, 89, "Kontrolni", 68);
        Beleska b3 = dnevnik.dodajBelesku(u1, a1, 4, "Propitivanje usmeno", 68);
        Beleska b4 = dnevnik.dodajBelesku(u2, a2, 335, "Pismeni", 5);
        Beleska b5 = dnevnik.dodajBelesku(u3, a3, 75, "Kontrolni", 4);
        Beleska b6 = dnevnik.dodajBelesku(u3, a3, 65, "Rad na casu", 2);
        Beleska b7 = dnevnik.dodajBelesku(u3, a3, 6, "Pismeni", 3);

        System.out.println("Prosek dnevnika: " + dnevnik.prosek() + "\n");
        System.out.println("Prosek Klase k1: " + k1.prosek() + "\n");
        System.out.println("Prosek Klase k2: " + k2.prosek() + "\n");
        System.out.println("Prosek Klase k3: " + k3.prosek() + "\n");

        dnevnik.prosecnaOcenaAktivnosti(u1);
        dnevnik.prosecnaOcenaAktivnosti(u2);
        dnevnik.prosecnaOcenaAktivnosti(u3);

    }
}
