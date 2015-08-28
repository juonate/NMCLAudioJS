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
