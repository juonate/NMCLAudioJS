/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noemalife.galileo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;

/**
 *
 * @author Juan
 */
public class GetAudioDetails extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8"); 
 
        response.setHeader("Cache-Control", "no-cache"); 
 
        PrintWriter out = response.getWriter();
        String jsonData="";
        String sVaod = "VAOD=[(150,45),(250,45),(500,45),(1000,30),(2000,25),(3000,20),(4000,15),(6000,14),(8000,13)]";
        String sVaoi = "VAOI=[(150,20),(25025),(500,30),(1000,35),(2000,40),(3000,20),(4000,15),(6000,25),(8000,30)]";
        String sVood = "VOOD=[(150,35),(250,40),(500,45),(1000,35),(2000,25),(3000,20),(4000,15),(6000,10),(8000,15)]";
        String sVooi = "VOOI=[(150,40),(250,45),(500,20),(1000,35),(2000,65),(3000,30),(4000,5),(6000,10),(8000,15)]";
        
 
        try {
 
            String jsonp= request.getParameter("jsonp");
 
            GetAudioData getAudioData=new GetAudioData();
 
            jsonData = getAudioData.generateData(jsonp);
 
           out.print(jsonData);
 
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
    
    
    
}
