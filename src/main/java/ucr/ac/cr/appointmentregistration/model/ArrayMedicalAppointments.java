/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Camila PB
 */
public class ArrayMedicalAppointments {
    private ArrayList<MedicalAppointments> listMedicalAppointment;
    private ArrayList<String> timeAppointments;
    public static String[] TITLE_DAYS = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
  
    public ArrayMedicalAppointments() {
       this.timeAppointments = new ArrayList<>();
       timeAppointment();
       getArrayMedicalAppointments();
       
        
    }
    
    public void getArrayMedicalAppointments(){
        this.listMedicalAppointment = new ArrayList<>();
        
        JSONFile jsonFile= new JSONFile("Medical_Appointment.json");
       
        JSONArray jsonArray = jsonFile.read();//Llamamos al metodo leer de JSON
       
        for(Object object: jsonArray){
            JSONObject jsonObject = (JSONObject) object;
              
            Long identificationLong = (Long) jsonObject.get("Identification Card");
            int identification = identificationLong.intValue();
            String area = (String) jsonObject.get("Area");
            String day = (String) jsonObject.get("Day");
            String appointmentTime = (String) jsonObject.get("Appointment Time");
                
            MedicalAppointments newMedicalAppointments = new MedicalAppointments(identification,area,day, appointmentTime);
            listMedicalAppointment.add(newMedicalAppointments);
        }
        
    }
    
    public void addMedicalAppointment(MedicalAppointments medical){
        if(medical!= null && searchIdentificationCard(medical) == null){
              
                JSONFile jsonFile = new JSONFile("Medical_Appointment.json");
                JSONObject jsonObject = new JSONObject();
                
                jsonObject.put("Identification Card",medical.getIdentificationCard());
                jsonObject.put("Area",medical.getArea());
                 jsonObject.put("Area",medical.getDay());
                jsonObject.put("Appointment Time",medical.getAppointmentTime());
                
                //Los puede cargar sin el orden del constructor, ya que lo que esta haciendo es cargandolo 
                jsonFile.writer(jsonObject);
                 
       }
    }
   
    //Este metodo verifica que no se este equivocando de numero de cedula, o que no exista otra igual
    public MedicalAppointments searchIdentificationCard(MedicalAppointments medicalSearch){
        for(MedicalAppointments medical: listMedicalAppointment){
            if(medical.getIdentificationCard() == medicalSearch.getIdentificationCard()){
                return medical;
            }
        }
        return null;
    }
    
    //Metodo que devuelve un arreglo con las citas agregadas por dia y hora
    public String[] getComboAppointment(){
        String[] idsList = new String[this.listMedicalAppointment.size()];
        for (int i = 0; i < this.listMedicalAppointment.size(); i++) {
            idsList[i] = this.listMedicalAppointment.get(i).getDay()+ "-"+ this.listMedicalAppointment.get(i).getAppointmentTime();
        }
        
        return idsList;
    }
    
    //Metodo que agrega las horas a la tabla
    public void timeAppointment(){
        timeAppointments.add("8:00");
        timeAppointments.add("8:30");
        timeAppointments.add("9:00");
        timeAppointments.add("9:30");
        timeAppointments.add("10:00");
        timeAppointments.add("10:30");
        timeAppointments.add("11:00");
        timeAppointments.add("11:30");
        timeAppointments.add("1:00");
        timeAppointments.add("1:30");
        timeAppointments.add("2:00");
        timeAppointments.add("2:30");
        timeAppointments.add("3:00");
        timeAppointments.add("3:30");
        timeAppointments.add("4:00");
        timeAppointments.add("4:30");
        timeAppointments.add("5:00");
        timeAppointments.add("5:30");
        timeAppointments.add("6:00");
        timeAppointments.add("6:30");
        timeAppointments.add("7:00");
    }

   
    //Metdo que devuelve la matriz para las horas de las citas
    
   
    
    
 
    
    
    
}
