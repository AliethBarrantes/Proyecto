/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.model;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Darian
 */
public class ArrayBill {
    
    private String message;
    private ArrayList<Bill> listBills;
    
    private JSONFileBill jsonFile;
    private final String fileName = "bills.json";

    public ArrayBill() {
        this.message = "NA";
        this.listBills = new ArrayList<>();
        this.jsonFile = new JSONFileBill(fileName);
    }
    
    public String addBill(Bill bill) {
        if (bill != null) {
            if (searchIndex(bill.getId()) == -1) {
                
                listBills.add(bill);
                jsonFile.writerArray((JSONArray) listBills);
                message = "Invoice was added successfully";
            } else {
                message = "An invoice with the entered ID has already been registered";
            }
        } else {
            message = "Error adding";
        }
        return message;
    }
    
    public String deleteBill(int id) {
        jsonFile.readJSON();
        
        int position = searchIndex(id);
        if (position != -1) {
            listBills.remove(position);
            jsonFile.writerArray((JSONArray) listBills);
            message = "The invoice was successfully deleted";
        } else {
            message = "The invoice you want to delete is not registered";
        }
        return message;
    }
    
    public Bill searchBill(int id) {
        jsonFile.readJSON();
        
        int position = searchIndex(id);
        if (position != -1) {
            return listBills.get(position);
        }
        return null;
    }
    
    public int searchIndex(int id) {
        
        jsonFile.readJSON();
        
        for (int i = 0; i < listBills.size(); i++) {
            if (listBills.get(i) != null) {
                if (listBills.get(i).getId() == id) {
                    return i;
                }
            }
        }
        return -1;
    }
    
   public String modifyBill(Bill bill) {
       jsonFile.readJSON();
        
        int position = searchIndex(bill.getId());
        if (position != -1) {
            listBills.set(position, bill);
            jsonFile.writerArray((JSONArray) listBills);
            message = "The invoice was successfully modified";
        } else {
            message = "The invoice you want to change is not registered";
        }
        return message;
    }

    public String[][] getDatosMatriz() {
        jsonFile.readJSON();
        
        String matrizDatos[][] = new String[listBills.size()][6];
        for (int i = 0; i < listBills.size(); i++) {
            matrizDatos[i][0] = String.valueOf(listBills.get(i).getId());
            matrizDatos[i][1] = listBills.get(i).getArea();
            matrizDatos[i][2] = String.valueOf(listBills.get(i).getMedicine());
            matrizDatos[i][3] = listBills.get(i).getDoctor();
            matrizDatos[i][4] = String.valueOf(listBills.get(i).getTotal());
            matrizDatos[i][5] = listBills.get(i).getIndication();
        }
        return matrizDatos;
    }

    
}
