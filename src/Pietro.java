/**
 * Created by carl on 25/06/2017.
 */
public class Pietro {
    private int ekranPolozenia;
    private Kierunek ekranKierunkuJazdy;
    private int numerPietra;
    private boolean swiatloZlozeniaZamowienie;

    public Pietro(int numerPietra) {
        this.numerPietra = numerPietra;
        ekranPolozenia = 0;
        ekranKierunkuJazdy = Kierunek.POSTUJ;
        swiatloZlozeniaZamowienie = false;
    }

    public void ustawPolozenie(int polozenie){
        ekranPolozenia = polozenie;
    }
    public int zwrocPolozenie(){
        return ekranPolozenia;
    }

    public void ustawKierunek(Kierunek kierunek){
        ekranKierunkuJazdy = kierunek;
    }
    public Kierunek zwrocKierunek(){
        return ekranKierunkuJazdy;
    }

    public void ustawSwiatloZlozeniaZamowienia(boolean swiatlo) {
        swiatloZlozeniaZamowienie = swiatlo;
    }
    public boolean zwrocSwiatloZlozeniaZamowienia(){
        return swiatloZlozeniaZamowienie;
    }
    public int zwrocNumerPietra(){
        return numerPietra;
    }
    public void wypisz(){
        System.out.println("Pietro: " + numerPietra + "; Pozycja Windy: " + ekranPolozenia + "; Kierunek Jazdy: " + ekranKierunkuJazdy + "; Zamowiono: " + swiatloZlozeniaZamowienie);
    }
}
