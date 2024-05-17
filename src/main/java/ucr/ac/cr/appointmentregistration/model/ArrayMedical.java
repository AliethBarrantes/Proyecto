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
/**
 *
 * @author Usuario
 */
public class ArrayMedical {
    private ArrayList<Medical> listMedical;
    private File csv;

    public ArrayMedical() {
        listMedical = new ArrayList<>();
        csv = new File("medical.csv");

        // Leer datos desde el archivo CSV si existe
        if (csv.exists()) {
            try {
                listMedical = leer("medical.csv");
            } catch (IOException ex) {
               
            }
        } else {
            try {
               
                escribir(listMedical, "medical.csv");
            } catch (IOException ex) {
              
            }
        }
    }

    public void addMedical() {
        // Agregar médicos a la lista
        listMedical.add(new Medical("Dr. Juan Pérez", "Cardiología", 12345));
        listMedical.add(new Medical("Dra. María López", "Pediatría", 54321));
        listMedical.add(new Medical("Dr. Carlos González", "Neurología", 98765));
        listMedical.add(new Medical("Dra. Laura Martínez", "Dermatología", 45678));
        listMedical.add(new Medical("Dr. José Rodríguez", "Oftalmología", 13579));
        
        try {
                escribir(listMedical, "medical.csv");
                             
          } catch (IOException ex) {
                  System.err.println("error");
                            
            }
    }

    public static ArrayList<Medical> leer(String ruta) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(ruta))) {
            CsvToBean<Medical> csvBean = new CsvToBeanBuilder<Medical>(reader)
                    .withType(Medical.class)
                    .build();
            return (ArrayList<Medical>) csvBean.parse();
        }
    }

    public static void escribir(ArrayList<Medical> medicals, String ruta) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(ruta))) {
            StatefulBeanToCsv<Medical> stateCsv = new StatefulBeanToCsvBuilder<Medical>(writer).build();
            try {
                stateCsv.write(medicals);
            } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
                // Manejar la excepción apropiadamente
            }
        }
    }
}
