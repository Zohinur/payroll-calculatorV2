package com.pluralsight;

import java.io.*;

public class payrollCalculator {
    public static void main(String[] args) {
        String writingFile = "src/main/resources/PrintFile.csv";
        String file = "src/main/resources/employees.csv";
        //Creating an array to create each object for each of the workers
        Employee[] arrayE = new Employee[8];
        int index = 0;
        try (BufferedWriter writeBuffer = new BufferedWriter(new FileWriter(writingFile));
             FileReader reader = new FileReader(file);
             BufferedReader buff = new BufferedReader(reader);) {
            //Adding a file that'll display the result in the PrintFile csv
            writeBuffer.write("ID | Name | Hours | Pay Rate | Gross Pay");
            writeBuffer.newLine();
            //skipping the first line since it is just example
            buff.readLine();
            String line;
            while ((line = buff.readLine()) != null) {
                System.out.println("Line of each: " + line);
                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);
                //Creating the object in the array
                arrayE[index] = new Employee(id, hoursWorked, name, payRate);
                index++;
                double grossPay = arrayE[index - 1].getGrossPay();
                writeBuffer.write(id + "| " + name + "| " + hoursWorked + "| " + payRate + "| " + grossPay);
                writeBuffer.newLine();
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Using a for loop to print out the result
        for (Employee e : arrayE) {
            System.out.printf("%s,ID- %d Gross pay: %.2f  \n", e.getName(), e.getId(), e.getGrossPay());
        }
    }
}
