package AdvancedConcepts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Server extends JFrame implements ActionListener {
    ObjectOutputStream serverObjectStreamWriter;
    ObjectInputStream serverObjectStreamReader;
    ServerSocket serverSock;
    Socket clientSock;
    SerializableClass serialObj;



    JPanel panel;
    JLabel nameLabel, emailLabel, genderLabel;
    JTextField textFieldName, textFieldEmail, textFieldGender;
    JButton buttonSend, buttonSave;

    public Server() {
        
        this.setTitle("Server");
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
        buttonSave = new JButton("Save");
        buttonSave.setFocusable(false);
        buttonSave.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
        buttonSave.addActionListener(this);
        panel.add(nameLabel);
        panel.add(textFieldName);
        panel.add(emailLabel);
        panel.add(textFieldEmail);
        panel.add(genderLabel);
        panel.add(textFieldGender);
        panel.add(buttonSend);
        panel.add(buttonSave);



        this.add(panel);
        this.setVisible(true);


    }


    public void go() {
        try {
            serverSock = new ServerSocket(50000);
            serialObj = new SerializableClass();
            clientSock = serverSock.accept();

            serverObjectStreamReader = new ObjectInputStream(clientSock.getInputStream());
            serverObjectStreamWriter = new ObjectOutputStream(clientSock.getOutputStream());

            // create a Thread
            Thread t = new Thread(new ServerRunnable());
            t.start();
            System.out.println("Got a connection");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public class ServerRunnable implements Runnable {

        @Override
        public void run() {
            try {
                while ((serialObj = (SerializableClass) serverObjectStreamReader.readObject()) != null) {
                    textFieldName.setText(serialObj.name);
                    textFieldEmail.setText(serialObj.email);
                    textFieldGender.setText(serialObj.gender);
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
            serialObj.myFile = new File("C:\\Users\\user\\IdeaProjects\\PrepareOOP\\src\\AdvancedConcepts\\myfile.txt");
            try {
                serverObjectStreamWriter.writeObject(serialObj);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        if (e.getSource() == buttonSave) {
            String name = textFieldName.getText();
            String email = textFieldEmail.getText();
            String gender = textFieldGender.getText();
            if (name.equals("") || email.equals("") || gender.equals("")) {
                JOptionPane.showMessageDialog(this, "Please fill in all the fields");
            } else {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcs", "root", "ernestine18");
                    PreparedStatement pst = connection.prepareStatement("INSERT INTO student (name, email, gender) VALUES (?, ?, ?)");
                    pst.setString(1, name);
                    pst.setString(2, email);
                    pst.setString(3, gender);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Student Saved Successfully");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }

            }

        }

    }

}

class ServerMain {
    public static void main(String[] args) {
        Server server = new Server();
        server.setVisible(true);
        server.setLocationRelativeTo(null);
        server.go();

    }
}
