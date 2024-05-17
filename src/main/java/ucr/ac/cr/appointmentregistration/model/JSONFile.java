/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Camila PB
 */

//Esta clase lee y escribe en nuestro archivoJSON
public class JSONFile {
    private String fileName;
    private JSONObject jsonObject;
    private JSONArray jsonArray; 
    private JSONParser parser;

    public JSONFile(String fileName) {
        this.fileName = fileName;
        this.jsonObject = new JSONObject();
        this.jsonArray= new JSONArray();
    }
    
   
    public JSONArray read(){
        this.parser = new JSONParser();
        try(FileReader reader = new FileReader(fileName)){
            Object obj= this.parser.parse(reader);
            this.jsonArray=(JSONArray) obj;
        }catch(IOException | ParseException e){
            System.err.println("No existing file or new file will be create");
        }
        return this.jsonArray;
    }
    
    public void writer (JSONObject jsonObject){
        this.jsonArray= this.read();
        this.jsonArray.add(jsonObject);
        try(FileWriter fileWriter= new FileWriter(fileName)){
            fileWriter. write(this.read().toJSONString());
            fileWriter.flush();
            fileWriter.close();
        }catch(IOException e){
            System.err.println("ERROR  WRITER");
        }
    }
   
}
