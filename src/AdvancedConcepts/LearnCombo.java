package AdvancedConcepts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LearnCombo implements ActionListener {
    JFrame frame;
    JComboBox comboBox;
    JMenuItem undoMenu, redoMenu, cutMenu, copyMenu;
    JPopupMenu popupMenu;
    public LearnCombo() {
        frame = new JFrame();
        frame.setTitle("Combo Box");
        frame.setLayout(new FlowLayout());
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(3);
        String [] animals = {"cat", "dog", "cow"};
        comboBox = new JComboBox(animals);
        comboBox.addActionListener(this);
        comboBox.setEditable(true);
        System.out.println(comboBox.getItemCount());
        comboBox.addItem("bird");
        comboBox.insertItemAt("monkey", 0);
        comboBox.setSelectedIndex(0);
        //comboBox.removeItem("monkey");
        comboBox.removeItemAt(2);


        frame.add(comboBox);
        frame.setVisible(true);

        undoMenu = new JMenuItem("Undo");
        redoMenu = new JMenuItem("Redo");
        cutMenu = new JMenuItem("Cut");
        copyMenu = new JMenuItem("Copy");

        undoMenu.addActionListener(this);

        popupMenu = new JPopupMenu();
        popupMenu.add(undoMenu);
        popupMenu.add(redoMenu);
        popupMenu.add(cutMenu);
        popupMenu.add(copyMenu);

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(frame, e.getX(), e.getY());
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            System.out.println(comboBox.getSelectedItem());
        }
        if (e.getSource() == undoMenu) {
            System.out.println("Undo Menu item clicked!!");
        }

    }


}
