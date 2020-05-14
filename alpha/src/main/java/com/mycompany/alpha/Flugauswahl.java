/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alpha;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julia
 */
@WebServlet(name = "Flugauswahl", urlPatterns = {"/customer/flugauswahl"})
public class Flugauswahl extends HttpServlet {

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
        String abflug = request.getParameter("abflug");
        String ankunft = request.getParameter("ankunft");
        
        String sql = "select fid, fluege.zid as zid, zeit, flugdauer, preis from fluege natural join flugziele where abflug=? and ankunft=?";
        
        ArrayList<Flug> flList = new ArrayList();
        
        ConnectionPool dbPool = (ConnectionPool)getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, abflug);
            pstm.setString(2, ankunft);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Timestamp timestamp = rs.getTimestamp("zeit");
                //new Date(timestamp.getTime())
                Flugziel fz = new Flugziel(rs.getInt("zid"), abflug, ankunft);
                Flug flug = new Flug(rs.getInt("fid"), fz, rs.getTime("zeit"), rs.getFloat("preis"));
                flug.setDauer(rs.getFloat("flugdauer"));
                
                flList.add(flug);
            }
            
            
        request.setAttribute("flugListe", flList);
        RequestDispatcher view = request.getRequestDispatcher("/customer/flugauswahl.jsp");//TODO: Add correct link to jsp
        view.forward(request, response);
        }
        catch (SQLException e) {
            response.getWriter().println(e);
        }
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
