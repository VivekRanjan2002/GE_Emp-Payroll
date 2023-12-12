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
            emp.readFromConsole();
            System.out.println(emp.getEmpName());
            System.out.println(emp.getId());
            System.out.println(emp.getSalary());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
