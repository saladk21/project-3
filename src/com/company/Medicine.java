package com.company;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Medicine extends JFrame {
    

    private int serialNum;
    private String mName;
    private int price;
    private int expiryDate;
    private int stock;
    private int qt;
    JTextField NameField;
    JTextField SNum;
    JTextField Sprice;
    JTextField Sdate;
    JLabel stockLabel;
    JLabel SerialLabel;
    JLabel NameLabel;
    JLabel PriceLabel;
    JLabel DateLabel;
    JRadioButton available;
    JRadioButton unavailable;
    ButtonGroup Bstock;
    JTextField quantity;
    JLabel quantityLabel;
    JButton confirm;
    JButton cancel;

    public Medicine(){
    	super("Hospital");
        setLayout(new FlowLayout());
        
        SNum = new JTextField(20);
        Sprice = new JTextField(5);
        Sdate = new JTextField(4);
        NameField = new JTextField(20);

        available =new JRadioButton("Available");		//Med Availability
        unavailable =new JRadioButton("Unavailable");

        stockLabel = new JLabel("Stock: ");
        NameLabel = new JLabel("Name: ");
        PriceLabel = new JLabel("Price: ");
        SerialLabel = new JLabel("Serial Number: ");
        DateLabel = new JLabel("Expiry Date: ");
        
        
        add(SerialLabel);
        add(SNum);
        add(NameLabel);
        add(NameField);
        add(stockLabel);
        add(available);
        add(unavailable);
        add(PriceLabel);
        add(Sprice);
        add(DateLabel);
        add(Sdate);
        
        Bstock = new ButtonGroup();			//Stock
        Bstock.add(available);
        Bstock.add(unavailable);

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
        SNum.addActionListener(handler);
        Sprice.addActionListener(handler);
        Sdate.addActionListener(handler);
        quantity.addActionListener(handler);
        NameField.addActionListener(handler);
       



    	
    }


    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getQuantity() {
        return qt;
    }

    public void setQuantity(int qt) {
        this.qt = qt;
    }
    
    private class ButonHandler implements ActionListener {

	public void actionPerformed(ActionEvent e) {
        int key = 0;

        try {

            if(e.getSource()==confirm){
                if (SNum.getText().length() == 0){
                    JOptionPane.showMessageDialog(null , "Must enter an Serial Number");
                }
                else
                setSerialNum(Integer.parseInt(SNum.getText()));
                key++;
            }
            if(e.getSource()==confirm){
                if (Sprice.getText().length() == 0){
                    JOptionPane.showMessageDialog(null , "Must enter a Price");
                }
                else
                setPrice(Integer.parseInt(Sprice.getText()));
                key++;
            }

            if(e.getSource()==confirm){
                if (Sdate.getText().length() == 0){
                    JOptionPane.showMessageDialog(null , "Must enter a Date");
                }
                else
                	setExpiryDate(Integer.parseInt(Sdate.getText()));
                key++;
            }
            if(e.getSource()==confirm){
                if (quantity.getText().length() == 0){
                    JOptionPane.showMessageDialog(null , "Must enter a Quantity");
                }
                else
                	setQuantity(Integer.parseInt(quantity.getText()));
                key++;
            }

        } catch (NumberFormatException exp) {
            JOptionPane.showMessageDialog(null, "Error: You must enter an integer");
            }
        if (NameField.getText().length() == 0){
            JOptionPane.showMessageDialog(null , "Must enter a Name");
        }
        else {
        	setmName(NameField.getText());
        key++;
        }
        

        
            if(e.getSource()==confirm) {
   
                
                if (key >= 5){
                    JOptionPane.showMessageDialog(null, "The Changes Have Been Saved");
                }
                else JOptionPane.showMessageDialog(null, "No changes have been made");

            }
            

            if(e.getSource()==cancel) {
                System.exit(0);
            }
}
}
}