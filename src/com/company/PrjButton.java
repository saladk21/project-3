package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrjButton extends JFrame {

    JButton dButton; //Doctor Button
    JButton nButton; //Nurse Button
    JButton mButton; //Medicine Button
    JButton pButton; //Patient Button
    JButton gButton; //Patient Button

    JMenuBar menuBar; //MenuBar
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;

    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    JMenuItem addDocotorItem;
    JMenuItem addPatientItem;
    JMenuItem addMed;
    JMenuItem addNurse;
    JMenuItem addManager;

    Patients pr;
    Doctors dr;
    Medicine md;
    Nurses nr;
    Managers g;


    public PrjButton() {


        JFrame f = new JFrame();
        ImageIcon hos = new ImageIcon(getClass().getClassLoader().getResource("com/company/hospital.png"));
        f.setIconImage(hos.getImage());
        f.setTitle("Hospital");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(255, 208, 198));
        f.setLayout(new GridLayout(2,1));








        dButton = new JButton();
        nButton = new JButton();
        mButton = new JButton();
        pButton = new JButton();
        gButton = new JButton();

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");							//rows
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        loadItem = new JMenuItem("Load");						//columns
        saveItem = new JMenuItem("Save");						//File Items
        exitItem = new JMenuItem("Exit");

        addPatientItem = new JMenuItem("Add Patient");		//Edit Items
        addDocotorItem = new JMenuItem("Add Doctor");
        addMed = new JMenuItem("Add Medicine");
        addNurse = new JMenuItem("Add Nurse");
        addManager = new JMenuItem("Add Manager");


        Icon dIcon = new ImageIcon(getClass().getResource("doctor.png"));			//Image Icons
        Icon nIcon = new ImageIcon(getClass().getResource("nurse.png"));
        Icon mIcon = new ImageIcon(getClass().getResource("medicine.png"));
        Icon pIcon = new ImageIcon(getClass().getResource("patient.png"));
        Icon gIcon = new ImageIcon(getClass().getClassLoader().getResource("com/company/manager.png"));






        dButton = new JButton("Doctor",dIcon);
        nButton = new JButton("Nurse",nIcon);
        mButton = new JButton("Medicine",mIcon);
        pButton = new JButton("Patient",pIcon);
        gButton = new JButton("Manager",gIcon);

        dButton.setFont(new Font( null, Font.ITALIC,25));
        nButton.setFont(new Font( null, Font.ITALIC,25));
        mButton.setFont(new Font( null, Font.ITALIC,25));
        pButton.setFont(new Font( null, Font.ITALIC,25));
        gButton.setFont(new Font( null, Font.ITALIC,25));

        dButton.setHorizontalTextPosition(SwingConstants.CENTER);		//Text Position
        dButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        nButton.setHorizontalTextPosition(SwingConstants.CENTER);
        nButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        mButton.setHorizontalTextPosition(SwingConstants.CENTER);
        mButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        pButton.setHorizontalTextPosition(SwingConstants.CENTER);
        pButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        gButton.setVerticalTextPosition(SwingConstants.CENTER);
        gButton.setVerticalTextPosition(SwingConstants.BOTTOM);


        f.add(dButton);
        f.add(nButton);
        f.add(mButton);
        f.add(pButton);
        f.add(gButton);

        f.pack();
        f.setVisible(true);


        fileMenu.add(loadItem);			//MenuBar
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        editMenu.add(addDocotorItem);
        editMenu.add(addPatientItem);
        editMenu.add(addMed);
        editMenu.add(addNurse);
        editMenu.add(addManager);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        menuBar.setBackground(new Color(206, 97, 73));		//MenuBar Color
        menuBar.setOpaque(true);

        this.setJMenuBar(menuBar);


        ButonHandler handler = new ButonHandler();			//Handler

        dButton.addActionListener(handler);
        nButton.addActionListener(handler);
        mButton.addActionListener(handler);
        pButton.addActionListener(handler);
        gButton.addActionListener(handler);

        loadItem.addActionListener(handler);
        saveItem.addActionListener(handler);
        exitItem.addActionListener(handler);
        addDocotorItem.addActionListener(handler);
        addPatientItem.addActionListener(handler);
        addMed.addActionListener(handler);
        addNurse.addActionListener(handler);
        addManager.addActionListener(handler);






    }

    private class ButonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==pButton) {

                pr = new Patients();	
                pr.setTitle("Patient");//Open Form Method
                pr.setLayout(new GridLayout(4,4));
                pr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                pr.setSize(500,500);
                pr.pack();
                pr.setVisible(true);
                pr.getContentPane().setBackground(new Color(255, 208, 198));
                ImageIcon pIcon = new ImageIcon(getClass().getResource("patient.png"));
                pr.setIconImage(pIcon.getImage());
            }
            if(e.getSource()==nButton) {
            	nr = new Nurses();	//Open Form Method
            	nr.setTitle("Nurse");
                nr.setLayout(new GridLayout(3,4));
                nr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                nr.setSize(500,500);
                ImageIcon nIcon = new ImageIcon(getClass().getResource("nurse.png"));
                nr.setIconImage(nIcon.getImage());
                nr.pack();
                nr.setVisible(true);
                nr.getContentPane().setBackground(new Color(255, 208, 198));
            }
            if(e.getSource()==mButton) {
            	 md = new Medicine();	//Open Form Method
            	 md.setTitle("Medicine");
                 md.setLayout(new GridLayout(4,4));
                 md.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 md.setSize(500,500);
                ImageIcon mIcon = new ImageIcon(getClass().getResource("medicine.png"));
                 md.setIconImage(mIcon.getImage());
                 md.pack();
                 md.setVisible(true);
                 md.getContentPane().setBackground(new Color(255, 208, 198));
            }
            if(e.getSource()==dButton) {
            	dr = new Doctors();	//Open Form Method
            	dr.setTitle("Doctor");
                dr.setLayout(new GridLayout(4,4));
                dr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dr.setSize(500,500);
                ImageIcon dIcon = new ImageIcon(getClass().getResource("doctor.png"));
                dr.setIconImage(dIcon.getImage());
                dr.pack();
                dr.setVisible(true);
                dr.getContentPane().setBackground(new Color(255, 208, 198));
            }
            if(e.getSource()==gButton) {
                g = new Managers();	//Open Form Method
                g.setTitle("Manager");
                g.setLayout(new GridLayout(4,4));
                g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                g.setSize(500,500);
                ImageIcon gIcon = new ImageIcon(getClass().getClassLoader().getResource("com/company/manager.png"));
                g.setIconImage(gIcon.getImage());
                g.pack();
                g.setVisible(true);
                g.getContentPane().setBackground(new Color(255, 208, 198));
            }
            if(e.getSource()==exitItem) {
                System.exit(0);
            }

            if(e.getSource()==addDocotorItem) {
                dr = new Doctors();	//Open Form Method
                dr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dr.setSize(500,500);
                dr.setVisible(true);
                dr.getContentPane().setBackground(new Color(255, 208, 198));
            }
            if(e.getSource()==addPatientItem) {
            	 pr = new Patients();	//Open Form Method
                 pr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 pr.setSize(500,500);
                 pr.setVisible(true);
                 pr.getContentPane().setBackground(new Color(255, 208, 198));
            }
            if(e.getSource()==addMed) {
            	md = new Medicine();	//Open Form Method
                md.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                md.setSize(500,500);
                md.setVisible(true);
                md.getContentPane().setBackground(new Color(255, 208, 198));
            }
            if(e.getSource()==addNurse) {
               	nr = new Nurses();	//Open Form Method
                nr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                nr.setSize(500,500);
                nr.setVisible(true);
                nr.getContentPane().setBackground(new Color(255, 208, 198));
            }

            if(e.getSource()==addManager) {
                g = new Managers();	//Open Form Method
                g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                g.setSize(500,500);
                g.setVisible(true);
                g.getContentPane().setBackground(new Color(255, 208, 198));
            }

        }

    }

}
