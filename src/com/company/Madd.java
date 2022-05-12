package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

    public class Madd extends Employees{

        JTextField Gname;
        JLabel nLabel;
        JLabel genderLabel;
        JRadioButton male;
        JRadioButton female;
        ButtonGroup gender;
        JTextField GId;
        JLabel idLabel;
        JButton confirm;
        JButton cancel;

        public Madd(){
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

            Gname = new JTextField(25);			//Entering Name
            nLabel = new JLabel("Name: ");
            add(nLabel);
            add(Gname);

            GId = new JTextField(10);			//Entering ID
            idLabel = new JLabel("ID: ");
            add(idLabel);
            add(GId);

            confirm = new JButton("Confirm");  //Confirm Button
            cancel = new JButton("Cancel");

            add(confirm);
            add(cancel);

            Madd.ButonHandler handler = new Madd.ButonHandler();

            confirm.addActionListener(handler);
            cancel.addActionListener(handler);
            Gname.addActionListener(handler);
            male.addActionListener(handler);
            female.addActionListener(handler);




        }



        CircularDoubleLinkedList Manager = new CircularDoubleLinkedList();

        public void removeEmp(Employees emp){
            if (Manager.getSize() == 0){
                System.out.println("There are no employees.");
            }
            else
                Manager.removeFirst();

        }

        public void hireEmp(Employees emp){
            Manager.addFirst(emp.getID() , emp.getName());
        }

        @Override
        public String toString() {
            return "Name: " + getName() + " ID: " + getID();
        }

        public void displayEmp(){
            Manager.forwardTraversing();
        }

        private class ButonHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                int key = 0;

                try {


                    if (e.getSource() == confirm) {
                        if (GId.getText().length() == 0) {
                            JOptionPane.showMessageDialog(null, "Must enter an ID");
                        } else
                            setID(Integer.parseInt(GId.getText()));
                        key++;
                    }

                } catch (NumberFormatException exp) {
                    JOptionPane.showMessageDialog(null, "Error: You must enter an integer");
                }

                if (e.getSource() == confirm) {
                    if (Gname.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Must enter a name");
                    } else {
                        setName(Gname.getText());
                        key++;
                    }


                    if (key == 2) {
                        String INSERT_1 = "INSERT INTO manager (M_ID , Firstname , gender ) VALUES ("+ getID() +" , '"+ getName() +"' , '" + getGender() + "')";

                        JOptionPane.showMessageDialog(null, "The Changes Have Been Saved");

                        try (Connection connection = DriverManager.getConnection("jdbc:derby:HOSPITALDATABASE", "APP", "APP");
                             Statement statement = connection.createStatement()) {

                            int INSERT1_Status = statement.executeUpdate(INSERT_1);

                            ResultSet rs=statement.executeQuery("SELECT M_ID FROM manager as A WHERE A.FIRSTNAME='"+getName()+"'");
                            rs.next();
                            rs.close();

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error in INSERT",JOptionPane.ERROR_MESSAGE);
                        }

                        JOptionPane.showMessageDialog(null, "The Changes Have Been Saved");
                    } else
                        JOptionPane.showMessageDialog(null, "No changes have been made");

                }

                if (e.getSource() == cancel) {
                    dispose();
                }


                if (e.getSource() == male) {
                    setGender("M");
                    System.out.println(getGender());

                }
                if (e.getSource() == female) {
                    setGender("F");
                    System.out.println(getGender());

                }

            }
        }

    }



