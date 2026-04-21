package com.pluralsight;

public class Employee {
    private int id;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee( int id, double hoursWorked, String name, double payRate) {
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.name = name;
        this.id = id;
    }

    public int getId(){
        return id;
    }
    public void setId(int id) {
    this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getHoursWorked(){
        return hoursWorked;
    }
    public void setHoursWorked(double hoursWorked){
        this.hoursWorked = hoursWorked;
    }
    public double getPayRate(){
        return payRate;
    }
    public void setPayRate(double payRate){
        this.payRate = payRate;
    }
    public double getGrossPay() {
        return hoursWorked * payRate;
    }
}
