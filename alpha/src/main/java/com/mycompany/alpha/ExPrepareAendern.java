 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alpha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * @author z004366p
 */
@WebServlet(name = "ExPrepareAendern", urlPatterns = {"/customer/exprepareaendern"})
public class ExPrepareAendern extends HttpServlet {

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
        int bid = Integer.parseInt(request.getParameter("bid"));
        
        ConnectionPool dbPool = (ConnectionPool)getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();
        String sql = "select datum, fid, zeit, flugdauer, preis from fluege natural join buchungen where bid = ?";
        int fid = 0;
        String date = null;
        try {
            
            PreparedStatement pstm2 = conn.prepareStatement(sql);
            pstm2.setInt(1, bid);
            ResultSet rs2 = pstm2.executeQuery();
            
            while(rs2.next()){
                fid = rs2.getInt("fid");
                date = rs2.getString("datum");
            }
        }
        catch (SQLException e){}
        
        
        String sql2 = "select  fid, zeit, flugdauer, preis from fluege where fid = ?";
        
        ArrayList<Flug> flList = new ArrayList();
        
       
        
        
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sql2);
            pstm.setInt(1, fid);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Timestamp timestamp = rs.getTimestamp("zeit");
                //new Date(timestamp.getTime())
                Flugziel fz = new Flugziel();
                Flug flug = new Flug(rs.getInt("fid"), fz, rs.getTime("zeit"), rs.getFloat("preis"));
                
                flug.setDauer(rs.getFloat("flugdauer"));
               
                
                flList.add(flug);
            }
           
             request.setAttribute("fid", fid);
        request.setAttribute("datum", date);
        request.setAttribute("flugListe", flList);
        RequestDispatcher view = request.getRequestDispatcher("/customer/Aendern.jsp");
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
