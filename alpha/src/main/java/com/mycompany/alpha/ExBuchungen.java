/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alpha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eimstoa
 */
@WebServlet(name = "ExBuchungen", urlPatterns = {"/customer/exbuchungen"})
public class ExBuchungen extends HttpServlet {

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
        
        //User user = new User(2, false, "harald123", "Harald", "Gloeckler", "lol123"); // Zeile löschen sobald User über requestgetSession kommt
        User user = (User)request.getSession().getAttribute("user");
        ArrayList<Buchung> buchungsListe = new ArrayList<>();
        String sql = "select * from buchungen " + "join fluege on buchungen.fid = fluege.fid " + "join flugziele on fluege.zid = flugziele.zid " +
                     "join stati on buchungen.sid = stati.sid " +
                     "where uid = ? order by datum desc";
        
        //Aus Sql: * , Status und Ankunft/Abflug
        
        ConnectionPool dbPool = (ConnectionPool)getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();
        
        try{
           
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, user.getUid()); 
            ResultSet rs = pstm.executeQuery();
            
            int bid = 0;
            int fid = 0;
            Date datum = null;
            Timestamp timestamp = null;
            String abflug = null;
            String ankunft = null;
            String status = null;
            int zid = 0;
            float preis = 0;
            int sid = 0;
            float flugdauer = 0;
            java.sql.Time zeit = null;
            
            
            
            while(rs.next()){
                
                
                
                bid = rs.getInt("bid");
                fid = rs.getInt("fid");
                timestamp = rs.getTimestamp("datum");
                
                datum = new Date(timestamp.getTime());
                abflug = rs.getString("abflug");
                ankunft = rs.getString("ankunft");
                status = rs.getString("status");
                zid = rs.getInt("zid");
                preis = rs.getFloat("preis");
                timestamp = rs.getTimestamp("zeit");
                zeit = new Time(timestamp.getTime());
                flugdauer = rs.getFloat("flugdauer");
                sid = rs.getInt("sid");
                
                
                
                Flugziel flugziel = new Flugziel(zid, abflug, ankunft);
                Flug flug = new Flug(fid, flugziel, datum, preis, flugdauer, zeit);
                Status statusObjekt = new Status(sid, status);
                
                
                
                buchungsListe.add(new Buchung(bid, flug, user, datum, statusObjekt));
 
            }
            
            
            dbPool.releaseConnection(conn);
            
        }
        catch(SQLException e){}
        
        request.setAttribute("buchungsListe", buchungsListe);
        //Weiterleitung zur View
        RequestDispatcher view = request.getRequestDispatcher("buchungen.jsp");
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
