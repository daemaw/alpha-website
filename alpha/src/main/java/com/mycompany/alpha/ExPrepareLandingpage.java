/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alpha;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.json.JsonObjectBuilder;
import javax.json.JsonArrayBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author z004366p
 */
@WebServlet(name = "ExPrepareLandingpage", urlPatterns = {"/expreparelandingpage"})
public class ExPrepareLandingpage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sql = "select * from flugziele";
        
        ConnectionPool dbPool = (ConnectionPool)getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();
        ArrayList<Flugziel> lsflug = new ArrayList<>();
        JsonObjectBuilder fzObj = Json.createObjectBuilder();
        String fo = null;
        
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                int zid = rs.getInt("zid");
                String abflug = rs.getString("abflug");
                String ankunft = rs.getString("ankunft");
                
                Flugziel fz = new Flugziel();
                fz.setZid(rs.getInt("zid"));
                fz.setAbflug(rs.getString("abflug"));
                fz.setAnkunft(rs.getString("ankunft"));
                
                lsflug.add(fz);
            }
            
            HashMap<String, JsonArrayBuilder> hm = new HashMap<>();
            
            
            for(Flugziel fz : lsflug){
                JsonObjectBuilder job = Json.createObjectBuilder();
                job.add("ankunft", fz.getAnkunft());
                job.add("zid", fz.getZid());
                hm.putIfAbsent(fz.getAbflug(), Json.createArrayBuilder());
                hm.get(fz.getAbflug()).add(job);
            }
            for(HashMap.Entry<String,  JsonArrayBuilder> entry : hm.entrySet()){
                String key = entry.getKey();
                JsonArrayBuilder value = entry.getValue();
                
                fzObj.add(key, value);
            }
            JsonObject jo = fzObj.build();
            fo = jo.toString();
            //response.getWriter().println(fo);
            
        }
        catch (SQLException e){}
        request.setAttribute("fo", fo);
        RequestDispatcher view = request.getRequestDispatcher("/customer/landingpage.jsp");
        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
