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
public class ArrayMedicines {
  private ArrayList<Medicine> arrayMedicines;
    private ArrayList<Medicine> arrayMedicineSelected;
    private File csv;

    public ArrayMedicines() {
        arrayMedicines = new ArrayList<>();
        arrayMedicineSelected = new ArrayList<>();
        csv = new File("medicines.csv");

        // Leer datos desde el archivo CSV si existe
        if (csv.exists()) {
            try {
                arrayMedicines = leer("medicines.csv");
            } catch (IOException ex) {
                Logger.getLogger(ArrayMedicines.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                escribir(arrayMedicines, "medicines.csv");
            } catch (IOException ex) {
                System.err.println("error");
            }
        }
    }
    
    public void addMedicines() {
        arrayMedicines.add(new Medicine("Aspirina", 2770));
        arrayMedicines.add(new Medicine("Omeprazol", 744));
        arrayMedicines.add(new Medicine("Paracetamol", 500));
        arrayMedicines.add(new Medicine("Amlodipina", 3555.65));
        arrayMedicines.add(new Medicine("Simvastatina", 34285.90));
        arrayMedicines.add(new Medicine("Acetaminofen", 500));
        arrayMedicines.add(new Medicine("Ibuprofeno", 800));
        arrayMedicines.add(new Medicine("Amoxicilina", 1200));
        arrayMedicines.add(new Medicine("Dipirona", 600));
        
        try {
            escribir(arrayMedicines, "medicines.csv");
        } catch (IOException ex) {
            Logger.getLogger(ArrayMedicines.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[][] getMatrixMedicine() {
        String[][] matrizMedicines = new String[arrayMedicines.size()][Medicine.TITLE_MEDICINES.length];
        for (int f = 0; f < matrizMedicines.length; f++) {
            for (int c = 0; c < matrizMedicines[f].length; c++) {
                matrizMedicines[f][c] = arrayMedicines.get(f).dateMedicine(c);
            }
        }
        return matrizMedicines;
    }
    
    public void addSelectedMedicine(Medicine medicine) {
        arrayMedicineSelected.add(medicine);
    }
    
    public String[][] getMatrixSelectedMedicine() {
        String[][] matrizSelectedMedicines = new String[arrayMedicineSelected.size()][Medicine.TITLE_MEDICINES.length];
        for (int f = 0; f < matrizSelectedMedicines.length; f++) {
            for (int c = 0; c < matrizSelectedMedicines[f].length; c++) {
                matrizSelectedMedicines[f][c] = arrayMedicineSelected.get(f).dateMedicine(c);
            }
        }
        return matrizSelectedMedicines;
    }

    //////////////////////////////////////////Métodos escribir y leer////////////////////////////////////////////////////////////  
    public static ArrayList<Medicine> leer(String ruta) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(ruta))) {
            CsvToBean<Medicine> csvBean = new CsvToBeanBuilder<Medicine>(reader)
                    .withType(Medicine.class)
                    .build();
            return (ArrayList<Medicine>) csvBean.parse();
        }
    }

    public static void escribir(ArrayList<Medicine> medicines, String ruta) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(ruta))) {
            StatefulBeanToCsv<Medicine> stateCsv = new StatefulBeanToCsvBuilder<Medicine>(writer).build();
            try {
                stateCsv.write(medicines);
            } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
                Logger.getLogger(ArrayMedicines.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
