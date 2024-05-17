/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static ucr.ac.cr.appointmentregistration.model.HandlerCSV.writerCSV;
import static ucr.ac.cr.appointmentregistration.model.HandlerCSV.readCSV;

/**
 *
 * @author Roxana
 */
public class ArrayPatient {
    private ArrayList<Patient> arrayListPatient;

    public ArrayPatient() {
        try{
            File file = new File("patient.csv");
            if(!file.exists()){
                file.createNewFile();
            }
            
            
            this.arrayListPatient = readCSV( "patient.csv");
            writerCSV(arrayListPatient, "patient.csv");
            
            
        }catch(IOException ex){
            System.err.println("Error to writer");
        }
    }
    
    public boolean searchBoolean(int id){
        for (Patient patient : arrayListPatient) {
            if(patient.getId()==id){
                return true;
            }
        }
        return false;
    }
    
    public Patient search(int id){
        for (Patient patient : arrayListPatient) {
            if(patient.getId()==id){
                return patient;
            }
        }
        return null;
    }
    
    public String add(Patient patient){
        if(!searchBoolean(patient.getId())){
            try{
                this.arrayListPatient.add(patient);
                
                writerCSV(arrayListPatient, "patient.csv");
                return "the patient was added correctly";
                
            }catch(IOException ex){
                System.err.println("error when writing patient");
            }
            
        }   
       return"the patient already exists";
    }
//    
//    public String delete(Patient deletePatient){
//        if(!searchBoolean(deletePatient.getId())){
//            try{
//                this.arrayListPatient.remove(this.search(deletePatient.getId()));
//
//                writerCSV(arrayListPatient, "patient.csv");
//                return "the patient was removed correctly";
//                
//            }catch(IOException ex){
//                 System.err.println("error when writing patient");
//            }
//        }
//        return "There is no patient with this ID";
//    }
   public String editPatient(Patient editPatient){
       for (int i = 0; i < this.arrayListPatient.size(); i++) {
          if(this.arrayListPatient.get(i).getId() == editPatient.getId()){
             try{
                this.arrayListPatient.set(i, editPatient);
                
                writerCSV(this.arrayListPatient,"patient.csv");
                return"The patient was edited correctly";
                
             }catch(IOException ex){
                 System.err.println("Error when editing patient data");
             }
          } 
       }
       return "No patient was found with this ID";
   }
 
 
}
