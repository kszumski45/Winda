import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by carl on 25/06/2017.
 */
public class WnetrzeWindy extends JFrame {
    public WnetrzeWindy(Winda winda, ListaPieter listaPieter){
        super("W windzie");
        setLayout(new FlowLayout());
        setSize(300,100);
        add(new JLabel("Pietro"));

        Integer[] pietra = new Integer[winda.listaPieter().size()];
        for(int i = 0; i < winda.listaPieter().size(); i++){
            pietra[i] = i;
        }

        JComboBox<Integer> numeryPieter = new JComboBox<>(pietra);

        add(numeryPieter);

        JButton wybierz = new JButton("Wybierz");


        add(wybierz);
        wybierz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                winda.zamow((Integer)numeryPieter.getSelectedItem());
                winda.aktualizujEkrany();
                listaPieter.aktualizuj();
                setVisible(false);

            }
        });
        setVisible(true);
    }
}
