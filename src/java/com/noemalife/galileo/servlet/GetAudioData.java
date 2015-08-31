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
        JSONArray charDataArray = new JSONArray();
        JSONObject categoryObject = new JSONObject();
        JSONObject serieVAODObject = new JSONObject();
        JSONObject serieVAOIObject = new JSONObject();
        JSONObject serieVOODObject = new JSONObject();
        JSONObject serieVOOIObject = new JSONObject();
        
        
        JSONArray dataVaodArray = new JSONArray();
        JSONArray dataVaoiArray = new JSONArray();
        JSONArray dataVoodArray = new JSONArray();
        JSONArray dataVooiArray = new JSONArray();
        JSONArray categoryArray = new JSONArray();
        
        ArrayList<AudioData> array = new ArrayList<AudioData>();
        
        AudioData ad = new AudioData();
        
        ad.setCat125(25);
        ad.setCat250(20);
        ad.setCat500(30);
        ad.setCat1000(25);
        ad.setCat2000(20);
        ad.setCat3000(35);
        ad.setCat4000(40);
        ad.setCat6000(10);
        ad.setCat8000(15);
        array.add(ad);
        
        ad = new AudioData();
        ad.setCat125(25);
        ad.setCat250(20);
        ad.setCat500(30);
        ad.setCat1000(25);
        ad.setCat2000(20);
        ad.setCat3000(35);
        ad.setCat4000(40);
        ad.setCat6000(10);
        ad.setCat8000(15);
        array.add(ad);
        
        ad = new AudioData();
        ad.setCat125(25);
        ad.setCat250(20);
        ad.setCat500(30);
        ad.setCat1000(25);
        ad.setCat2000(20);
        ad.setCat3000(35);
        ad.setCat4000(40);
        ad.setCat6000(10);
        ad.setCat8000(15);
        array.add(ad);
        
        ad = new AudioData();
        ad.setCat125(25);
        ad.setCat250(20);
        ad.setCat500(30);
        ad.setCat1000(25);
        ad.setCat2000(20);
        ad.setCat3000(35);
        ad.setCat4000(40);
        ad.setCat6000(10);
        ad.setCat8000(15);
        array.add(ad);

        System.out.println(array.toString());
        for(int i=0; i < array.size(); i++){
            System.out.println(array.get(i).getCat125());
            dataVaodArray.put(array.get(i).getCat125());
            dataVaodArray.put(array.get(i).getCat250());
            dataVaodArray.put(array.get(i).getCat500());
            dataVaodArray.put(array.get(i).getCat1000());
            dataVaodArray.put(array.get(i).getCat2000());
            dataVaodArray.put(array.get(i).getCat3000());
            dataVaodArray.put(array.get(i).getCat4000());
            dataVaodArray.put(array.get(i).getCat6000());
            dataVaodArray.put(array.get(i).getCat8000());
           
        }
        serieVAODObject.put("name", "VAOD");
        serieVAODObject.put("color", "red");
        serieVAODObject.put("data", dataVaodArray);
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
}
