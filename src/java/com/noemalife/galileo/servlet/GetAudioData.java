/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noemalife.galileo.servlet;

import java.util.ArrayList;
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

    public String generateData(String jsonp) throws JSONException {
        JSONObject finalJsonObject = new JSONObject();
        JSONArray xaxisArray = new JSONArray();
        JSONObject seriesJsonObject = new JSONObject();
        JSONArray dataVaodArray = new JSONArray();
        JSONArray dataVaoiArray = new JSONArray();
        JSONArray dataVoodArray = new JSONArray();
        JSONArray dataVooiArray = new JSONArray();
        
        ArrayList<AudioData> array = new ArrayList<AudioData>();
        AudioData ad = new AudioData();
        
        ad.setFrecuencia(125);
        ad.setVaod(24);
        ad.setVaoi(25);
        ad.setVood(30);
        ad.setVooi(45);
        array.add(ad);
        
        ad.setFrecuencia(250);
        ad.setVaod(58);
        ad.setVaoi(45);
        ad.setVood(42);
        ad.setVooi(50);
        array.add(ad);
        
        ad.setFrecuencia(500);
        ad.setVaod(76);
        ad.setVaoi(76);
        ad.setVood(65);
        ad.setVooi(65);
        array.add(ad);
        
        ad.setFrecuencia(1000);
        ad.setVaod(76);
        ad.setVaoi(76);
        ad.setVood(65);
        ad.setVooi(65);
        array.add(ad);
        
        ad.setFrecuencia(2000);
        ad.setVaod(76);
        ad.setVaoi(76);
        ad.setVood(65);
        ad.setVooi(65);
        array.add(ad);
        
        for(int i=0; i < array.size(); i++){
            xaxisArray.put(array.get(i).getFrecuencia());
            dataVaodArray.put(array.get(i).getVaod());
            dataVaoiArray.put(array.get(i).getVaoi());
            dataVoodArray.put(array.get(i).getVood());
            dataVooiArray.put(array.get(i).getVooi());
        }
        seriesJsonObject.put("categories", xaxisArray);
        seriesJsonObject.put("name", "VAOD");
        seriesJsonObject.put("color", "red");
        seriesJsonObject.put("data", dataVaodArray);
        
        finalJsonObject.put(jsonp, seriesJsonObject);
        
        
        System.out.println(finalJsonObject);
        return finalJsonObject.toString();
    }
}
