/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import ucr.ac.cr.appointmentregistration.model.ArrayUser;
import ucr.ac.cr.appointmentregistration.model.User;
import ucr.ac.cr.appointmentregistration.view.GUIPatientData;
import ucr.ac.cr.appointmentregistration.view.GUIUser;

/**
 *
 * @author Camila PB
 */
public class ControllerUser implements ActionListener, MouseListener {
    private GUIUser guiUser;
    private ArrayUser arrayUser;
    private ControllerRegistredUser controller;
    private GUIPatientData guiPatientData;
    private User user;
    
    
    public ControllerUser() {
        this.guiUser = new GUIUser();
        this.arrayUser = new ArrayUser();
        this.guiUser.Listen(this);
        this.guiUser.ListenLabel(this);
        this.guiUser.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         switch (e.getActionCommand()) {
            case "LogIn":
                this.user = guiUser.getUser();
                System.out.print("LogIn");
                if(user != null && user.getIdentificationCard() != -1){
                    if (arrayUser.searchIdentificationCard(user) != null) {
                        //Si es paciente
                        System.out.print("paciente");
                        //Gui citaMedica
                        guiUser.clean();

                    } else {
                        System.out.print("Medico");
                        //Si es medico
                        guiUser.clean();
                    }
                }else{
                    JOptionPane.showInternalMessageDialog(null, "An error occurred in the recorded data", "Access error", JOptionPane.ERROR_MESSAGE);
                }
                
                break;
                
            case "SignUp":
                controller = new ControllerRegistredUser(arrayUser);
                
                
                break;
                 
            case "Exit":
                System.exit(0);
                break;
         
         }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        /*Aqui queriamos hacer 2 cosas. La primera seria unas configuraciones que permitan editar la contraseña,
        pero no el mumero de cedula, la otra cosa seria instrucciones de uso*/
        if(e.getSource().toString().equalsIgnoreCase(guiUser.getLabel())){
        
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
