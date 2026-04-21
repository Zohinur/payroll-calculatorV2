package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class payrollCalculator {
    public static void main(String[] args) {
        String file = "src/main/resources/employees.csv";

        try{
            FileReader reader = new FileReader(file);
            BufferedReader buff = new BufferedReader(reader);
            buff.readLine();
            String line;
            while((line = buff.readLine()) !=null) {
                System.out.println("Line of each: " + line);
                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);
                Employee employee = new Employee();
                employee.setId(id);
                employee.setName("ashjdjsa");
                employee.setHoursWorked(hoursWorked);
                employee.setPayRate(payRate);
                System.out.println(employee.getHoursWorked());
                System.out.println("the gross pay is " + employee.getGrossPay());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
