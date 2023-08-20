package AdvancedConcepts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends JFrame implements ActionListener {
    ObjectOutputStream clientObjectStreamWriter;
    ObjectInputStream clientObjectStreamReader;
    Socket sock;
    SerializableClass serialObj;

    JPanel panel;
    JLabel nameLabel, emailLabel, genderLabel;
    JTextField textFieldName, textFieldEmail, textFieldGender;
    JButton buttonSend, buttonClear;
    public Client() {

        this.setTitle("Client");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setLayout(null);


        panel = new JPanel();
        panel.setBounds(100, 100, 250, 250);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setPreferredSize(new Dimension(250, 250));
        panel.setBackground(Color.lightGray);
        nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Sans Comic", Font.PLAIN, 20));
        textFieldName = new JTextField(20);
        textFieldName.setFont(new Font("Sans Comic", Font.PLAIN, 13));
        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Sans Comic", Font.PLAIN, 20));
        textFieldEmail = new JTextField(20);
        textFieldEmail.setFont(new Font("Sans Comic", Font.PLAIN, 13));
        genderLabel = new JLabel("Gender");
        genderLabel.setFont(new Font("Sans Comic", Font.PLAIN, 20));
        textFieldGender = new JTextField(20);
        textFieldGender.setFont(new Font("Sans Comic", Font.PLAIN, 13));

        buttonSend = new JButton("Send");
        buttonSend.setFocusable(false);
        buttonSend.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
        buttonSend.addActionListener(this);
        buttonClear = new JButton("Clear");
        buttonClear.setFocusable(false);
        buttonClear.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
        buttonClear.addActionListener(this);

        panel.add(nameLabel);
        panel.add(textFieldName);
        panel.add(emailLabel);
        panel.add(textFieldEmail);
        panel.add(genderLabel);
        panel.add(textFieldGender);
        panel.add(buttonSend);
        panel.add(buttonClear);




        this.add(panel);
        this.setVisible(true);
    }
    public void go() {
        try {
            sock = new Socket("127.0.0.1", 50000);
            serialObj = new SerializableClass();

            clientObjectStreamWriter = new ObjectOutputStream(sock.getOutputStream());
            clientObjectStreamReader = new ObjectInputStream(sock.getInputStream());

            System.out.println("Networking Established");

            // create a Thread
            Thread t = new Thread(new ClientRunnable());
            t.start();
            System.out.println("Got a connection");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public class ClientRunnable implements Runnable {

        @Override
        public void run() {
            try {
                while ((serialObj = (SerializableClass) clientObjectStreamReader.readObject()) != null) {
                    textFieldName.setText(serialObj.name);
                    textFieldEmail.setText(serialObj.email);
                    textFieldGender.setText(serialObj.gender);
                    if (Desktop.isDesktopSupported()) {
                        try {
                            File myFile = serialObj.myFile;
                            Desktop.getDesktop().open(myFile);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    go();

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSend) {
            serialObj.name = textFieldName.getText();
            serialObj.email = textFieldEmail.getText();
            serialObj.gender = textFieldGender.getText();
            try {
                clientObjectStreamWriter.writeObject(serialObj);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        if (e.getSource() == buttonClear) {
            textFieldName.setText("");
            textFieldEmail.setText("");
            textFieldGender.setText("");
            textFieldName.requestFocus();
        }
    }
}
class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        client.setVisible(true);
        client.setLocationRelativeTo(null);
        client.go();

    }
}

