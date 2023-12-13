package org.bridgeLabz.javaFileIO.Data;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmployeePayrollData {
    private int id;
    private String EmpName;
    private long salary;
    public EmployeePayrollData(){
        id=0;
        EmpName=null;
        salary=0;
    }
    public EmployeePayrollData(int id,String EmpName,long salary){
        this.id=id;
        this.EmpName=EmpName;
        this.salary=salary;
    }
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
@return: EmployeePayrollData with instance variable as values given by user
@throws IO Exception
 */
    public EmployeePayrollData readFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Id");
        id = Integer.parseInt(reader.readLine());
        System.out.println("Enter the name");
        EmpName= reader.readLine();
        System.out.println("Enter the salary");
        salary=Long.parseLong(reader.readLine());
        EmployeePayrollData emp= new EmployeePayrollData(id,EmpName,salary);
        return emp;
    }
    /*
    @desc: write employeePayroll Object instance variables into file which have path as
           pathName
    @params: EmployeePayrollData object and String as pathName
    @throws: IOException
     */
    public void WriteinFile(EmployeePayrollData emp, String pathName) throws IOException{

        FileWriter writer= new FileWriter(pathName);
        writer.write("id: " + emp.getId());
        writer.write("name: "+emp.getEmpName());
        writer.write("salary: "+emp.getSalary());
    }
    /*
    @desc:compute the total no. of entries of any directory
    @params: filePath as String
    @return: no. of entries
    @throws:IOException
    */
    public int  countEntry(String filePath) throws IOException{
        Path path= Paths.get(filePath);
        int cntEntry= (int) Files.lines(path).count();
        System.out.println("Number of Entries are: "+cntEntry);
        return cntEntry;
    }
}
