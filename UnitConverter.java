import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UnitConverter extends JFrame implements ActionListener {

    JTextField inputField;
    JLabel resultLabel;
    JComboBox<String> conversionBox;
    JButton convertButton;

    public UnitConverter() {

        setTitle("Unit Converter");
        setSize(400,250);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel inputLabel = new JLabel("Enter Value:");
        inputField = new JTextField(10);

        String[] conversions = {
                "Km to Meter",
                "Meter to Cm",
                "Kg to Gram",
                "Gram to Kg",
                "Celsius to Fahrenheit",
                "Fahrenheit to Celsius"
        };

        conversionBox = new JComboBox<>(conversions);

        convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ");

        add(inputLabel);
        add(inputField);
        add(conversionBox);
        add(convertButton);
        add(resultLabel);

        convertButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        double value = Double.parseDouble(inputField.getText());
        String conversion = (String) conversionBox.getSelectedItem();
        double result = 0;

        if(conversion.equals("Km to Meter"))
            result = value * 1000;

        else if(conversion.equals("Meter to Cm"))
            result = value * 100;

        else if(conversion.equals("Kg to Gram"))
            result = value * 1000;

        else if(conversion.equals("Gram to Kg"))
            result = value / 1000;

        else if(conversion.equals("Celsius to Fahrenheit"))
            result = (value * 9/5) + 32;

        else if(conversion.equals("Fahrenheit to Celsius"))
            result = (value - 32) * 5/9;

        resultLabel.setText("Result: " + result);
    }

    public static void main(String[] args) {
        new UnitConverter().setVisible(true);
    }
}