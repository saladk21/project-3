package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Patients extends JFrame {

    public Patients(int pID, String pName, String pcase, int dID, String gender, String illnessDes) {
        this.pID = pID;
        this.pName = pName;
        this.pcase = pcase;
        this.dID = dID;
        this.gender = gender;
        this.illnessDes = illnessDes;
    }

    private int pID;
    private String pName;
    private String pcase; // dropBox Severe , checkUp , Healthy
    private int dID; // foreign key
    private String gender;
    private String illnessDes;
    JLabel nLabel;
    JLabel genderLabel;
    JRadioButton male;
    JRadioButton female;
    ButtonGroup genderGrp;
    JLabel idLabel;
    JTextField pNameJtxt;
    JTextField pIdJtxt;
    String [] pCase =
            {"Undetermined","Good","Fair","Serious","Critical","Treated and Released"};
    JComboBox<String>cases;
    JTextField sIll;
    JLabel illLabel;
    JLabel caseLabel;

    JButton confirm;
    JButton cancel;

    public Patients() {							//GUI BEGIN

        super("Hospital");
        setLayout(new FlowLayout());

        male = new JRadioButton("Male");		//Buttons
        female = new JRadioButton("Female");

        genderLabel = new JLabel("Gender: ");

        add(genderLabel);
        add(male);
        add(female);

        caseLabel = new JLabel("Case");
        add(caseLabel);

        genderGrp = new ButtonGroup();			//Button Group
        genderGrp.add(male);
        genderGrp.add(female);

        cases = new JComboBox<String>(pCase);
        cases.setMaximumRowCount(6);
        add(cases);


        pNameJtxt = new JTextField(25);			//Entering Name
        nLabel = new JLabel("Name: ");
        add(nLabel);
        add(pNameJtxt);

        pIdJtxt = new JTextField(20);			//Entering ID
        idLabel = new JLabel("ID: ");
        add(idLabel);
        add(pIdJtxt);

        sIll = new JTextField(20);			//Entering Illness
        illLabel = new JLabel("Illnes Description:  ");
        add(illLabel);
        add(sIll);



        confirm = new JButton("Confirm");  //Confirm Button
        cancel = new JButton("Cancel");

        add(confirm);
        add(cancel);

        ButonHandler handler = new ButonHandler();

        confirm.addActionListener(handler);
        cancel.addActionListener(handler);
        male.addActionListener(handler);
        female.addActionListener(handler);
        pNameJtxt.addActionListener(handler);
        pIdJtxt.addActionListener(handler);
        sIll.addActionListener(handler);
        cases.addActionListener(handler);
    }


    public void  assingDoc(Doctors doc , Patients patients){
        dID = doc.getID();
        doc.setNumOfPatients(doc.getNumOfPatients() + 1);
    }

    public void pInfo(Patients patients){
         System.out.println("patient with id number "+ patients.getpID()+ " is assigned to doc with id number: " + patients.getdID() );
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getPcase() {
        return pcase;
    }

    public void setPcase(String pcase) {
        this.pcase = pcase;
    }

    public int getdID() {
        return dID;
    }

    public void setdID(int dID) {
        this.dID = dID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIllnessDes() {
        return illnessDes;
    }

    public void setIllnessDes(String illnessDes) {
        this.illnessDes = illnessDes;
    }

    private class ButonHandler implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            int key = 0;

            try {

                if(e.getSource()==confirm){
                    if (pIdJtxt.getText().length() == 0){
                        JOptionPane.showMessageDialog(null , "Must enter an ID");
                    }
                    else
                    setdID(Integer.parseInt(pIdJtxt.getText()));
                    key++;
                }

            } catch (NumberFormatException exp) {
                JOptionPane.showMessageDialog(null, "Error: You must enter an integer");
                }

                if(e.getSource()==confirm) {
                    if (pNameJtxt.getText().length() == 0 ){
                        JOptionPane.showMessageDialog(null , "Must enter a name");
                    }
                    else {
                        setpName(pNameJtxt.getText());
                        key++;
                    }
                    if (sIll.getText().length() == 0){
                        JOptionPane.showMessageDialog(null , "Must enter an Illness description");
                    }
                    else {
                        setIllnessDes(sIll.getText());
                        key++;

                    }
                    if (key >= 3){
                        JOptionPane.showMessageDialog(null, "The Changes Have Been Saved");
                    }
                    else JOptionPane.showMessageDialog(null, "No changes have been made");

                }

                if(e.getSource()==cancel) {
                    System.exit(0);
                }
                if(e.getSource()==male) { // works
                    setGender("Male");
                    System.out.println(getGender());

                }
                if(e.getSource()==female) {
                    setGender("Female");
                    System.out.println(getGender());

                }
                if(e.getSource()== cases ) {
                    setPcase((String) cases.getSelectedItem());
                    System.out.println(getPcase());

                }


        }
    }

}
