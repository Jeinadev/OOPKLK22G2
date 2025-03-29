package kolokvijum;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dnevnik implements ImaProsek{

    private List<Aktivnosti> aktivnosti = new ArrayList<Aktivnosti>();
    private List<Beleska> beleske = new ArrayList<>();
    private List<Klasa> klase = new ArrayList<>();

    public Dnevnik() {}

    public Klasa dodajKlasu(SMER smer, int razred, int odeljenje, String razredniStaresina) {
        Klasa novaKlasa = new Klasa(smer, razred, odeljenje, razredniStaresina);
        for (Klasa k : klase) {
            if(k.equals(novaKlasa)) {
                System.err.println("OVA KLASA VEC POSTOJI");
                return k;
            }
        }
        klase.add(novaKlasa);
        return novaKlasa;
    }

    public List<Klasa> nadjiKlaseZaSmer(SMER smer){
        List<Klasa> nadjiKlase = new ArrayList<>();
        for (Klasa k : klase) {
            if(k.getSmer().equals(smer)) {
                nadjiKlase.add(k);
            }
        }
        return nadjiKlase;
    }
    public Ucenik dodajUcenika(String ime, String prezime, String jmbg, int razred, int odeljenje,SMER smer) {
        Klasa klasa = dodajKlasu(smer, razred, odeljenje, prezime);
        Ucenik noviUcenik = new Ucenik(ime, prezime, jmbg, klasa);
        List<Ucenik> ucenici = klasa.getUcenici();
        for(Ucenik ucenik : ucenici) {
            if(ucenik.equals(noviUcenik)) {
                return null;
            }
        }
        klasa.addUcenik(noviUcenik);
        return noviUcenik;
    }
    public Aktivnosti dodajAktivnosti(Aktivnosti aktivnost) {
        for(int i = 0; i < this.aktivnosti.size(); i++){
            if(this.aktivnosti.get(i).equals(aktivnost)) {
                i = this.aktivnosti.size() - 1;
                return this.aktivnosti.get(i);
            }
        }
        this.aktivnosti.add(aktivnost);
        return aktivnost;
    }
    public Beleska dodajBelesku(Ucenik ucenik, Aktivnosti aktivnost, int trajanje, String opis, double brPoena) {
        SMER smer = ucenik.getKlasa().getSmer();
        if (!smer.equals(aktivnost.getSmer()) && trajanje >= 5) {
            Beleska novaBeleska = new Beleska(ucenik, aktivnost, trajanje, opis, brPoena);
            ucenik.addBeleska(novaBeleska);
            beleske.add(novaBeleska);
            return novaBeleska;
        }
        System.err.println("USLOVI NISU ISPUNJENI");
        return null;
    }
    @Override
    public double prosek(){
        int trajanje = 0;
        int cnt = beleske.size();
        for(Beleska beleska : beleske) {
            trajanje += beleska.getTrajanje();
        }
        return (double)trajanje / (double)cnt;
    }

    public double prosecnaOcenaAktivnosti(Ucenik ucenik) {
        List<Beleska> beleske = getBeleskeSortiranePoDatumu(ucenik.getBeleske());
        List<LocalDate> datumi = new ArrayList<>();
        List<String> naziviAktivnosti = new ArrayList<>();
        List<Integer> brojPoena = new ArrayList<>();
        List<Integer> ocene = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String ime = ucenik.getIme() + ucenik.getPrezime();
        if(beleske.isEmpty()) {
            System.out.println("NEMA ZABELEZENIH AKTIVNOSTI");
            return 0;
        }
        for(Beleska beleska : beleske) {
            datumi.add(beleska.getDatum());
            naziviAktivnosti.add(beleska.getAktivnost().getNaziv());
            brojPoena.add((int)beleska.getBrojPoena());
            ocene.add(beleska.getAktivnost().izracunajOcenu((beleska.getBrojPoena())));
        }
        sb.append("Ucenik: ").append(ime).append(":\n");
        for(int i = 0; i < beleske.size(); i++) {
            sb.append(datumi.get(i)).append("-");
            sb.append(naziviAktivnosti.get(i)).append("-");
            sb.append(brojPoena.get(i)).append("-");
            sb.append(ocene.get(i)).append("\n");
        }
        int ukupanBrojPoena = 0;
        for(Integer broj : brojPoena) {
            ukupanBrojPoena += broj;
        }
        sb.append(ukupanBrojPoena).append(" Prosecna ocena [");
        double sumaOcena = 0.0;
        for(Integer ocena : ocene) {
            sumaOcena += ocena;
        }
        double prosecna = sumaOcena / ocene.size();
        sb.append(prosecna).append("]\n");

        try{
            FileWriter fw = new FileWriter("izlaz.txt");
            fw.write(sb.toString());
            fw.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return prosecna;
    }
    public List<Beleska> getBeleskeSortiranePoDatumu(List<Beleska> beleske) {
        beleske.sort(Comparator.comparing(Beleska::getDatum));
        return beleske;
    }
    public List<Aktivnosti> getAktivnosti() {
        return aktivnosti;
    }

    public void setAktivnosti(List<Aktivnosti> aktivnosti) {
        this.aktivnosti = aktivnosti;
    }

    public List<Beleska> getBeleske() {
        return beleske;
    }

    public void setBeleske(List<Beleska> beleske) {
        this.beleske = beleske;
    }

    public List<Klasa> getKlase() {
        return klase;
    }

    public void setKlase(List<Klasa> klase) {
        this.klase = klase;
    }
}
