package org.bridgeLabz.javaFileIO.service;
import org.bridgeLabz.javaFileIO.Data.EmployeePayrollData;
import java.io.IOException;
public class EmployeeService {
    /*
    @desc: Read and Write Employee Payroll data  to the console
    @throws: IO exception
     */
    public  void run(){
        System.out.println("Employee Payroll Service");
        EmployeePayrollData emp= new EmployeePayrollData();
        try {
            EmployeePayrollData emp2=emp.readFromConsole();
            System.out.println(emp.getEmpName());
            System.out.println(emp.getId());
            System.out.println(emp.getSalary());
            System.out.println(emp2.getEmpName()+" "+emp2.getId()+" "+emp2.getSalary());
            //writing to file
            String path="src/main/java/org/bridgeLabz/OutputFile.txt";
            emp.WriteinFile(emp2,path);
            // total entries of any directory
            emp.countEntry(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
