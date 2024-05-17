/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Consultation {
    private ArrayList<Medicine> arrayMedicineAdd;
    private double priceConsultation;
    private String observations;
    private int id;

    public Consultation() {
    
    }

    public Consultation(int id, double priceConsultation, String observations) {
        this.id=id;
        this.priceConsultation = priceConsultation;
        this.observations = observations;
        this.arrayMedicineAdd= new ArrayList<>();
        
    }

    public double getPriceConsultation() {
        return priceConsultation;
    }

    public void setPriceConsultation(double priceConsultation) {
        this.priceConsultation = priceConsultation;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void addMedicine(Medicine medicine){
        this.arrayMedicineAdd.add(medicine);
    }
    
    public void removeMedicine(Medicine medicine){
        this.arrayMedicineAdd.remove(medicine);
    }
    
    public ArrayList<Medicine> getArrayMedicineAdd(){
        return arrayMedicineAdd;
    }
    
    public double getTotalCost(){
       double totalCost=0;
        totalCost+=this.getPriceConsultation();
        for(int i=0; i<arrayMedicineAdd.size(); i++){
            totalCost+=(arrayMedicineAdd.get(i).getPriceMedicine()*arrayMedicineAdd.get(i).getAmountMedicine());
        }
        return totalCost;
    }
    
    
    
    
    
    
    
    
    
    

}