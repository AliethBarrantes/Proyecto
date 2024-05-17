/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.model;

/**
 *
 * @author Darian
 */
public class Bill {
    private int id;
    private String area;
    private Medicine medicine;
    private String doctor;
    private double total;
    private String indication;

    public Bill() {
        id = 0;
        area = "";
        medicine = new Medicine();
        doctor = "";
        total = 0;
        indication = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", area=" + area + ", medicine=" + medicine + ", doctor=" + doctor + ", total=" + total + ", indication=" + indication + '}';
    }
    
}
