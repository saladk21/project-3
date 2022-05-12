package com.company;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Doctors extends Employees{

    public Doctors(String name, String gender, int ID) {
        super(name, gender, ID);
    }

 
    private String Dspecialize;
    private String dWorkingHrs;
    private String dWorkingHrs2;
    private int NumOfPatients;
    JTextField Dname;
    JLabel nLabel;
    JLabel genderLabel;
    JRadioButton male;
    JRadioButton female;
    ButtonGroup gender;
    JTextField nPatient;
    JLabel NumofPatientLabel;
    JLabel specLabel;
    JTextField DId;
    JLabel idLabel;
    String [] dWorkingHrsSt=
            {"8:00am","9:00am","10:00am","11:00am","12:00pm"};
    JComboBox<String>wrkSt;
    String [] dWorkingHrsEd=
            {"5:00pm","6:00pm","7:00pm","8:00pm","9:00pm","10:00pm","11:00pm","12:00am"};
    JComboBox<String>wrkEd;
    JLabel toLabel;
    JLabel fromLabel;
    String [] specialize =
            {"Anesthesiology","Dermatology","Neurology","Psychiatry","Surgery"};
    JComboBox<String>spec;
    JButton confirm;
    JButton cancel;
    
    
    

    public Doctors(){

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


        spec = new JComboBox<String>(specialize);		//List
        
        wrkSt = new JComboBox<String>(dWorkingHrsSt);	//Working Hour List
        wrkEd = new JComboBox<String>(dWorkingHrsEd);


        spec.setMaximumRowCount(5);
        wrkSt.setMaximumRowCount(5);
        wrkSt.setMaximumRowCount(8);

        toLabel = new JLabel("To: ");
        fromLabel = new JLabel("From: ");
        specLabel = new JLabel("Specialize");

        add(specLabel);
        add(spec);
        add(fromLabel);
        add(wrkSt);
        add(toLabel);
        add(wrkEd);
    	
        Dname = new JTextField(25);			//Entering Name
        nLabel = new JLabel("Name: ");
        add(nLabel);
        add(Dname);

        DId = new JTextField(10);			//Entering ID
        idLabel = new JLabel("ID: ");
        add(idLabel);
        add(DId);
        
        nPatient = new JTextField(2);
        NumofPatientLabel = new JLabel("Number of Patient: ");
        add(NumofPatientLabel);
        add(nPatient);

        confirm = new JButton("Confirm");  //Confirm Button
        cancel = new JButton("Cancel");

        add(confirm);
        add(cancel);

        ButonHandler handler = new ButonHandler();

        confirm.addActionListener(handler);
        cancel.addActionListener(handler);
        Dname.addActionListener(handler);
        spec.addActionListener(handler);
        wrkSt.addActionListener(handler);
        wrkEd.addActionListener(handler);
        nPatient.addActionListener(handler);
        male.addActionListener(handler);
        female.addActionListener(handler);



    	
    }


    public void dInfo(){
        System.out.println("Doctor Name : " + getName() + "Speciality : " + getSpecialize());
    }



    public String getSpecialize() {
        return Dspecialize;
    }
    

    public void setSpecialize(String Dspecialize) {
        this.Dspecialize = Dspecialize;
    }

    public String getdWorkingHrs() {
        return dWorkingHrs;
    }

    public void setdWorkingHrs(String dWorkingHrs) {
        this.dWorkingHrs = dWorkingHrs;
    }
    public String getdWorkingHrs2() {
        return dWorkingHrs2;
    }
    public void setdWorkingHrs2(String dWorkingHrs2) {
        this.dWorkingHrs2 = dWorkingHrs2;
    }

    public int getNumOfPatients() {
        return NumOfPatients;
    }

    public void setNumOfPatients(int numOfPatients) {
        NumOfPatients = numOfPatients;
    }




    private class ButonHandler implements ActionListener {
    	@Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==male) {
                setGender("M");
                System.out.println(getGender());

            }
            if(e.getSource()==female) {
                setGender("F");
                System.out.println(getGender());

            }
            if(e.getSource()== spec ) {

                setSpecialize((String) spec.getSelectedItem());
                System.out.println(getSpecialize());
            }
            if(e.getSource()== wrkSt ) {

                setdWorkingHrs((String) wrkSt.getSelectedItem());
                System.out.println(getdWorkingHrs());
            }
            if(e.getSource()== wrkEd ) {

                setdWorkingHrs2((String) wrkEd.getSelectedItem());
                System.out.println(getdWorkingHrs2());
            }

            int key = 0;

            try {

                if(e.getSource()==confirm){
                    if (DId.getText().length() == 0){
                        JOptionPane.showMessageDialog(null , "Must enter an ID");
                    }
                    else
                    setID(Integer.parseInt(DId.getText()));
                    key++;
                }

            } catch (NumberFormatException exp) {
                JOptionPane.showMessageDialog(null, "Error: You must enter an integer");
                }

                if(e.getSource()==confirm) {
                    if (Dname.getText().length() == 0 ){
                        JOptionPane.showMessageDialog(null , "Must enter a name");
                    }
                    else {
                        setName(Dname.getText());
                        key++;
                    }

                    if(e.getSource()==confirm) {
                        if (nPatient.getText().length() == 0 ){
                            JOptionPane.showMessageDialog(null , "Must enter a Number");
                        }
                        else {
                        	setNumOfPatients(Integer.parseInt(nPatient.getText()));
                            key++;
                        }



                    
                    if (key == 3){
                        String INSERT_1 = "INSERT INTO doctor (D_ID , Firstname , speciliaze , gender , fromworkingHours , toWorkingHours , NumOfPatients) VALUES ("+ getID() +" , '"+ getName() +"' , '"+ getSpecialize() +"'  , '" + getGender() + "' , '"+ getdWorkingHrs() +"' , '"+ getdWorkingHrs2() +"' , "+ getNumOfPatients() +")"; //

                        JOptionPane.showMessageDialog(null, "The Changes Have Been Saved");

                        try (Connection connection = DriverManager.getConnection("jdbc:derby:HOSPITALDATABASE", "APP", "APP");
                             Statement statement = connection.createStatement()) {

                            int INSERT1_Status = statement.executeUpdate(INSERT_1);

                            ResultSet rs=statement.executeQuery("SELECT D_ID FROM doctor as A WHERE A.FIRSTNAME='"+getName()+"'");
                            rs.next();
                            rs.close();

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error in INSERT",JOptionPane.ERROR_MESSAGE);
                        }

                    }
                    else JOptionPane.showMessageDialog(null, "No changes have been made");

                }

                if(e.getSource()==cancel) {
                    System.exit(0);
                }



    }
    }
}
}
