import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class myButton extends JFrame implements ActionListener {
    // instance variables
    int counterOne, counterTwo;

    // panel one with its components
    JLabel lblone = new JLabel("Click 1");
    JTextField txtone = new JTextField(10);
    JPanel pOne = new JPanel();


    // panel two with its components

    JLabel lbltwo = new JLabel("Click 2");
    JTextField txttwo = new JTextField(10);
    JPanel pTwo = new JPanel();

    // panel three with its components
    JLabel lblThree = new JLabel("For output click + ");
    JTextField txtthree = new JTextField(30);
    JPanel pThree = new JPanel();

    JPanel pData = new JPanel();

    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton plus = new JButton("+");
    JPanel pButtons = new JPanel();

    String data;
    // constructor
    public myButton() {
        setTitle("this is very nice");
        counterOne = counterTwo = 0;

        pOne.add(lblone);
        pOne.add(txtone);


        pTwo.add(lbltwo);
        pTwo.add(txttwo);

        pThree.add(lblThree);
        pThree.add(txtthree);

        txtthree.setEditable(false);

        pData.setLayout(new BoxLayout(pData, BoxLayout.Y_AXIS));
        pData.add(pOne);
        pData.add(pTwo);
        pData.add(pThree);

        pButtons.add(one);
        pButtons.add(two);
        pButtons.add(plus);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


        getContentPane().add(pData);
        getContentPane().add(pButtons);


        one.addActionListener(this);
        two.addActionListener(this);
        plus.addActionListener(this);



    }

    public static void main(String[] args) {
        myButton t = new myButton();
        t.setResizable(false);
        t.setSize(600, 600);
        t.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClicked;
        buttonClicked = e.getActionCommand();
        if (buttonClicked.equals("1")) {
            data = txtone.getText();
            txtone.setText(data + "button clicked");
            counterOne = counterOne + 1;

        }

        if (buttonClicked.equals("2")) {
            data = txttwo.getText();
            txttwo.setText(data + "button clicked");
            counterTwo = counterTwo + 1;
//            JOptionPane.showMessageDialog(null, "This is how we do it!!");

        }

        if (buttonClicked.equals("+")) {
            txtthree.setText("One was clicked  " + counterOne + " times");
            txtthree.setText(txtthree.getText() + ", Two was clicked " + counterOne + counterTwo +" times ");
        }

    }
}
