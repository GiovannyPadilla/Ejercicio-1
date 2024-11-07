import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PilaGUI {
    private JTextField textField1;
    private JButton txtIngresar;
    private JButton txtInvertir;
    private JTextArea txtResultado;
    private JPanel PGeneral;

    private Pila pila;

    public PilaGUI() {
        pila = new Pila();

        txtIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(textField1.getText());
                    pila.apilar(numero); // Agregar a la pila
                    txtResultado.setText(pila.mostrarPila()); // Mostrar pila horizontal
                    textField1.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                }
            }
        });

        txtInvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pila.invertir();  // Invierte la pila
                txtResultado.setText(pila.mostrarPila());  // Muestra la pila invertida
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PilaGUI");
        frame.setContentPane(new PilaGUI().PGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
