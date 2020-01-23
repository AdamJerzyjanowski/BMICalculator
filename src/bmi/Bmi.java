
package bmi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.pow;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Bmi extends JFrame {

 public Bmi(){
        inItComponets();
    }  
   public void inItComponets() {
        this.setTitle("Bmi");
        this.setBounds(100, 100, 700,300 );
        this.getContentPane().add(wzrost, BorderLayout.NORTH);
        wzrost.setMajorTickSpacing(15);
        wzrost.setPaintTicks(true);
        wzrost.setMinorTickSpacing(2);
        wzrost.setPaintLabels(true);
        wzrost.setPreferredSize(new Dimension(400,50));
       
        wzrost.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
              wartoscWzrostu.setText("masz:"+((JSlider)ce.getSource()).getValue()+"cm wzrostu");
            }
        });
        this.getContentPane().add(slider, BorderLayout.WEST);
        this.getContentPane().add(wartosci,BorderLayout.EAST);
        this.getContentPane().add(dol, BorderLayout.SOUTH);
        wartoscWzrostu.setEditable(false);
        wartoscWzrostu.setPreferredSize(new Dimension(150,50));
        
        waga.setMajorTickSpacing(15);
        waga.setMinorTickSpacing(1);
        waga.setPaintTicks(true);
        waga.setPaintLabels(true);
        waga.setPreferredSize(new Dimension(400,50));
       
        
        waga.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                wartoscWagi.setText("wazysz: "+((JSlider)ce.getSource()).getValue());
            }
        });
        wartoscWagi.setEditable(false);
        wartoscWagi.setPreferredSize(new Dimension(150,50));
       
       slider.add(waga); 
       slider.add(wzrost);
       slider.setPreferredSize(new Dimension(450,450));
       wartosci.setPreferredSize(new Dimension(250,150));
       wartosci.add(wartoscWagi);
       wartosci.add(wartoscWzrostu);
       dol.add(wynik);
       dol.add(oblicz);
       oblicz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                double wynikBMI=(waga.getValue()/pow((((double)wzrost.getValue())/100),2));
                wynik.setText("Twoje BMI to: "+(waga.getValue()/pow((((double)wzrost.getValue())/100),2)));
                 if (18.5<=wynikBMI && wynikBMI<=24.9){
               dol.setBackground(Color.GREEN);
                 }
                 else if( 24.9<wynikBMI ){
               dol.setBackground(Color.RED);
            } 
                 else if(18.5>=wynikBMI){
                       dol.setBackground(Color.YELLOW);
                 }
                 else {
                }
            }
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    JPanel slider = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel wartosci = new JPanel(new FlowLayout(FlowLayout.TRAILING));
    JPanel dol = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JSlider wzrost = new JSlider(JSlider.HORIZONTAL,0,250,150);
    JSlider waga = new JSlider(JSlider.HORIZONTAL,0,150,100);
    JTextField wartoscWagi = new JTextField("wazysz: "+ waga.getValue());
    JTextField wartoscWzrostu = new JTextField("masz "+wzrost.getValue()+" cm wzrostu");
    JButton oblicz = new JButton("Oblicz BMI");
    JLabel wynik = new JLabel();
    public static void main(String[] args)  {
       new Bmi().setVisible(true);
    }

 
}
