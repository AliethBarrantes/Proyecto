/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.model;

/**
 *
 * @author Camila PB
 */
public class MedicalAppointments {
    private int identificationCard;
    private String area;
    private String day;
    private String appointmentTime;

    public MedicalAppointments() {
    }

    public MedicalAppointments(int identificationCard, String area, String day, String appointmentTime) {
        this.identificationCard = identificationCard;
        this.area = area;
        this.day = day;
        this.appointmentTime = appointmentTime;
    }

    public int getIdentificationCard() {
        return identificationCard;
    }

    public String getArea() {
        return area;
    }

    public String getDay() {
        return day;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setIdentificationCard(int identificationCard) {
        this.identificationCard = identificationCard;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    
    
    
}

    