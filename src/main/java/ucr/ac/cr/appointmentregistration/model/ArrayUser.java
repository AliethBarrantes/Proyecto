/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.appointmentregistration.model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Camila PB
 */
public class ArrayUser {
    private ArrayList <User> listUser;

    public ArrayUser() {
        getArrayUser();
        
    }
    
    public void getArrayUser(){
        this.listUser = new ArrayList<>();
        
        JSONFile jsonFile= new JSONFile("User_Registration.json");
       
        JSONArray jsonArray = jsonFile.read();//Llamamos al metodo leer de JSON
       
        for(Object object: jsonArray){
                JSONObject jsonObject = (JSONObject) object;
                
                
                Long identificationLong = (Long) jsonObject.get("Identification Card");
                int identification = identificationLong.intValue();
                String password = (String) jsonObject.get("Password");
                
                User newUser = new User(identification, password);
                listUser.add(newUser);
            }
        
    }
    
    public void addUser(User user){
        if((user!= null) && (searchIdentificationCard(user) == null) && (searchPassword(user) == null)){
              
                JSONFile jsonFile = new JSONFile("User_Registration.json");
                JSONObject jsonObject = new JSONObject();
                
                jsonObject.put("Identification Card",user.getIdentificationCard());
                jsonObject.put("Password",user.getPassword());
                
                //Los puede cargar sin el orden del constructor, ya que lo que esta haciendo es cargandolo 
                jsonFile.writer(jsonObject);
                 
       }
        
    }
   
    
    //Este metodo se va a encargar de buscar para verificar que la contraseña no sea igual a otra. 
    public User searchPassword(User userSearch){
        for(User user: listUser){
            if(user.getPassword().equalsIgnoreCase(userSearch.getPassword())){
                return user;
            }
        }
        return null;
    }
    
    //Este metodo verifica que no se este equivocando de numero de cedula, o que no exista otra igual
    public User searchIdentificationCard(User userSearch){
        getArrayUser();
        for(User user: listUser){
            if(user.getIdentificationCard() == userSearch.getIdentificationCard()){
                return user;
            }
        }
        return null;
    }
    
   
    
    



                
    
    
    
    
    
}
