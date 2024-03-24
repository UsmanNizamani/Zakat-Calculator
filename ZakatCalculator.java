import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class ZakatCalculator {
    public JFrame frame;
    public JFrame secondFrame;
    public JTextField textField;
    public JTextField gold_field;
    public JTextField Silver_field;
    public JComboBox<String> box;
    public JButton button;
    public JButton Enter;
    public JPanel panel;
    public JLabel instruction_label;
    public JLabel label;
    public JLabel label1;
    public JLabel label2;
    public JLabel label3;
    public JLabel label4;
    public JLabel gold_label;
    public JLabel silver_label;
    public JLabel resultLabel;
    public JLabel intro;
    public static double value = 1;
    public static double nisab;
    public static double gold_rate;
    public static double silver_rate;

    public ZakatCalculator() {

        // First Winows

        frame = new JFrame("Zakat Calculator");
        frame.setSize(250, 400);
        frame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("icon.png");
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
        frame.setLayout(null);

        // Adding the icon

        ImageIcon backgroundImage = new ImageIcon("bgimage.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        frame.setContentPane(backgroundLabel);
        frame.setVisible(true);

        // Initialize panel

        panel = new JPanel();
        frame.add(panel);

        // x coordinate for labels, button combobox

        int x = 45;

        // textfield for silver rate

        Silver_field = new JFormattedTextField();
        Silver_field.setBounds(x, 160, 150, 25);
        Silver_field.setEditable(true);
        Silver_field.setVisible(true);
        frame.add(Silver_field);
        Silver_field.setText("0");

        // Creating Second Frame

        secondFrame = new JFrame("Zakat Calculator");
        secondFrame.setSize(250, 400);
        secondFrame.setLayout(null);
        secondFrame.setLocationRelativeTo(null);
        ImageIcon icon1 = new ImageIcon("icon.png");
        secondFrame.setIconImage(icon1.getImage());
        ImageIcon backgroundImage1 = new ImageIcon("bgimage.jpg");
        JLabel backgroundLabel1 = new JLabel(backgroundImage1);
        secondFrame.setContentPane(backgroundLabel1);
        secondFrame.setVisible(false);
        secondFrame.setIconImage(icon.getImage());
        secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TextField for value input

        textField = new JFormattedTextField();
        textField.setBounds(x, 240, 150, 25);
        textField.setEditable(true);
        secondFrame.add(textField);
        textField.setText("0");

        // textfiled for gold rate

        gold_field = new JFormattedTextField();
        gold_field.setBounds(x, 140, 150, 25);
        gold_field.setEditable(true);
        secondFrame.add(gold_field);
        gold_field.setVisible(false);
        gold_field.setText("0");

        // ComboBox

        String[] list = { " ", "Gold", "Silver", "Cash", "Business Goods" };
        box = new JComboBox<String>(list);
        box.setBounds(x, 80, 150, 25);
        secondFrame.add(box);

        // Button

        button = new JButton("Calculate Zakat");
        button.setBounds(x, 280, 150, 25);
        secondFrame.add(button);

        Enter = new JButton("Enter");
        Font enterfont = new Font("Times new roman", Font.BOLD, 10);
        Enter.setFont(enterfont);
        Enter.setBounds(x, 200, 150, 25);
        frame.add(Enter);

        // fonts

        Font font = new Font("Times new roman", Font.BOLD, 13);
        Font heading = new Font("Times new roman", Font.BOLD, 17);

        // labels

        // instruction Label

        instruction_label = new JLabel();
        instruction_label.setText(
                "<html>Nisab is caluclated<br>&nbsp;&nbsp;&nbsp;&nbsp;by Silver rate<br>Please Enter Silver<br> &nbsp;&nbsp;&nbsp;&nbsp;Current rate</html>");
        instruction_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
        instruction_label.setBounds(x, 50, 200, 90);
        instruction_label.setForeground(Color.white);
        instruction_label.setVisible(true);
        frame.add(instruction_label);

        // label for GOLD

        label = new JLabel();
        label.setText("Enter the grams of Gold:");
        label.setFont(font);
        label.setBounds(x, 130, 200, 200);
        label.setForeground(Color.white);
        secondFrame.add(label);
        label.setVisible(true);

        // label for Silver

        label1 = new JLabel();
        label1.setText("Enter the grams of Silver:");
        label1.setBounds(x, 130, 200, 200);
        label1.setFont(font);
        label1.setForeground(Color.white);
        secondFrame.add(label1);
        label1.setVisible(false);

        // label for Cash

        label2 = new JLabel();
        label2.setText("Enter The cash amount:");
        label2.setBounds(x, 130, 200, 200);
        label2.setFont(font);
        label2.setForeground(Color.white);
        secondFrame.add(label2);
        label2.setVisible(false);

        // label for Business Good

        label3 = new JLabel();
        label3.setText("Enter the value of Goods:");
        label3.setBounds(x, 130, 200, 200);
        label3.setFont(font);
        label3.setForeground(Color.white);
        secondFrame.add(label3);
        label3.setVisible(false);

        label4 = new JLabel();
        label4.setText("Select type of wealth");
        label4.setFont(heading);
        label4.setBounds(x, 30, 200, 60);
        label4.setVisible(true);
        label4.setForeground(Color.white);
        secondFrame.add(label4);

        // Label for gold rate

        gold_label = new JLabel();
        gold_label.setText("Gold rate per gram in PKR");
        gold_label.setFont(font);
        gold_label.setBounds(x, 100, 200, 60);
        gold_label.setVisible(false);
        gold_label.setForeground(Color.white);
        secondFrame.add(gold_label);

        // Label for Silver rate

        silver_label = new JLabel();
        silver_label.setText("Silver rate per gram in PKR");
        silver_label.setFont(font);
        silver_label.setBounds(x, 115, 200, 60);
        silver_label.setVisible(true);
        silver_label.setForeground(Color.white);
        frame.add(silver_label);

        // Result label shows the due zakat

        resultLabel = new JLabel();
        resultLabel.setBounds(x, 310, 200, 25);
        resultLabel.setForeground(Color.white);
        secondFrame.add(resultLabel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        box.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) box.getSelectedItem();
                if (selectedOption.equals("Gold")) {
                    label.setVisible(true);
                    label1.setVisible(false);
                    label2.setVisible(false);
                    label3.setVisible(false);
                    gold_label.setVisible(true);
                    gold_field.setVisible(true);

                } else if (selectedOption.equals("Silver")) {
                    label.setVisible(false);
                    label2.setVisible(false);
                    label3.setVisible(false);
                    label1.setVisible(true);
                    gold_label.setVisible(false);
                    gold_field.setVisible(false);

                } else if (selectedOption.equals("Cash")) {
                    label.setVisible(false);
                    label2.setVisible(true);
                    label3.setVisible(false);
                    label1.setVisible(false);
                    gold_label.setVisible(false);
                    gold_field.setVisible(false);

                } else if (selectedOption.equals("Business Goods")) {
                    label.setVisible(false);
                    label2.setVisible(false);
                    label3.setVisible(true);
                    label1.setVisible(false);
                    gold_label.setVisible(false);
                    gold_field.setVisible(false);

                } else {
                    label.setVisible(false);
                    label1.setVisible(false);
                    label2.setVisible(false);
                    label3.setVisible(false);
                }
            }
        });

        Enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text2 = Silver_field.getText();
                silver_rate = Double.parseDouble(text2);
                nisab = silver_rate * (612.36);
                frame.setVisible(false);
                secondFrame.setVisible(true);
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) box.getSelectedItem();
                String text = textField.getText();
                String text1 = gold_field.getText();

                value = Double.parseDouble(text);
                gold_rate = Double.parseDouble(text1);

                if (selectedOption.equals("Gold")) {
                    value = value * gold_rate;
                    nisab = gold_rate * 87.48;
                } else if (selectedOption.equals("Silver")) {
                    value = value * silver_rate;
                }
                double zakat = value * 0.025;

                if (value >= nisab) {
                    resultLabel.setText("Your zakat is: " + String.format("%.2f", zakat));
                } else if (value < nisab) {
                    resultLabel.setText("Zakat is not due");
                } else {
                    resultLabel.setText("Invalid input");
                }
                textField.setText("0");
            }
        });
        frame.validate();
        frame.repaint();
        secondFrame.validate();
        secondFrame.repaint();
    }

    public static void main(String[] args) {
        ZakatCalculator zak = new ZakatCalculator();
    }
}
