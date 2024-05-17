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
 * @author Darian
 */
public class JSONFileBill {
    private String fileName;
    private JSONObject jsonObject; 
    private JSONArray jsonArray;
    private JSONParser parser;

    public JSONFileBill(String fileName) {
        
        this.fileName = fileName;
        this.jsonObject = new JSONObject();
        this.jsonArray = new JSONArray();  
    }
    
    //Leer cualquier archivo JSON
    public JSONArray readJSON(){
        this.parser = new JSONParser();
        try(FileReader reader = new FileReader(fileName)) {
            Object obj = this.parser.parse(reader);
            this.jsonArray = (JSONArray) obj;
        } catch (IOException| ParseException e) {
            System.err.println("No existing file or new file will be create.");
        }
        
        return this.jsonArray;
    }
    
    //Escribir objeto por objeto
    public void writer(JSONObject jsonObject){
        this.jsonArray = this.readJSON();
        this.jsonArray.add(jsonObject);
        try(FileWriter fileWriter = new FileWriter(fileName)){
            fileWriter.write(this.jsonArray.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        }
    }
    
    //Escribir un JSONArray
    public void writerArray(JSONArray jsonArray){
        try(FileWriter fileWriter = new FileWriter(fileName)){
            fileWriter.write(this.jsonArray.toJSONString());
            fileWriter.flush();
            fileWriter.close();
            
        } catch (IOException e) {
            System.err.println("No posible read.");
        }
    }
}
