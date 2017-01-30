package de.breitenbach;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;

import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;

public class UserInterface implements ActionListener
{
    public JLabel jLtarget, jLtime, JLuserData, jLweight, jLbloodGlucose, jLbloodPresure, jLheader;
    public JButton jBweight, jBbloodGlucose, jBbloodPresure, jBdiagram, jBtable, jBexport;
    public JButton jBsend, jBabort, jBclose;
    public JCheckBox jCBweight, jCBbloodGlucose, jCBbloodPresure;
    public JComboBox<String> JCoBtime, JCoBtarget;
    private JFrame jFwindow;
    private JPanel jPLayout, jPchoice, jPAnzeige, jPheader, jPdivide;
    private JMenuItem jMIclose, jMIuse, jMIfaq, jMIdataReload, jMIuserData;
    private Font menuFont, buttonFont, button2Font, itemFont, textFont;
    private BufferedImage headerImg;
    private JTextArea jTuse, jTfaq;
    private String source;
    private JTable table;

    UserInterface()
    {
        super();

        menuFont = new Font(Font.DIALOG, 0, 24);
        buttonFont = new Font(Font.DIALOG, 0, 30);
        button2Font = new Font(Font.DIALOG, 0, 24);
        itemFont = new Font(Font.DIALOG, 0, 18);
        textFont = new Font(Font.DIALOG, 0, 18);

        JMenuBar menuBar;
        JMenu menu, help;

        jFwindow = new JFrame("With iHealth to eHealth");
        jFwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFwindow.setLayout(new BorderLayout());
        jFwindow.setMinimumSize(new Dimension(1280, 1024));
        jFwindow.setPreferredSize(new Dimension(1280, 1024));

        jPdivide = new JPanel();
        jPdivide.setLayout(new BorderLayout());
        jFwindow.add(jPdivide, BorderLayout.WEST);

        jPLayout = new JPanel();
        jPLayout.setLayout(new GridLayout(4, 1, 2, 2));
        jPLayout.setBorder(new EmptyBorder(10, 10, 10, 0));
        jPdivide.add(jPLayout, BorderLayout.WEST);

        jPchoice = new JPanel();
        jPchoice.setLayout(new GridLayout(8, 1, 2, 2));
        jPchoice.setBorder(new EmptyBorder(10, 10, 10, 0));
        jPdivide.add(jPchoice, BorderLayout.EAST);

        jPAnzeige = new JPanel();
        jFwindow.add(jPAnzeige, BorderLayout.CENTER);

        jPheader = new JPanel();
        try
        {
            headerImg = ImageIO.read(new File("resources/Projekt_eHealth.png"));
            jLheader = new JLabel(new ImageIcon(headerImg));
        } catch (IOException e)
        {
            System.out.println("Datei nicht gefunden.");
        }
        jPheader.add(jLheader);
        jFwindow.add(jPheader, BorderLayout.NORTH);

        jBsend = new JButton("Senden");
        jBsend.setMinimumSize(new Dimension(100, 100));
        jBsend.setPreferredSize(new Dimension(150, 100));
        jBsend.setFont(buttonFont);

        jBabort = new JButton("Abbrechen");
        jBabort.setMinimumSize(new Dimension(100, 100));
        jBabort.setPreferredSize(new Dimension(150, 100));
        jBabort.setFont(buttonFont);

        jBclose = new JButton("Schliessen");
        jBclose.setMinimumSize(new Dimension(100, 100));
        jBclose.setPreferredSize(new Dimension(150, 100));
        jBclose.setFont(buttonFont);

        jBdiagram = new JButton("Diagramm");
        jBdiagram.setMinimumSize(new Dimension(100, 100));
        jBdiagram.setPreferredSize(new Dimension(150, 100));
        jBdiagram.setFont(button2Font);

        jBtable = new JButton("Tabelle");
        jBtable.setMinimumSize(new Dimension(100, 100));
        jBtable.setPreferredSize(new Dimension(150, 100));
        jBtable.setFont(button2Font);

        jBexport = new JButton("Export");
        jBexport.setMinimumSize(new Dimension(100, 100));
        jBexport.setPreferredSize(new Dimension(150, 100));
        jBexport.setFont(button2Font);

        jTuse = new JTextArea(20, 60);
        jTuse.setFont(textFont);
        jTuse.setEditable(false);
        jTfaq = new JTextArea(20, 60);
        jTfaq.setFont(textFont);
        jTfaq.setEditable(false);

        jBweight = new JButton("Gewicht");
        jBweight.setMinimumSize(new Dimension(100, 100));
        jBweight.setPreferredSize(new Dimension(200, 100));
        jBweight.setFont(buttonFont);
        jBweight.setBackground(new Color(20, 133, 204));

        jBbloodGlucose = new JButton("Blutzucker");
        jBbloodGlucose.setMinimumSize(new Dimension(100, 100));
        jBbloodGlucose.setPreferredSize(new Dimension(200, 100));
        jBbloodGlucose.setFont(buttonFont);
        jBbloodGlucose.setBackground(new Color(255, 25, 25));

        jBbloodPresure = new JButton("Blutdruck");
        jBbloodPresure.setMinimumSize(new Dimension(100, 100));
        jBbloodPresure.setPreferredSize(new Dimension(200, 100));
        jBbloodPresure.setFont(buttonFont);
        jBbloodPresure.setBackground(new Color(255, 252, 25));

        jCBweight = new JCheckBox("Gewicht");
        jCBbloodGlucose = new JCheckBox("Blutzucker");
        jCBbloodPresure = new JCheckBox("Blutdruck");

        jPLayout.add(jBweight);
        jPLayout.add(jBbloodPresure);
        jPLayout.add(jBbloodGlucose);

        menuBar = new JMenuBar();
        menuBar.setBackground(Color.LIGHT_GRAY);
        menu = new JMenu("Men�");
        menu.setFont(menuFont);
        help = new JMenu("Hilfe");
        help.setFont(menuFont);

        jMIuserData = new JMenuItem("Benutzerdaten");
        jMIuserData.setFont(itemFont);
        jMIclose = new JMenuItem("Beenden");
        jMIclose.setFont(itemFont);
        jMIuse = new JMenuItem("Anleitung");
        jMIuse.setFont(itemFont);
        jMIfaq = new JMenuItem("FAQ");
        jMIfaq.setFont(itemFont);
        jMIdataReload = new JMenuItem("Daten Update");
        jMIdataReload.setFont(itemFont);

        menuBar.add(menu);
        menuBar.add(help);

        menu.add(jMIuserData);
        menu.add(jMIdataReload);
        menu.add(jMIclose);
        help.add(jMIuse);
        help.add(jMIfaq);

        jPchoice.add(jBdiagram);
        jPchoice.add(jBtable);
        jPchoice.add(jBexport);
        jPchoice.setVisible(false);

        jFwindow.setJMenuBar(menuBar);
        jFwindow.pack();
        jFwindow.setVisible(true);

        jBweight.addActionListener(this);
        jBbloodPresure.addActionListener(this);
        jBbloodGlucose.addActionListener(this);
        jMIuserData.addActionListener(this);
        jMIdataReload.addActionListener(this);
        jMIclose.addActionListener(this);
        jMIuse.addActionListener(this);
        jMIfaq.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == jMIuserData)
        {
            this.jMIuserData();
        } else if (e.getSource() == jBweight)
        {
            this.jBweight();
        } else if (e.getSource() == jBbloodPresure)
        {
            this.jBbloodPresure();
        } else if (e.getSource() == jBbloodGlucose)
        {
            this.jBbloodGlucose();
        } else if (e.getSource() == this.jMIdataReload)
        {
            this.jMIdataReload();
        } else if (e.getSource() == this.jMIclose)
        {
            this.jMIclose();
        } else if (e.getSource() == this.jMIuse)
        {
            this.jMIuse();
        } else if (e.getSource() == this.jMIfaq)
        {
            this.jMIfaq();
        } else if (e.getSource() == this.jBtable && source.equals(("weight")))
        {
            System.out.println("gleich");
            this.jTableWeight();
        }
    }

    private void jTableWeight()
    {
        String[] title= new String[]{"Eintrag", "User","Messdatum", "Gewicht", "BMI"};
        table = new JTable(iHealthWeightToDB.selectWeight(),title);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(800,600));
        scroll.setMinimumSize(new Dimension(640,480));
        table.setFillsViewportHeight(true);
        jPAnzeige.add(scroll);
        jPchoice.setVisible(false);
        table.setVisible(true);
        jPAnzeige.setVisible(true);
        jFwindow.pack();
    }

    private void jMIuserData()
    {

    }

    private void jMIfaq()
    {
        jTuse.setVisible(false);
        jPAnzeige.add(jTfaq);
        jTfaq.setVisible(true);
        jPAnzeige.setVisible(true);
        jTfaq.setText("");
        jTfaq.append("Fragen und Antworten!\nHier stehen dumme Fragen.\n");
        jPchoice.setVisible(false);

    }

    private void jMIuse()
    {
        jTfaq.setVisible(false);
        jPAnzeige.add(jTuse);
        jTuse.setVisible(true);
        jPAnzeige.setVisible(true);
        jTuse.setText("");
        jTuse.append("HowTo\nHier steht eine kleine Erkl�rung.\n");
        jPchoice.setVisible(false);
    }

    private void jMIclose()
    {
        System.exit(0);

    }

    private void jMIdataReload()
    {

    }

    private void jBbloodGlucose()
    {
        jBdiagram.setBackground(new Color(255, 25, 25));
        jBtable.setBackground(new Color(255, 25, 25));
        jBexport.setBackground(new Color(255, 25, 25));

        jTuse.setVisible(false);
        jTfaq.setVisible(false);
        jPchoice.setVisible(true);
        jFwindow.pack();
    }

    private void jBbloodPresure()
    {
        jBdiagram.setBackground(new Color(255, 252, 25));
        jBtable.setBackground(new Color(255, 252, 25));
        jBexport.setBackground(new Color(255, 252, 25));

        jTuse.setVisible(false);
        jTfaq.setVisible(false);
        jPchoice.setVisible(true);
        jFwindow.pack();
    }

    private void jBweight()
    {
        jBdiagram.setBackground(new Color(20, 133, 204));
        jBtable.setBackground(new Color(20, 133, 204));
        jBexport.setBackground(new Color(20, 133, 204));

        jBtable.addActionListener(this);
        source = "weight";

        jTuse.setVisible(false);
        jTfaq.setVisible(false);
        jPchoice.setVisible(true);
        jFwindow.pack();


    }

}
