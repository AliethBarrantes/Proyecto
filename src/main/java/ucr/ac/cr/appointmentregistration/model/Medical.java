/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.model;

/**
 *
 * @author Usuario
 */
public class Medical {
    
    private String nombre;
    private String area;
    private int cedula;
    
    public Medical(String nombre, String area, int cedula) {
        this.nombre = nombre;
        this.area = area;
        this.cedula = cedula;
    }
    
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getArea() {
        return area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }
    
    public int getCedula() {
        return cedula;
    }
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
}
