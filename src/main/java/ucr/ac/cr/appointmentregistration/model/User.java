/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.model;

/**
 *
 * @author Camila PB
 */
public class User {
    private int identificationCard;
    private String password;

    public User() {
    }

    public User(int identificationCard, String password) {
        this.identificationCard = identificationCard;
        this.password = password;
    }

    public int getIdentificationCard() {
        return identificationCard;
    }

    public String getPassword() {
        return password;
    }

    public void setIdentificationCard(int identificationCard) {
        this.identificationCard = identificationCard;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
