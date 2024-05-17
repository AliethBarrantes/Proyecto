/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.model;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Usuario
 */
public class ArrayConsultation {
    private ArrayList<Consultation> listConsultations;
   private File csv;

    public ArrayConsultation() {
        listConsultations = new ArrayList<>();
        csv = new File("consultations.csv");
        
           if (csv.exists()) {
                try {
                    listConsultations = leer("consultations.csv");
                    escribir(listConsultations, "consultations.csv");
                    
                } catch (IOException ex) {
                    System.err.println("error");
                }
            } else {
                try {
                    csv.createNewFile();
                    escribir(listConsultations, "consultations.csv");
                } catch (IOException ex) {
                }
            }
    }
    
    ///////////////////////////////////////Métodos para controlar los botones////////////////////////////////////////////
    public Consultation buscar(int id) {
        for (Consultation consultation : listConsultations) {
            if (consultation.getId() == id) {
                return consultation;
            }
        }
        return null;
    }
    
    public String add(Consultation consultation) {
        if (buscar(consultation.getId()) == null) {
            listConsultations.add(consultation);
               try {
                                escribir(listConsultations, "consultations.csv");
                             return "La consulta ha sido registrada";
                        } catch (IOException ex) {
                            return "Error al escribir en el archivo";
                            
                        }
         
        }
        return "La consulta ya existe";
    }

    //////////////////////////////////////////Métodos escribir y leer////////////////////////////////////////////////////////////  
    public static ArrayList<Consultation> leer(String ruta) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(ruta))) {
            CsvToBean<Consultation> csvBean = new CsvToBeanBuilder<Consultation>(reader)
                    .withType(Consultation.class)
                    .build();
            return (ArrayList<Consultation>) csvBean.parse();
        }
    }
    
    public static void escribir(ArrayList<Consultation> consultations, String ruta) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(ruta))) {
            StatefulBeanToCsv<Consultation> stateCsv = new StatefulBeanToCsvBuilder<Consultation>(writer).build();
            try {
                stateCsv.write(consultations);
            } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            }
        }
    }
}
