package com.company;

import javax.swing.*;

public abstract class Employees extends JFrame {
	
    public Employees(){ super("Hospital");}
    

    public Employees(String name, String gender, int ID) {
        Name = name;
        this.gender = gender;
        this.ID = ID;
    }

    private String Name;
    private String gender;
    private int ID;


    void info(String Name ,int ID ,String gender){

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
