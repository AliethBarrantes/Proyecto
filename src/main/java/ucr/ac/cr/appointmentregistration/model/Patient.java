/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.model;

/**
 *
 * @author Roxana
 */
public class Patient {
    private int id;
    private String name;
    private String surName;
    private String secondSurName;
    private String home;
    private int phoneNumberUno;
    private int phoneNumberDos;
    private String bloodType;
    private String birthday;
    private String province;
    private String nationality;
    private String civilStatus;
    private String occupation;
    private String email;

    public Patient() {
    }

    public Patient(int id, String name, String surName, String secondSurName, String home, int phoneNumberUno, int phoneNumberDos, String bloodType, String birthday, String province, String nationality, String civilStatus, String occupation, String email) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.secondSurName = secondSurName;
        this.home = home;
        this.phoneNumberUno = phoneNumberUno;
        this.phoneNumberDos = phoneNumberDos;
        this.bloodType = bloodType;
        this.birthday = birthday;
        this.province = province;
        this.nationality = nationality;
        this.civilStatus = civilStatus;
        this.occupation = occupation;
        this.email = email;
    }

    public int getId() {
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSecondSurName() {
        return secondSurName;
    }

    public void setSecondSurName(String secondSurName) {
        this.secondSurName = secondSurName;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public int getPhoneNumberUno() {
        return phoneNumberUno;
    }

    public void setPhoneNumberUno(int phoneNumberUno) {
        this.phoneNumberUno = phoneNumberUno;
    }

    public int getPhoneNumberDos() {
        return phoneNumberDos;
    }

    public void setPhoneNumberDos(int phoneNumberDos) {
        this.phoneNumberDos = phoneNumberDos;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", name=" + name + ", surName=" + surName 
                +", secondSurName=" + secondSurName + ", home=" + home + ", phoneNumberUno=" 
                +phoneNumberUno + ", phoneNumberDos=" + phoneNumberDos + ", bloodType="+bloodType
                + ", birthday=" + birthday + ", province=" + province 
                + ", nationality=" + nationality + ", civilStatus=" + civilStatus + ","
                + " occupation=" + occupation + ", email=" + email + '}';
    }
    
     
}
