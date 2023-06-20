package hust.soict.cybersec.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    private class TFListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(String.valueOf(sum));
        }
    }
    public SwingAccumulator(){
        Container cp = getContentPane();

        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an integer:"));

        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFListener());

        cp.add(new JLabel("Accumulated sum:"));

        tfOutput = new JTextField(10);   

        cp.add(tfOutput);
        tfOutput.setEditable(false);

        setVisible(true);
        setSize(400,200);
        setTitle("Swing accumulator");
    }
    public static void main(String[] args){
        new SwingAccumulator();
    }
}