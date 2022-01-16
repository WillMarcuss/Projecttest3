/*
William Marcus
January 13th 2022
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Converter {
    public static void main(String[] args){
        JFrame win = new JFrame();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setBounds(600,300,350,450);
        win.getContentPane().setBackground(Color.lightGray);
        win.setLayout(null);

        JTextField Degree = new JTextField("Enter Temp");
        Degree.setBounds(25, 100, 100, 20);
        Degree.setBackground(Color.gray);
        win.add(Degree);

        JTextField Fahrenheit = new JTextField();
        Fahrenheit.setBounds(225, 100, 100, 20);
        Fahrenheit.setBackground(Color.gray);
        Fahrenheit.setEditable(false);
        win.add(Fahrenheit);

        JComboBox WhichUnit = new JComboBox();
        WhichUnit.setBounds(75,300,200,100);
        WhichUnit.addItem("Convert Celsius to Fahrenheit");
        WhichUnit.addItem("Convert Fahrenheit to Celsius");
        WhichUnit.addItem("Convert Celsius to Kelvin");
        WhichUnit.addItem("Convert Kelvin to Celsius");
        WhichUnit.addItem("Convert Fahrenheit to Kelvin");
        WhichUnit.addItem("Convert Kelvin to Fahrenheit");
        win.add(WhichUnit);

        Font myFont = new Font("Courier", Font.BOLD,20);

        JLabel cel = new JLabel("°C");
        cel.setBounds(325,95,25,25);
        cel.setFont(myFont);
        cel.setVisible(false);
        win.add(cel);

        JLabel fah = new JLabel("°F");
        fah.setBounds(325,95,25,25);
        fah.setFont(myFont);
        fah.setVisible(false);
        win.add(fah);

        JLabel K = new JLabel("K");
        K.setBounds(325,95,25,25);
        K.setFont(myFont);
        K.setVisible(false);
        win.add(K);

        JButton convert = new JButton("Convert");
        convert.setBounds(135,100,80,20);
        convert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Degvalue = Degree.getText();
                try {
                    if (WhichUnit.getSelectedItem().equals("Convert Celsius to Fahrenheit")) {
                        double deg = Double.parseDouble(Degvalue);
                        deg = (deg * 1.8) + 32;
                        Fahrenheit.setText("" + deg);
                        fah.setVisible((true));
                        cel.setVisible(false);
                        K.setVisible(false);
                    } else if (WhichUnit.getSelectedItem().equals("Convert Fahrenheit to Celsius")) {
                        double far = Double.parseDouble(Degvalue);
                        far = (far - 32) * 0.55555556;
                        far = Math.round(far * 100);
                        far = far / 100;
                        Fahrenheit.setText("" + far);
                        cel.setVisible((true));
                        fah.setVisible(false);
                        K.setVisible(false);
                    } else if (WhichUnit.getSelectedItem().equals("Convert Celsius to Kelvin")) {
                        double kel = Double.parseDouble(Degvalue);
                        kel += 273.15;
                        kel= Math.round(kel * 100);
                        kel = kel/100;
                        Fahrenheit.setText(""+kel);
                        cel.setVisible((false));
                        fah.setVisible(false);
                        K.setVisible(true);
                    } else if (WhichUnit.getSelectedItem().equals("Convert Kelvin to Celsius")) {
                        double deg2 = Double.parseDouble(Degvalue);
                        deg2 -= 273.15;
                        deg2 = Math.round(deg2 * 100);
                        deg2= deg2/100;
                        Fahrenheit.setText(""+deg2);
                        cel.setVisible((true));
                        fah.setVisible(false);
                        K.setVisible(false);
                    } else if (WhichUnit.getSelectedItem().equals("Convert Fahrenheit to Kelvin")) {
                        double kel2 = Double.parseDouble(Degvalue);
                        kel2 = (kel2 - 32) * 0.55555556;
                        kel2+= 273.15;
                        kel2 = Math.round(kel2 * 100);
                        kel2 = kel2/100;
                        Fahrenheit.setText(""+kel2);
                        cel.setVisible((false));
                        fah.setVisible(false);
                        K.setVisible(true);
                    } else if (WhichUnit.getSelectedItem().equals("Convert Kelvin to Fahrenheit")) {
                        double fah2 = Double.parseDouble(Degvalue);
                        fah2 = ((fah2 - 273.15) * 1.8) + 32;
                        fah2 = Math.round(fah2 * 100);
                        fah2 = fah2 / 100;

                        Fahrenheit.setText("" + fah2);
                        cel.setVisible((false));
                        fah.setVisible(true);
                        K.setVisible(false);
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Please only enter valid temperatures!");
                }


            }
        });
        win.add(convert);
        win.setVisible(true);
    }
}

