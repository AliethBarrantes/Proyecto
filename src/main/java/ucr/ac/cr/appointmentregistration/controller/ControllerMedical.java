/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.controller;

import View.GUIMedicalMainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.appointmentregistration.model.ArrayMedicines;
import ucr.ac.cr.appointmentregistration.model.Medicine;
import ucr.ac.cr.appointmentregistration.view.GUIMedicalPendingAppointments;
import ucr.ac.cr.appointmentregistration.view.PanelMedicines;

/**
 *
 * @author Usuario
 */
public class ControllerMedical implements ActionListener {
    private GUIMedicalMainMenu guiMedicalMenu;
    private GUIMedicalPendingAppointments guiMedicalPendingAppointments;
    private PanelMedicines panelMedicines;
    private ArrayMedicines arrayMedicines;
    public ControllerMedical(ArrayMedicines arrayMedicines) {
        guiMedicalMenu= new GUIMedicalMainMenu ();
        this.arrayMedicines=arrayMedicines;
        arrayMedicines.addMedicines();
        this.guiMedicalMenu.listenButton(this);
        guiMedicalMenu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "RegistrarCitas":
                guiMedicalPendingAppointments= new GUIMedicalPendingAppointments();
                panelMedicines = guiMedicalPendingAppointments.panelMedicines();
                String[][] matrizObtenida= arrayMedicines.getMatrixMedicine();
                panelMedicines.setDataTable(matrizObtenida, Medicine.TITLE_MEDICINES);
                guiMedicalPendingAppointments.setVisible(true);
                break;
        }
    }
    
    
}
