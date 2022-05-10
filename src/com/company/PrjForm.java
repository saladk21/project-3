package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrjForm extends JFrame{

    //Name TEXT
    String sName;
    JLabel nLabel;
    JLabel genderLabel;
    JRadioButton male;
    JRadioButton female;
    ButtonGroup gender;
    //ID TEXT
    int sId;
    JLabel idLabel;


    //dWorkingHrs DATE
    String [] dWorkingHrsSt=
            {"8:00am","9:00am","10:00am","11:00am","12:00pm"};
    JComboBox<String>wrkSt;
    String [] dWorkingHrsEd=
            {"5:00pm","6:00pm","7:00pm","8:00pm","9:00pm","10:00pm","11:00pm","12:00am"};
    JComboBox<String>wrkEd;
    JLabel toLabel;
    JLabel fromLabel;

    //NumOfPatients TEXT

    String [] specialize =
            {"Anesthesiology","Dermatology","Neurology","Psychiatry","Surgery"};
    JComboBox<String>spec;

    //serialNum TEXT
    //mName TEXT
    //price TEXT
    //expiryDate
    //stock radio button,if available quantity
    JLabel stockLabel;
    JRadioButton available;
    JRadioButton unavailable;
    ButtonGroup stock;
    JTextField quantity;
    JLabel quantityLabel;


    //assignedTo
    //nWorkingHrs we will use the drWorkingHrs

    //pName TEXT
    JTextField pName;
    JTextField pId;
    String [] pCase =
            {"Undetermined","Good","Fair","Serious","Critical","Treated and Released"};
    JComboBox<String>cases;
    //illnessDes TEXT
    JTextField sIll;
    JLabel illLabel;


    JButton confirm;
    JButton cancel;

    public PrjForm() {

        super("Hospital");


        male = new JRadioButton("Male");		//Buttons
        female = new JRadioButton("Female");

        genderLabel = new JLabel("Gender: ");

        add(genderLabel);
        add(male);
        add(female);

        gender = new ButtonGroup();			//Button Group
        gender.add(male);
        gender.add(female);


        spec = new JComboBox<String>(specialize);		//List
        cases = new JComboBox<String>(pCase);
        wrkSt = new JComboBox<String>(dWorkingHrsSt);	//Working Hour List
        wrkEd = new JComboBox<String>(dWorkingHrsEd);


        spec.setMaximumRowCount(5);
        cases.setMaximumRowCount(6);
        wrkSt.setMaximumRowCount(5);
        wrkSt.setMaximumRowCount(8);

        toLabel = new JLabel("To: ");
        fromLabel = new JLabel("From: ");

        add(spec);
        add(cases);
        add(fromLabel);
        add(wrkSt);
        add(toLabel);
        add(wrkEd);

        pName = new JTextField(25);			//Entering Name
        nLabel = new JLabel("Name: ");
        add(nLabel);
        add(pName);

        pId = new JTextField(10);			//Entering ID
        idLabel = new JLabel("ID: ");
        add(idLabel);
        add(pId);

        sIll = new JTextField(50);			//Entering Illness
        illLabel = new JLabel("Illnes Description:  ");
        add(illLabel);
        add(sIll);

        available =new JRadioButton("Available");		//Med Availability
        unavailable =new JRadioButton("Unavailable");

        stockLabel = new JLabel("Stock: ");

        add(stockLabel);
        add(available);
        add(unavailable);

        stock = new ButtonGroup();			//Stock
        stock.add(available);
        stock.add(unavailable);

        quantityLabel = new JLabel("Quantity: ");
        quantity = new JTextField(10);

        add(quantityLabel);
        add(quantity);




        confirm = new JButton("Confirm");  //Confirm Button
        cancel = new JButton("Cancel");

        add(confirm);
        add(cancel);

        ButonHandler handler = new ButonHandler();

        confirm.addActionListener(handler);
        cancel.addActionListener(handler);
        pName.addActionListener(handler);

    }
    private class ButonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==confirm)
                JOptionPane.showMessageDialog(null, "The Changes Have Been Saved");

            if(e.getSource()==cancel)
                System.exit(0);

        }

    }
}
