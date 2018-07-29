package spc_conv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Konwerter kodów punktów sygnalizacyjnych.
 * 
 * Wersja Swing
 * @author Damian Duda &lt; damian.duda@gmail.com
 */
public class Aplikacja extends JFrame implements ActionListener {

    JButton buttonPrzeliczDec;
    JButton buttonPrzeliczItu;
    JButton buttonTest;
    JTextField textFieldInput;
    JLabel labelOutITU;
    JLabel labelOutANSI;
    
    JLabel labelITU;
    
    public Aplikacja(){
        super("Konwerter SPC");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,250);
        setLayout(null);
        
        buttonPrzeliczDec = new JButton("ITU-T/ANSI");
        this.add(buttonPrzeliczDec);
        buttonPrzeliczDec.addActionListener(this);
        buttonPrzeliczDec.setActionCommand("cmdDecCnt");
        buttonPrzeliczDec.setBounds(195, 90, 90, 25);
        
        buttonPrzeliczItu = new JButton("Dec");
        this.add(buttonPrzeliczItu);
        buttonPrzeliczItu.addActionListener(this);
        buttonPrzeliczItu.setActionCommand("cmdItuCount");
        buttonPrzeliczItu.setBounds(195, 30, 90, 25);
        
        // Testowy button
        buttonTest = new JButton("Testuj");
        this.add(buttonTest);
        buttonTest.addActionListener(this);
        buttonTest.setActionCommand("cmdTestuj");
        buttonTest.setBounds(195, 60, 90, 25);
        
        
        textFieldInput = new JTextField();
        textFieldInput.setBounds(25, 90, 150, 25);
        this.add(textFieldInput);
        
        labelOutITU = new JLabel("ITU-T SPC:");
        labelOutITU.setBounds(25, 20, 150, 20);
        this.add(labelOutITU);
        
        labelOutANSI = new JLabel("ANSI SPC:");
        labelOutANSI.setBounds(25, 50, 150, 20);
        this.add(labelOutANSI);
        
        labelITU = new JLabel("SPC Dec:");
        labelITU.setBounds(25, 70, 100, 20);
        this.add(labelITU);
        
        setVisible(true);
        
    }
    /**
     * Konwerter kodów punktów sygnalizacyjnych.
     * 
     * Wersja Swing
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable(){
        
            @Override
            public void run(){
              new Aplikacja();
            }
        });
    }

    /**
     * Tu jest wywoływane przeliczanie
     * @param e Zdarzenie przekazane przez system
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Scanner sc;
        String actionSelected = e.getActionCommand();

        Convert przelicznik = new Convert();
        
        if (actionSelected.equals("cmdDecCnt")){
                  
                  
                  //TODO Obsługa błędów
                  
                  //String SPCode = textFieldInput.getText();
                  sc = new Scanner(textFieldInput.getText());
        
                  if(!sc.hasNextInt()){
                      JOptionPane.showMessageDialog(this, "Wprowadź kod dziesiętny", "Błąd", JOptionPane.INFORMATION_MESSAGE);
                      return;
                  }
                  int NPCode = sc.nextInt();
                  
            labelOutITU.setText("ITU-T SPC: " + przelicznik.toITU(NPCode));
            labelOutANSI.setText("ANSI SPC: " + przelicznik.toANSI(NPCode));
 
        }
        else if (actionSelected.equals("cmdItuCount")){
            sc = new Scanner(textFieldInput.getText());
            
            if(!sc.hasNext()) {
                JOptionPane.showMessageDialog(this, "Wprowadź wartość", "Błąd", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String SPC = sc.next();
            
            int NPC = przelicznik.ItuToDec(SPC);
            
            if (NPC== -1) {
                JOptionPane.showMessageDialog(this, "Wprowadź poprawny kod 3-8-3 ITU-T.", "Błąd", JOptionPane.WARNING_MESSAGE);
                return;
            }
            System.out.println("NPC: " + NPC);
        }
        
        
        // TEST
        else if (actionSelected.equals("cmdTestuj")){
            
            itu_conv testInstance = new itu_conv();
            //FIXME
            Integer restest = 0;
            boolean test = testInstance.is_valid_383("0-0-0", restest);
        }
        
    }
    
}
