import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class Button1 implements ActionListener {
    JButton north, west, east, south, center;

    public static void main(String[] args) {
        Button1 button1 = new Button1();
//        button1.go();
        // you can decide to use a method then you invoke it in the main method
        // or decide to use a constructor
    }
    public Button1() {
        JFrame frame = new JFrame();
        north = new JButton("NORTH");
        west = new JButton("WEST");
        east = new JButton("EAST");
        south = new JButton("SOUTH");
        center = new JButton("CENTER");


        Font bigFont = new Font("MV Boli", Font.BOLD, 28);
        frame.getContentPane().add(new BorderLayout().NORTH, north);
        frame.getContentPane().add(new BorderLayout().WEST, west);
        frame.getContentPane().add(new BorderLayout().EAST, east);
        frame.getContentPane().add(new BorderLayout().SOUTH, south);
        frame.getContentPane().add(new BorderLayout().CENTER, center);
//        frame.setUndecorated(true);

        north.setFont(bigFont);
        north.setFocusable(false);
        west.setFocusable(false);
        east.setFocusable(false);
        south.setFocusable(false);
        center.setFocusable(false);
        south.setFont(bigFont);
        north.setForeground(Color.green);
        north.setBackground(Color.gray);
        north.setBorder(BorderFactory.createEtchedBorder());

        south.setForeground(Color.green);
        south.setBackground(Color.gray);
        south.setBorder(BorderFactory.createEtchedBorder());
//        button.addActionListener(e -> System.out.println("Button Clicked!!"));
        north.addActionListener(this);
        west.addActionListener(this);
        east.addActionListener(this);
        south.addActionListener(this);
        center.addActionListener(this);


        frame.setTitle("Border Layout");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == north) {
            System.out.println("North Button Clicked");
//            button.setEnabled(false); // click the button once and its disabled
        }
        else if (e.getSource() == west) {
            System.out.println("West Button Clicked");
        }
        else if (e.getSource() == east) {
            System.out.println("East Button Clicked");
        }
        else if (e.getSource() == south) {
            System.out.println("South Button Clicked");
        }
        else {
            System.out.println("Center Button Clicked");

        }






    }
}
