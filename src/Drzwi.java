/**
 * Created by carl on 25/06/2017.
 */
public class Drzwi {
    private boolean zamkniete;

    public Drzwi(){
        zamkniete = true;
    }
    public void otworz(){
        zamkniete = false;
    }
    public void zamknij(){
        zamkniete = true;
    }
    public boolean czyZamkniete(){
        return zamkniete;
    }
}
