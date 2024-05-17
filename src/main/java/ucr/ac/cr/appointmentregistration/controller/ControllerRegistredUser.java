/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ucr.ac.cr.appointmentregistration.model.ArrayUser;
import ucr.ac.cr.appointmentregistration.model.User;
import ucr.ac.cr.appointmentregistration.view.GUIPatientData;
import ucr.ac.cr.appointmentregistration.view.GUIRegisterUser;

/**
 *
 * @author Camila PB
 */
public class ControllerRegistredUser implements ActionListener{
    private GUIRegisterUser guiRegisterUser;
    private ArrayUser arrayUser;
    private GUIPatientData guiPatientData;
    
    public ControllerRegistredUser(ArrayUser arrayUsers) {
        this.guiRegisterUser = new GUIRegisterUser();
        this.guiPatientData = new GUIPatientData();
        this.arrayUser = arrayUsers;
        this.guiRegisterUser.Listen(this);
        this.guiRegisterUser.setVisible(true);
    }
    
    public boolean validationDato(User userValidate){
        if(userValidate.getIdentificationCard() == 0){
            JOptionPane.showInternalMessageDialog(null,"You must fill out all fields","Incomplete fields",JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (userValidate.getPassword().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null,"You must fill out all fields","Incomplete fields ",JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         switch (e.getActionCommand()) {
            case "Add":
                User user = guiRegisterUser.getUser();
                
                if(user != null && user.getIdentificationCard() != -1){
                    if(validationDato(user)){
                        arrayUser.addUser(user);
                        guiRegisterUser.clean();
                        guiPatientData.setVisible(true);
                    }
                
                }else{
                    JOptionPane.showInternalMessageDialog(null,"You must fill out all fields","Incomplete fields ",JOptionPane.ERROR_MESSAGE);
                }
                
                break;
                
            case "Close":
                guiRegisterUser.dispose();
                break;
                 
            
         
         }
    }
    
}
