import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

/**
 * Created by carl on 25/06/2017.
 */
public class OknoGlowne extends JFrame{
    private Winda winda;
    private ListaPieter listaPieter;
    private JLabel pozycja;
    public OknoGlowne(){
        super("Winda");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new FlowLayout());

        winda = new Winda(8);
        listaPieter = new ListaPieter(winda.listaPieter());
        add(listaPieter);


        JButton zamow = new JButton("Zamow");
        JButton wykonajRuch = new JButton("Wykonaj ruch");
        add(zamow);
        add(wykonajRuch);
        pozycja = new JLabel(Integer.toString(winda.zwrocPozycje()));
        add(new JLabel("Pozycja: "));
        add(pozycja);
        setVisible(true);

        zamow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ZamowWinde(winda, listaPieter);
                winda.aktualizujEkrany();
                listaPieter.aktualizuj();
            }
        });
        wykonajRuch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                winda.wykonajRuch();
                winda.wypiszPietra();
                winda.aktualizujEkrany();
                listaPieter.aktualizuj();
                pozycja.setText(Integer.toString(winda.zwrocPozycje()));

               // if(winda.czyCzeka())
                    //new WnetrzeWindy(winda, listaPieter);
            }
        });


    }

    public void wykonajRuch(){
        winda.wykonajRuch();
        winda.wypiszPietra();
        winda.aktualizujEkrany();
        listaPieter.aktualizuj();
        pozycja.setText(Integer.toString(winda.zwrocPozycje()));
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                OknoGlowne oknoGlowne = new OknoGlowne();
            }
        });
    }
}
