package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Mdelete extends Employees {
    JLabel choose;

    String deletStatment = "";
    final String DATABASE_URL = "jdbc:derby:HOSPITALDATABASE";


    JRadioButton doc;
    JRadioButton patient;
    JRadioButton nurse;
    JRadioButton medicine;

    JLabel idLabel;
    JTextField idText;

    ButtonGroup group;

    JButton confirm;
    JButton cancel;

    int id;

    public int getId() {
        return id;
    }

    public void setId(int ID){
        this.id = ID;
    }

    public Mdelete(){
        super();
        setLayout(new FlowLayout());


        doc = new JRadioButton("Doctor");
        patient = new JRadioButton("Patient");
        nurse = new JRadioButton("Nurse");
        medicine = new JRadioButton("Medicine");

        group = new ButtonGroup();

        group.add(doc);
        group.add(patient);
        group.add(nurse);
        group.add(medicine);

        idLabel = new JLabel("ID:");
        add(idLabel);

        idText = new JTextField(25);
        add(idText);


        choose = new JLabel("Choose an option:");
        add(choose);

        add(doc);
        add(patient);
        add(nurse);
        add(medicine);



        confirm = new JButton("Confirm");  //Confirm Button
        cancel = new JButton("Cancel");

        add(confirm);
        add(cancel);

        ButonHandler handler = new ButonHandler();

        doc.addActionListener(handler);
        patient.addActionListener(handler);
        nurse.addActionListener(handler);
        medicine.addActionListener(handler);
        confirm.addActionListener(handler);
        cancel.addActionListener(handler);







    }




    private class ButonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == cancel){
                dispose();
            }



            if (e.getSource() == doc){
                setId(Integer.parseInt(idText.getText()));
                deletStatment = "delete from doctor where D_ID="+ getId();
            }

            if (e.getSource() == nurse){

                setId(Integer.parseInt(idText.getText()));
                deletStatment = "delete from nurse where N_ID ="+ getId();
            }

            if (e.getSource() == medicine){

                setId(Integer.parseInt(idText.getText()));
                deletStatment = "delete from medicine where serialNUmber ="+ getId();
            }

            if (e.getSource() == patient){

                setId(Integer.parseInt(idText.getText()));
                deletStatment = "delete from Patients where P_ID ="+ getId();
            }



                    if (e.getSource() == confirm) {


                        // try-with-resources to connect to and query the database
                        try(
                                Connection connection = DriverManager.getConnection(DATABASE_URL, "APP", "APP");
                                Statement statement = connection.createStatement();
                                Statement stmt = connection.createStatement())
                        {
                            //DELETING a doctor


                            stmt.executeUpdate(deletStatment);
                            JOptionPane.showMessageDialog(null,"Deleted successfully");

                        } // AutoCloseable objects' close methods are called now
                        catch (SQLException sqlException)
                        {
                            sqlException.printStackTrace();
                        }



                    }



        }
    }


}

