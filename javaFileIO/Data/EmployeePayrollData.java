package org.bridgeLabz.javaFileIO.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class EmployeePayrollData {
    private int id;
    private String EmpName;
    private long salary;
   // getter fnc
    public int getId() {
        return id;
    }
    public long getSalary() {
        return salary;
    }
    public String getEmpName() {
        return EmpName;
    }
    //setter fnc
    public void setId(int id) {
        this.id = id;
    }
    public void setEmpName(String empName) {
        EmpName = empName;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
/*
@desc: read data from console
@throws IO Exception
 */
    public void readFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Id");
        id = Integer.parseInt(reader.readLine());
        System.out.println("Enter the name");
        EmpName= reader.readLine();
        System.out.println("Enter the salary");
        salary=Long.parseLong(reader.readLine());
    }
}
