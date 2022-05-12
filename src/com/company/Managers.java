package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Managers extends Employees{
    JButton AddButton;
    JButton DeleteButton;


    public Managers() {
        setLayout(new GridLayout(1,2));
        ImageIcon gIcon = new ImageIcon(getClass().getClassLoader().getResource("com/company/manager.png"));
        ImageIcon dIcon = new ImageIcon(getClass().getClassLoader().getResource("com/company/minus_manager.png"));
        ImageIcon aIcon = new ImageIcon(getClass().getClassLoader().getResource("com/company/plus_manager.png"));
        AddButton  = new JButton("Add" , aIcon);
        AddButton.addActionListener(handler);

        DeleteButton = new JButton("Delete" , dIcon);
        DeleteButton.addActionListener(handler);

        this.setSize(500 , 500);




        this.add(AddButton);
        this.add(DeleteButton);
        this.setVisible(true);




    }

    ButonHandler handler = new ButonHandler();


    private class ButonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == AddButton){
                Madd g = new Madd();	//Open Form Method
                g.setTitle("Add Manager");
                g.setLayout(new GridLayout(4,4));
                g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                g.setSize(500,500);
                ImageIcon gIcon = new ImageIcon(getClass().getClassLoader().getResource("com/company/plus_manager.png"));
                g.setIconImage(gIcon.getImage());
                g.pack();
                g.setVisible(true);
                g.getContentPane().setBackground(new Color(255, 208, 198));
            }

            if (e.getSource() == DeleteButton){
                Mdelete g = new Mdelete();	//Open Form Method
                g.setTitle("Add Manager");
                g.setLayout(new GridLayout(4,4));
                g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                g.setSize(500,500);
                ImageIcon gIcon = new ImageIcon(getClass().getClassLoader().getResource("com/company/minus_manager.png"));
                g.setIconImage(gIcon.getImage());
                g.pack();
                g.setVisible(true);
                g.getContentPane().setBackground(new Color(255, 208, 198));
            }

        }
    }

}
