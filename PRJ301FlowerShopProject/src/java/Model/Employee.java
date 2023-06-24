/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Employee {
    private String empId;
    private String empPassword;
    private String empPhone;
    private String empAddress;
    private String empFirstName;
    private String empLastName;
    private String empGender;
    private String empEmail;
    private String empRole;

    public Employee() {
    }

    public Employee(String empId, String empPassword, String empPhone, String empAddress, String empFirstName, String empLastName, String empGender, String empEmail, String empRole) {
        this.empId = empId;
        this.empPassword = empPassword;
        this.empPhone = empPhone;
        this.empAddress = empAddress;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empGender = empGender;
        this.empEmail = empEmail;
        this.empRole = empRole;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }
    
}
