import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMIcalculator {
    public static void main(String[] args) {
        // create components
        JLabel heightLabel = new JLabel("Height (m):");
        JTextField heightField = new JTextField(10);
        JLabel weightLabel = new JLabel("Weight (kg):");
        JTextField weightField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel();

        // create panel and add components
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0; c.gridy = 0; panel.add(heightLabel, c);
        c.gridx = 1; panel.add(heightField, c);
        c.gridx = 0; c.gridy = 1; panel.add(weightLabel, c);
        c.gridx = 1; panel.add(weightField, c);
        c.gridx = 0; c.gridy = 2; c.gridwidth = 2; panel.add(calculateButton, c);
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2; panel.add(resultLabel, c);

        // create frame and add panel
        JFrame frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // handle calculate button click
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double height = Double.parseDouble(heightField.getText());
                    double weight = Double.parseDouble(weightField.getText());
                    double bmi = weight / (height * height);
                    String result = String.format("Your BMI is %.1f (%s)", bmi, getBMIStatus(bmi));
                    resultLabel.setText(result);
                    resultLabel.setForeground(getBMIColor(bmi));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input, please enter a number.");
                }
            }
        });
    }

    // helper method to get BMI status based on BMI value
    private static String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // helper method to get color based on BMI value
    private static Color getBMIColor(double bmi) {
        if (bmi < 18.5) {
            return Color.BLUE;
        } else if (bmi < 25) {
            return Color.GREEN;
        } else if (bmi < 30) {
            return Color.ORANGE;
        } else {
            return Color.RED;
        }
    }
}

