package com.company;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Nurses extends Employees{


    public Nurses(String name, String gender, int ID) {
        super(name, gender, ID);
    }

    private String assignedTo;
    private String position;
    private String nWorkingHrs;
    private String nWorkingHrs2;
    JTextField Nname;
    JLabel nLabel;
    JLabel genderLabel;
    JRadioButton male;
    JRadioButton female;
    ButtonGroup gender;
    JTextField NId;
    JLabel idLabel;
    String [] NurseWorkingHrsSt=
            {"8:00am","9:00am","10:00am","11:00am","12:00pm"};
    JComboBox<String>wrkSt;
    String [] NurseWorkingHrsEd=
            {"5:00pm","6:00pm","7:00pm","8:00pm","9:00pm","10:00pm","11:00pm","12:00am"};
    JComboBox<String>wrkEd;
    JLabel toLabel;
    JLabel fromLabel;
    JLabel PosLabel;
    JComboBox<String>Pos;
    String [] positionArr =
        {"Anesthesiology","Dermatology","Neurology","Psychiatry","Surgery","Head"};
    

    JButton confirm;
    JButton cancel;
    public Nurses() {
    	super();
    	   setLayout(new FlowLayout());
    	   

           male = new JRadioButton("Male");		//Buttons
           female = new JRadioButton("Female");

           genderLabel = new JLabel("Gender: ");

           add(genderLabel);
           add(male);
           add(female);

           gender = new ButtonGroup();			//Button Group
           gender.add(male);
           gender.add(female);


           Pos = new JComboBox<String>(positionArr);		//List
           
           wrkSt = new JComboBox<String>(NurseWorkingHrsSt);	//Working Hour List
           wrkEd = new JComboBox<String>(NurseWorkingHrsEd);


           Pos.setMaximumRowCount(6);
           wrkSt.setMaximumRowCount(5);
           wrkSt.setMaximumRowCount(8);

           toLabel = new JLabel("To: ");
           fromLabel = new JLabel("From: ");
           PosLabel = new JLabel("Postion: ");
           
           add(PosLabel);
           add(Pos);
           add(fromLabel);
           add(wrkSt);
           add(toLabel);
           add(wrkEd);
       	
           Nname = new JTextField(25);			//Entering Name
           nLabel = new JLabel("Name: ");
           add(nLabel);
           add(Nname);

           NId = new JTextField(10);			//Entering ID
           idLabel = new JLabel("ID: ");
           add(idLabel);
           add(NId);
           
           confirm = new JButton("Confirm");  //Confirm Button
           cancel = new JButton("Cancel");

           add(confirm);
           add(cancel);

           ButonHandler handler = new ButonHandler();

           confirm.addActionListener(handler);
           cancel.addActionListener(handler);
           Nname.addActionListener(handler);
           Pos.addActionListener(handler);
           wrkSt.addActionListener(handler);
           wrkEd.addActionListener(handler);
          

    	
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getnWorkingHrs() {
        return nWorkingHrs;
    }

    public void setnWorkingHrs(String nWorkingHrs) {
        this.nWorkingHrs = nWorkingHrs;
    }
    public String getdWorkingHrs2() {
        return nWorkingHrs2;
    }
    public void setdWorkingHrs2(String nWorkingHrs2) {
        this.nWorkingHrs2 = nWorkingHrs2;
    }

    private class ButonHandler implements ActionListener {
    	@Override
        public void actionPerformed(ActionEvent e) {
            int key = 0;

            try {

                if(e.getSource()==confirm){
                    if (NId.getText().length() == 0){
                        JOptionPane.showMessageDialog(null , "Must enter an ID");
                    }
                    else
                    setID(Integer.parseInt(NId.getText()));
                    key++;
                }

            } catch (NumberFormatException exp) {
                JOptionPane.showMessageDialog(null, "Error: You must enter an integer");
                }

                if(e.getSource()==confirm) {
                    if (Nname.getText().length() == 0 ){
                        JOptionPane.showMessageDialog(null , "Must enter a name");
                    }
                    else {
                        setName(Nname.getText());
                        key++;
                    }

                   
                    
                    if (key >= 2){
                        JOptionPane.showMessageDialog(null, "The Changes Have Been Saved");
                    }
                    else JOptionPane.showMessageDialog(null, "No changes have been made");

                }

                if(e.getSource()==cancel) {
                    System.exit(0);
                }

             
                if(e.getSource()==male) {
                    setGender("Male");
                    System.out.println(getGender());

                }
                if(e.getSource()==female) {
                    setGender("Female");
                    System.out.println(getGender());

                }
                if(e.getSource()== Pos ) {

                	setPosition((String) Pos.getSelectedItem());
                System.out.println(getPosition());
                }
                if(e.getSource()== wrkSt ) {

                	setnWorkingHrs((String) wrkSt.getSelectedItem());
                    System.out.println(getnWorkingHrs());
                    }
                if(e.getSource()== wrkEd ) {

                    setdWorkingHrs2((String) wrkEd.getSelectedItem());
                    System.out.println(getdWorkingHrs2());
                    }               
    }
    }
}
