/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noemalife.galileo.servlet;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Juan
 */
public class GetAudioData {

//    public void main(String args[]) throws JSONException{
//        GetAudioData ad = new GetAudioData();
//        ad.generateData();
//    }
    ArrayList<JSONObject> seriesOcultas = new ArrayList<JSONObject>();
    
    public String generateData(String jsonp, String sVaod, String sVaoi, String sVood, String sVooi) throws JSONException {
        JSONObject finalJsonObject = new JSONObject();
        JSONArray charDataArray = new JSONArray();
        JSONObject serieVAODObject = new JSONObject();
        JSONObject serieVAOIObject = new JSONObject();
        JSONObject serieVOODObject = new JSONObject();
        JSONObject serieVOOIObject = new JSONObject();
        
        
        
        JSONArray dataVaodArrayString = parseCoordinatesString(sVaod, "VAOD");
        seriesOcultas.add(crearSerieOculto(dataVaodArrayString));
        JSONArray dataVaodArrayInteger = parseCoordinatesInteger(dataVaodArrayString);
        
        JSONArray dataVaoiArrayString = parseCoordinatesString(sVaoi, "VAOI");
        seriesOcultas.add(crearSerieOculto(dataVaoiArrayString));
        JSONArray dataVaoiArrayInteger = parseCoordinatesInteger(dataVaoiArrayString);
        
        JSONArray dataVoodArrayString = parseCoordinatesString(sVood, "VOOI");
        JSONArray dataVooiArrayString = parseCoordinatesString(sVooi, "VOOI");
        
        
        
        serieVAODObject.put("name", "VAOD");
        serieVAODObject.put("color", "red");
        serieVAODObject.put("data", dataVaodArrayInteger);
        charDataArray.put(serieVAODObject);
        
        serieVAOIObject.put("name", "VAOI");
        serieVAOIObject.put("color", "blue");
        serieVAOIObject.put("data", dataVaoiArrayInteger);
        charDataArray.put(serieVAOIObject);
        
        for (int i = 0; i < seriesOcultas.size(); i++) {
            charDataArray.put(seriesOcultas.get(i));
        }
        
        finalJsonObject.put(jsonp, charDataArray);
        
        
        System.out.println(finalJsonObject);
        String tempStr = jsonp + "(" + finalJsonObject.toString() + ")";
        return tempStr;
    }
    
    public JSONArray parseCoordinatesString(String input, String label) {
        JSONArray serieArray = new JSONArray();
        Pattern pattern = Pattern.compile("(\\d+),(-?\\d+\\*?|\\d+\\*?)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            serieArray.put(matcher.group(2));
            if (matcher.group(2).toString().matches("(\\d+\\*)")) {
            }
        }
        return serieArray;
    }
    
    public JSONArray parseCoordinatesInteger(JSONArray array) throws JSONException{
        JSONArray serieArray = new JSONArray();
        for(int i =0; i< array.length(); i++){
            System.out.println(array.get(i).toString());
            serieArray.put(limpiaArray(array.get(i).toString()));
        }
        return serieArray;
    
    }
    
    public JSONObject crearSerieOculto(JSONArray text) throws JSONException {
        JSONObject objectoTemporal = new JSONObject();
        JSONObject dataObject = new JSONObject();
        JSONObject dataObject2 = new JSONObject();
        JSONArray arrayContenedor = new JSONArray();
        System.out.println(text.toString());
            for (int i = 0; i < text.length(); i++) {
                try {
                    if (text.get(i).toString().matches("(\\d+\\*)")) {
                        dataObject.put("x", i);
                        dataObject.put("y", limpiaArray(text.get(i).toString()));
                        arrayContenedor.put(dataObject);
                        dataObject2.put("x", i+1);
                        dataObject2.put("y", limpiaArray(text.get(i+1).toString()));
                        arrayContenedor.put(dataObject2);
                    }
                } catch (JSONException ex) {
                    Logger.getLogger(GetAudioData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            objectoTemporal.put("showInLegend", false);
            objectoTemporal.put("name", "AU");
            objectoTemporal.put("data", arrayContenedor);
            objectoTemporal.put("color", "white");
            objectoTemporal.put("lineWidht", 2.5);
        
        return objectoTemporal;
    }
    
    public int limpiaArray(String array) {
        String limpia = array.replace("*", "");
        int entero = Integer.parseInt(limpia);
        return entero;
    }
}
