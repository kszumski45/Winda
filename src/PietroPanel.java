import javax.swing.*;
import java.awt.*;

/**
 * Created by carl on 25/06/2017.
 */
public class PietroPanel extends JPanel {

    private Pietro pietro;
    private JCheckBox pozycja;
    public PietroPanel(Pietro pietro){
        this.pietro = pietro;
        pozycja = new JCheckBox();
        pozycja.setSelected(pietro.zwrocSwiatloZlozeniaZamowienia());
        add(new Label("Pietro " + pietro.zwrocNumerPietra()));
        add(pozycja);
    }
    public void aktualizuj(){
        pozycja.setSelected(pietro.zwrocSwiatloZlozeniaZamowienia());
    }
}
