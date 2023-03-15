package com.example.lab2;

public class active_PersonalSalary {
    private String FullName;
    private long Salary;
    public active_PersonalSalary(){}
    public active_PersonalSalary(String fullName, long salary) {
        FullName = fullName;
        Salary = salary;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public long getSalary() {
        return Salary;
    }

    public void setSalary(long salary) {
        Salary = salary;
    }

    public String toString(){
        return "Full Name: "+ FullName +"\n"+"Net Salary: " + Salary;
    }
}
