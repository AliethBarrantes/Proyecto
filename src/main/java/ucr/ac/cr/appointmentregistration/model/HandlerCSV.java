/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.model;

/**
 *
 * @author Roxana
 */
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandlerCSV {

    public HandlerCSV() {

    }

    // Método para leer objetos Person desde un archivo CSV
    public static ArrayList<Patient> readCSV(String rutaArchivo) throws IOException {
        File csvFile = new File(rutaArchivo);
        if (!csvFile.exists()) {
            csvFile.createNewFile();
        }
        try (CSVReader reader = new CSVReader(new FileReader(rutaArchivo))) {
            // Configurar el lector CSV
            CsvToBean<Patient> csvToBean = new CsvToBeanBuilder<Patient>(reader)
                    .withType(Patient.class)
                    .build();

            // Leer las personas del archivo CSV
            return (ArrayList<Patient>) csvToBean.parse();
        } catch (FileNotFoundException e) {
            System.err.println("Error: El archivo " + rutaArchivo + " no existe.");
            FileReader fileReader = new FileReader(rutaArchivo);
            return new ArrayList<>();  // Devuelve una lista vacía
        }
    }

    // Método para escribir una lista de objetos Person en un archivo CSV
    public static void writerCSV(ArrayList<Patient> personas, String rutaArchivo) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(rutaArchivo))) {
            // Configurar el escritor CSV
            StatefulBeanToCsv<Patient> beanToCsv = new StatefulBeanToCsvBuilder<Patient>(writer).build();

            try {
                // Escribir la lista de personas en el archivo CSV
                beanToCsv.write(personas);
            } catch (CsvDataTypeMismatchException ex) {

            } catch (CsvRequiredFieldEmptyException ex) {

            }
        }
    }

}

