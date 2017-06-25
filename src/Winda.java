/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carl
 */
public class Winda {
    private Drzwi drzwi;
    private List<Pietro> pietra;
    private int pozycja;
    private Kierunek kierunek;
    private List<Boolean> zamowienia;
    private int liczbaZamowien;
    public Winda(int iloscPieter){
        drzwi = new Drzwi();
        pietra = new ArrayList<>();
        for(int i = 0; i < iloscPieter; i++){
            pietra.add(new Pietro(i));
        }
        zamowienia = new ArrayList<>();
        for(int i = 0; i < iloscPieter; i++){
            zamowienia.add(false);
        }

        kierunek = Kierunek.POSTUJ;
        liczbaZamowien = 0;
    }

    public void wypiszPietra(){
        System.out.println("***************");
        System.out.println("Drzwi zamkniete: " + drzwi.czyZamkniete());
        for(Pietro p : pietra){
            p.wypisz();
        }
    }

    public List<Pietro> listaPieter(){
        return pietra;
    }

    public void zamow(int pietro){
        zamowienia.set(pietro, true);
        pietra.get(pietro).ustawSwiatloZlozeniaZamowienia(true);
        liczbaZamowien++;
    }

    public void aktualizujEkrany(){
        for(Pietro p: pietra){
            p.ustawKierunek(kierunek);
            p.ustawPolozenie(pozycja);

        }
    }

    public int zwrocPozycje(){
        return pozycja;
    }

    public boolean czyCzeka(){
        return !drzwi.czyZamkniete();
    }

    public void wykonajRuch(){


        if(zamowienia.get(pozycja)) {
            pietra.get(pozycja).ustawSwiatloZlozeniaZamowienia(false);
            if(drzwi.czyZamkniete()) {
                drzwi.otworz();
                return;
            } else{
                drzwi.zamknij();
            }
            zamowienia.set(pozycja, false);

            liczbaZamowien--;
            if(liczbaZamowien == 0)
                kierunek = Kierunek.DOL;
        }

        if(kierunek == Kierunek.POSTUJ && liczbaZamowien > 0)
            kierunek = Kierunek.GORA;

        if(kierunek == Kierunek.GORA) {
            pozycja++;
            if(pozycja == zamowienia.size() - 1)
                kierunek = Kierunek.DOL;

        } else if(kierunek == Kierunek.DOL) {
            pozycja--;
            if (pozycja <= 0) {
                if (liczbaZamowien > 0)
                    kierunek = Kierunek.GORA;
                else
                    kierunek = Kierunek.POSTUJ;
            }
        }




    }

    public static void main(String[] args){
        System.out.println("Jestem winda");
        Winda winda = new Winda(5);
        winda.wypiszPietra();

        winda.zamow(3);
        for(int i = 0; i < 10; i++) {
            winda.wykonajRuch();
            winda.aktualizujEkrany();
            winda.wypiszPietra();
        }
    }
}
