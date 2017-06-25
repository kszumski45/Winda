import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carl on 25/06/2017.
 */
public class ListaPieter extends JPanel{
    private List<PietroPanel> lista;
    public ListaPieter(List<Pietro> listaPieter) {
        lista = new ArrayList<>();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        for(int i = listaPieter.size() -1; i >= 0; i--) {
            PietroPanel pietroPanel = new PietroPanel(listaPieter.get(i));
            add(pietroPanel);
            lista.add(pietroPanel);

        }
    }
    public void aktualizuj(){
        for(PietroPanel p : lista){
            p.aktualizuj();
        }
    }
}
