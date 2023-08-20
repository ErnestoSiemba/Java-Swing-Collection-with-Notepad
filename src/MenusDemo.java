
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MenusDemo implements ActionListener{
    // declare instance variables
    JFrame frame;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, formatMenu, viewMenu, helpMenu, zoom ;
    JMenuItem newFile, newWindow, openFile, saveFile, saveAsFile, pageSetUpFile, printFile, exitFile;
    JMenuItem undo, redo, cut, copy, paste, delete, find, findNext, findPrevious, replace, goTo, selectAll, timeDate;
    JMenuItem wordWrap, font, viewHelp, sendFeedback, aboutNotify;
    JMenuItem zoomIn, zoomOut, defaultZoom;
    JCheckBoxMenuItem statusBar;
    JTextPane textPane;
    JScrollPane scrollPane;
    JSeparator lineSeperator1, lineSeperator2, undoSeperator, deleteSeperator, goToSeperator;
    boolean isTextSelected;
    UndoManager manager;
    JPopupMenu popupMenu;




    // constructor

    public MenusDemo() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Notify");
        frame.setLocationRelativeTo(null);






        lineSeperator1 = new JSeparator();
        lineSeperator1.setPreferredSize(new Dimension(100, 10));
        lineSeperator1.setForeground(Color.lightGray);

        lineSeperator2 = new JSeparator();
        lineSeperator2.setPreferredSize(new Dimension(100, 10));
        lineSeperator2.setForeground(Color.lightGray);

        undoSeperator = new JSeparator();
        undoSeperator.setPreferredSize(new Dimension(100, 10));
        undoSeperator.setForeground(Color.lightGray);

        deleteSeperator = new JSeparator();
        deleteSeperator.setPreferredSize(new Dimension(100, 10));
        deleteSeperator.setForeground(Color.lightGray);

        goToSeperator = new JSeparator();
        goToSeperator.setPreferredSize(new Dimension(100, 10));
        goToSeperator.setForeground(Color.lightGray);

        // make objects of the Menus
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        formatMenu = new JMenu("Format");
        viewMenu = new JMenu("View");
        helpMenu = new JMenu("Help");
        zoom = new JMenu("Zoom");

        // Text Area
        textPane = new JTextPane();
        textPane.setEditable(true);
        textPane.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        textPane.setAutoscrolls(true);



        manager = new UndoManager();
        textPane.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                manager.addEdit(e.getEdit());
            }
        });

        isTextSelected = textPane.getSelectedText() != null;



        // Add menus to the menuBar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        // file menu
        newFile = new JMenuItem("New");
        newWindow = new JMenuItem("New Window");
        openFile = new JMenuItem("Open File...");
        saveFile = new JMenuItem("Save File");
        saveAsFile = new JMenuItem("Save As...");
        pageSetUpFile = new JMenuItem("Page Setup...");
        printFile = new JMenuItem("Print...");
        exitFile = new JMenuItem("Exit");

        // Add file menu items to fileMenu
        fileMenu.add(newFile);
        fileMenu.add(newWindow);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.add(lineSeperator1);
        fileMenu.add(pageSetUpFile);
        fileMenu.add(printFile);
        fileMenu.add(lineSeperator2);
        fileMenu.add(exitFile);



        // edit menu
        undo = new JMenuItem("Undo");
        redo = new JMenuItem("Redo");
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        delete = new JMenuItem("Delete");
        find = new JMenuItem("Find...");
        findNext = new JMenuItem("Find Next");
        findPrevious = new JMenuItem("Find Previous");
        replace = new JMenuItem("Replace");
        goTo = new JMenuItem("Go To...");
        selectAll = new JMenuItem("Select All");
        timeDate = new JMenuItem("Time/Date");

        // Add edit menu items to the edit menu
        editMenu.add(undo);
        editMenu.add(redo);
        editMenu.add(undoSeperator);
        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(delete);
        editMenu.add(deleteSeperator);
        editMenu.add(find);
        editMenu.add(findNext);
        editMenu.add(findPrevious);
        editMenu.add(replace);
        editMenu.add(goTo);
        editMenu.add(goToSeperator);
        editMenu.add(selectAll);
        editMenu.add(timeDate);


        // format menu
        wordWrap = new JMenuItem("Word Wrap");
        font = new JMenuItem("Font...");

        // Add format menu items to the format menu
        formatMenu.add(wordWrap);
        formatMenu.add(font);

        // view menu
        statusBar = new JCheckBoxMenuItem("Status Bar");

        // zoom submenu item
        zoomIn = new JMenuItem("Zoom In");
        zoomOut = new JMenuItem("Zoom Out");
        defaultZoom = new JMenuItem("Restore Default Zoom");

        // Add its components to the zoom submenu item
        zoom.add(zoomIn);
        zoom.add(zoomOut);
        zoom.add(defaultZoom);

        // Add view menu items to the view menu
        viewMenu.add(zoom);
        viewMenu.add(statusBar);

        // help menu
        viewHelp = new JMenuItem("View Help");
        sendFeedback = new JMenuItem("Send Feedback");
        aboutNotify = new JMenuItem("About Notify");

        // Add help menu items to the help menu
        helpMenu.add(viewHelp);
        helpMenu.add(sendFeedback);
        helpMenu.add(aboutNotify);

        // Add ActionListener to all menu items
        newFile.addActionListener(this);
        newWindow.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        saveAsFile.addActionListener(this);
        pageSetUpFile.addActionListener(this);
        printFile.addActionListener(this);
        exitFile.addActionListener(this);
        undo.addActionListener(this);
        redo.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        delete.addActionListener(this);
        find.addActionListener(this);
        findNext.addActionListener(this);
        findPrevious.addActionListener(this);
        replace.addActionListener(this);
        goTo.addActionListener(this);
        selectAll.addActionListener(this);
        timeDate.addActionListener(this);
        wordWrap.addActionListener(this);
        font.addActionListener(this);
        viewHelp.addActionListener(this);
        sendFeedback.addActionListener(this);
        aboutNotify.addActionListener(this);
        zoomIn.addActionListener(this);
        zoomOut.addActionListener(this);
        defaultZoom.addActionListener(this);
        statusBar.addActionListener(this);



        popupMenu = new JPopupMenu();
        popupMenu.add(undo);
        popupMenu.add(redo);
        popupMenu.add(undo);
        popupMenu.add(undo);

        textPane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(textPane, e.getX(), e.getY());
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




        // make shortcuts to every menu items
        exitFile.setMnemonic(KeyEvent.VK_X);
        KeyStroke newFileOpener = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
        newFile.setAccelerator(newFileOpener);

        KeyStroke newWindowOpener = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK+ InputEvent.SHIFT_DOWN_MASK);
        newWindow.setAccelerator(newWindowOpener);

        KeyStroke open = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
        openFile.setAccelerator(open);

        KeyStroke save = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        saveFile.setAccelerator(save);

        KeyStroke saveAs = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK);
        saveAsFile.setAccelerator(saveAs);

        KeyStroke undoM = KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);
        undo.setAccelerator(undoM);

        KeyStroke redoM = KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK);
        redo.setAccelerator(redoM);

        KeyStroke cutM = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
        cut.setAccelerator(cutM);

        KeyStroke copyM = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
        copy.setAccelerator(copyM);

        KeyStroke pasteM = KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK);
        paste.setAccelerator(pasteM);

        KeyStroke findM = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);
        find.setAccelerator(findM);

        KeyStroke printM = KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK);
        printFile.setAccelerator(printM);

        KeyStroke select_all = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
        selectAll.setAccelerator(select_all);

        KeyStroke replaceM = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);
        replace.setAccelerator(replaceM);

        KeyStroke gotoL = KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK);
        goTo.setAccelerator(gotoL);

        KeyStroke zoom_in = KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, KeyEvent.CTRL_DOWN_MASK);
        zoomIn.setAccelerator(zoom_in);

        KeyStroke zoom_out = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK);
        zoomOut.setAccelerator(zoom_out);

        KeyStroke default_zoom = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
        defaultZoom.setAccelerator(default_zoom);

        copy.setEnabled(isTextSelected);
        frame.setJMenuBar(menuBar);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitFile) {
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Select", JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                System.exit(0);
            }
        }
        if (e.getSource() == newFile) {
            frame.dispose();
            new MenusDemo();
        }
        if (e.getSource() == timeDate) {
            SimpleDateFormat myFormat = new SimpleDateFormat(" HH:mm:ss dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();
            textPane.setText(myFormat.format(cal.getTime()));
        }
        if (e.getSource() == newWindow) {
            new MenusDemo();
        }
        if (e.getSource() == openFile) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\user\\Desktop\\"));
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            String fileName = file.getAbsolutePath();
            if (fileName.contains(".pdf") || fileName.contains(".lnk") || fileName.contains(".doc") ) {
                textPane.setText("");
            } else {
                try {
                    FileReader reader = new FileReader(fileName);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    textPane.read(bufferedReader, null);
                    bufferedReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }


        }
        if (e.getSource() == saveFile) {
            JFileChooser fileChooserSave = new JFileChooser();
            fileChooserSave.setCurrentDirectory(new File("C:\\Users\\user\\Desktop\\"));
            // show up the dialog
            int resultSave = fileChooserSave.showSaveDialog(frame.getParent());
            // check if the user saves a file
            if (resultSave == JFileChooser.APPROVE_OPTION) {
                File file = new File(String.valueOf(fileChooserSave.getSelectedFile()));
                try {
                    if (file.createNewFile()) {
                        System.out.println("File created");
                        System.out.println(fileChooserSave.getSelectedFile().getAbsolutePath());
                    } else if (file.exists()) {
                        FileWriter fileWriter = new FileWriter(String.valueOf(fileChooserSave.getSelectedFile()));
                        fileWriter.append(textPane.getText());
                        fileWriter.close();
                    }
                    else {
                        System.out.println("Error while creating file");
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
        if (e.getSource() == saveAsFile) {
            JFileChooser fileChooserSave = new JFileChooser();
            fileChooserSave.setCurrentDirectory(new File("C:\\Users\\user\\Desktop\\"));
            // show up the dialog
            int resultSave = fileChooserSave.showSaveDialog(frame.getParent());
            // check if the user saves a file
            if (resultSave == JFileChooser.APPROVE_OPTION) {
                File file = new File(String.valueOf(fileChooserSave.getSelectedFile()));
                try {
                    if (file.createNewFile()) {
                        System.out.println("File created");
                        System.out.println(fileChooserSave.getSelectedFile().getAbsolutePath());
                    } else if (file.exists()) {
                        FileWriter fileWriter = new FileWriter(String.valueOf(fileChooserSave.getSelectedFile()));
                        fileWriter.append(textPane.getText());
                        fileWriter.close();
                    }
                    else {
                        System.out.println("Error while creating file");
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
        if (e.getSource() == font) {
            Fonts fonts = new Fonts();
            if (fonts.fontsList.getSelectedIndex() != -1 && fonts.fontsStyle.getSelectedIndex() != -1 && fonts.fontsSize.getSelectedIndex() != -1) {
                String font_size = fonts.fontsSize.getSelectedValue().toString();
                int fonts_size = Integer.parseInt(font_size);
                textPane.setFont(new Font((String) fonts.fontsList.getSelectedValue(),  fonts.fontsStyle.getSelectedIndex(), fonts_size));
            }

        }
        if (e.getSource() == selectAll) {
            textPane.selectAll();
        }
        if (e.getSource() == copy) {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            TransferHandler transferHandler = textPane.getTransferHandler();
            transferHandler.exportToClipboard(textPane, clipboard, TransferHandler.COPY);
        }
        if (e.getSource() == cut) {
            textPane.cut();

        }
        if (e.getSource() == paste) {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            TransferHandler transferHandler = textPane.getTransferHandler();
            transferHandler.importData(textPane, clipboard.getContents(null));
        }
        if (e.getSource() == delete) {
            String selected = textPane.getSelectedText();
            if (!selected.equals("")) {
                textPane.replaceSelection("");
            }
        }

        if (e.getSource() == find) {
            String search = JOptionPane.showInputDialog("Find What");
            Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);

            int offset = textPane.getText().indexOf(search);
            int length = search.length();

            while (offset != -1) {
                try  {
                    textPane.getHighlighter().addHighlight(offset, offset + length, painter);
                    offset = textPane.getText().indexOf(search, offset + 1);
                } catch (BadLocationException badLocationException) {
                    System.out.println("An error occured, please try again!");
                } ;
            }
        }
        if (e.getSource() == undo) {
            try {
                manager.undo();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == redo) {
            try {
                manager.redo();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == wordWrap) {
            SimpleAttributeSet attributeSet = new SimpleAttributeSet();
            StyleConstants.setItalic(attributeSet, true);
            StyleConstants.setForeground(attributeSet, Color.BLUE);
            textPane.setCharacterAttributes(attributeSet, true);
        }
        if (e.getSource() == printFile) {
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            if (printerJob.printDialog()) {
                try {
                    printerJob.print();
                } catch (PrinterException ex) {
                    System.out.println(ex);

                }
            }
        }



    }



    public class Fonts implements ActionListener {
        JFrame frame;
        JLabel font_name_label, font_style_label, font_size, sampleLabel;
        JButton closeButton, okButton, cancelButton;
        JList fontsList, fontsStyle, fontsSize;
        JTextArea sampleTextArea;

        public Fonts() {
            frame = new JFrame();
            frame.setTitle("Fonts");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
            frame.setUndecorated(true);
            frame.setBackground(Color.lightGray);
            frame.setResizable(false);

            ImageIcon icon = new ImageIcon("C:\\Users\\user\\IdeaProjects\\BroCode_GUI\\src\\close.png");
            closeButton = new JButton();
            closeButton.setBounds(465, 10, 30, 30);
            closeButton.setFocusable(false);
            closeButton.setIcon(icon);
            closeButton.addActionListener(this);

            okButton = new JButton("OK");
            okButton.setBounds(250, 400, 70, 30);
            okButton.setFocusable(false);
            okButton.addActionListener(this);

            cancelButton = new JButton("Cancel");
            cancelButton.setBounds(350, 400, 80, 30);
            cancelButton.setFocusable(false);
            cancelButton.addActionListener(this);

            font_name_label = new JLabel("Font:");
            font_name_label.setBounds(20, 40, 30, 20);


            font_style_label = new JLabel("Font Style:");
            font_style_label.setBounds(200, 40, 80, 20);

            font_size = new JLabel("Size:");
            font_size.setBounds(350, 40, 40, 20);



            DefaultListModel fontName = new DefaultListModel();
            fontName.addElement("Agency FB");
            fontName.addElement("Algerian");
            fontName.addElement("Arial");
            fontName.addElement("Arial Rounded MT");
            fontName.addElement("Arial Unicode MS");
            fontName.addElement("Candara");
            fontName.addElement("Castellar");
            fontName.addElement("Cambria");
            fontName.addElement("Calibri");
            fontName.addElement("Century");
            fontName.addElement("Century Gothic");
            fontName.addElement("Century Schoolbook");
            fontName.addElement("Comic Sans MS");
            fontName.addElement("Chiller");
            fontName.addElement("Colonna MT");
            fontName.addElement("Consolas");
            fontName.addElement("Palatino Linotype");
            fontName.addElement("Poor Richard");
            fontName.addElement("Papyrurs");
            fontName.addElement("Perpetua");
            fontName.addElement("Lucida Console");
            fontName.addElement("MV Boli");
            fontName.addElement("MS Himalaya");
            fontName.addElement("Modern");
            fontName.addElement("Myanmar Text");
            fontName.addElement("Roman");
            fontName.addElement("Sans Comic");
            fontName.addElement("Segoe MDL2 Assets");
            fontName.addElement("Segoe Print");
            fontName.addElement("Segoe Script");
            fontName.addElement("Segoe UI");
            fontName.addElement("Symbol");
            fontName.addElement("System");


            fontsList = new JList(fontName);
            fontsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            //fontsList.setSelectedIndex(0);

            JScrollPane fontsListScrollPane = new JScrollPane(fontsList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            fontsListScrollPane.setBounds(20, 60, 150, 150);



            DefaultListModel fontStyle = new DefaultListModel();
            fontStyle.addElement("Regular");
            fontStyle.addElement("Bold");
            fontStyle.addElement("Italic");




            fontsStyle = new JList(fontStyle);
            fontsStyle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            fontsStyle.setSelectedIndex(0);

            JScrollPane fontsStyleScrollPane = new JScrollPane(fontsStyle);
            fontsStyleScrollPane.setBounds(200, 60, 100, 150);

            DefaultListModel fontSize = new DefaultListModel();
            fontSize.addElement("8");
            fontSize.addElement("9");
            fontSize.addElement("10");
            fontSize.addElement("11");
            fontSize.addElement("12");
            fontSize.addElement("14");
            fontSize.addElement("18");
            fontSize.addElement("20");
            fontSize.addElement("22");
            fontSize.addElement("24");
            fontSize.addElement("26");
            fontSize.addElement("28");
            fontSize.addElement("36");
            fontSize.addElement("48");
            fontSize.addElement("72");

            fontsSize = new JList(fontSize);
            fontsSize.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            fontsSize.setSelectedIndex(5);

            JScrollPane fontsSizeScrollPane = new JScrollPane(fontsSize, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            fontsSizeScrollPane.setBounds(350, 60, 80, 150);


            // sample label
            sampleLabel = new JLabel("Sample");
            sampleLabel.setBounds(210, 190, 100, 100);


            // sample text area
            sampleTextArea = new JTextArea();
            sampleTextArea.setEditable(false);
            sampleTextArea.setBounds(200, 250, 238, 80);
            sampleTextArea.setBorder(BorderFactory.createEtchedBorder());
            sampleTextArea.setText("AaBbYyZz".indent(30));





            frame.add(font_name_label);
            frame.add(fontsListScrollPane);
            frame.add(font_style_label);
            frame.add(fontsStyleScrollPane);
            frame.add(font_size);
            frame.add(fontsSizeScrollPane);
            frame.add(closeButton);
            frame.add(okButton);
            frame.add(cancelButton);
            frame.add(sampleLabel);
            frame.add(sampleTextArea);
            frame.setBackground(Color.lightGray);
            frame.setVisible(true);




        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == closeButton) {
                int closeChoice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Select", JOptionPane.YES_NO_OPTION);
                if (closeChoice == 0) {
                    System.exit(0);
                }
            }
            if (e.getSource() == okButton) {
                if (fontsList.getSelectedIndex() != -1 && fontsStyle.getSelectedIndex() != -1 && fontsSize.getSelectedIndex() != -1) {
                    String font_size = fontsSize.getSelectedValue().toString();
                    int fonts_size = Integer.parseInt(font_size);
                    textPane.setFont(new Font((String) fontsList.getSelectedValue(),  fontsStyle.getSelectedIndex(), fonts_size));
                }
            }

            if (fontsList.getSelectedIndex() != -1 && fontsStyle.getSelectedIndex() != -1 && fontsSize.getSelectedIndex() != -1) {
                String font_size = fontsSize.getSelectedValue().toString();
                int fonts_size = Integer.parseInt(font_size);
                sampleTextArea.setFont(new Font((String) fontsList.getSelectedValue(),  fontsStyle.getSelectedIndex(), fonts_size));
            }

            if (e.getSource() == cancelButton) {
                frame.setVisible(false);
            }
        }
    }





}



class MenusMain {
    public static void main(String[] args) {
        MenusDemo menusDemo = new MenusDemo();
    }
}
