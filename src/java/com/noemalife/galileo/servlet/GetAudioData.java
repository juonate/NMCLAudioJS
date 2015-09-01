/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noemalife.galileo.servlet;

import java.util.ArrayList;
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

    public String generateData(String jsonp, String sVaod, String sVaoi, String sVood, String sVooi) throws JSONException {
        JSONObject finalJsonObject = new JSONObject();
        JSONArray charDataArray = new JSONArray();
        JSONObject serieVAODObject = new JSONObject();
        JSONObject serieVAOIObject = new JSONObject();
        JSONObject serieVOODObject = new JSONObject();
        JSONObject serieVOOIObject = new JSONObject();
        
        
        JSONArray dataVaodArray = parseCoordinates(sVaod, "VAOD");
        JSONArray dataVaoiArray = parseCoordinates(sVaoi, "VAOI");
        JSONArray dataVoodArray = parseCoordinates(sVood, "VOOI");
        JSONArray dataVooiArray = parseCoordinates(sVooi, "VOOI");
        
        for(int i=0; i < dataVaodArray.length(); i++){
            System.out.println(dataVaodArray.get(i).toString().matches("(\\d+\\*)"));
            if(dataVaodArray.get(i).toString().matches("(\\d+\\*)")){
                System.out.println(dataVaodArray.getJSONArray(i));
            }
        }
        
        serieVAODObject.put("name", "VAOD");
        serieVAODObject.put("color", "red");
//        serieVAODObject.put("data", dataVaodArray);
        charDataArray.put(serieVAODObject);
        
        serieVAOIObject.put("name", "VAOI");
        serieVAOIObject.put("color", "blue");
        serieVAOIObject.put("data", dataVaoiArray);
        charDataArray.put(serieVAOIObject);
        
        
        finalJsonObject.put(jsonp, charDataArray);
        
        
        System.out.println(finalJsonObject);
        String  tempStr=jsonp+"("+finalJsonObject.toString()+")";
        return tempStr;
    }
    
    public JSONArray parseCoordinates(String input, String label) {
        JSONArray serieArray = new JSONArray();
//        Pattern pattern = Pattern.compile("(\\d+),([-]\\d+|\\d+)");
        Pattern pattern = Pattern.compile("(\\d+),(-?\\d+\\*?|\\d+\\*?)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String limpia = matcher.group(2).replace("*", "");
            int y = Integer.parseInt(limpia);
            serieArray.put(Integer.parseInt(limpia));
        }
        return serieArray;
    }
}
