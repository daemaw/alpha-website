/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alpha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author z0041r3p
 */
@WebServlet(name = "Auswerten", urlPatterns = {"/admin/auswerten"})
public class Auswerten extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            Statistik stat = new Statistik();
        
        String sql1 = "select count(sid) as anz_aktiv from buchungen where sid = ?";
        String sql2 = "select count(sid) as anz_storn from buchungen where sid = ?";
        String sql3 = "select count(sid) as anz_geflog from buchungen where sid = ?";
        String sql4 = "select count(uid)-1 as anz_user from users";
        String sql5 = "select sum(fluege.preis) as umsatz from fluege join buchungen on fluege.fid=buchungen.FID where sid = ? or sid = ?";

        ConnectionPool dbPool = (ConnectionPool)getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();
        
        try{
            //Aktiv
            PreparedStatement pstm1 = conn.prepareStatement(sql1);
            pstm1.setInt(1, 1);
            ResultSet rs1 = pstm1.executeQuery();
            rs1.next();
            stat.setAnz_aktiv(rs1.getInt("anz_aktiv"));
            //Storniert
            PreparedStatement pstm2 = conn.prepareStatement(sql2);
            pstm2.setInt(1, 2);
            ResultSet rs2 = pstm2.executeQuery();
            rs2.next();
            stat.setAnz_storn(rs2.getInt("anz_storn"));
            //Bereits geflogen
            PreparedStatement pstm3 = conn.prepareStatement(sql3);
            pstm3.setInt(1, 3);
            ResultSet rs3 = pstm3.executeQuery();
            rs3.next();
            stat.setAnz_geflog(rs3.getInt("anz_geflog"));
            //User
            PreparedStatement pstm4 = conn.prepareStatement(sql4);
            ResultSet rs4 = pstm4.executeQuery();
            rs4.next();
            stat.setAnz_user(rs4.getInt("anz_user"));
            //Umsatz
            PreparedStatement pstm5 = conn.prepareStatement(sql5);
            pstm5.setInt(1, 1);
            pstm5.setInt(2, 3);
            ResultSet rs5 = pstm5.executeQuery();
            rs5.next();
            stat.setUmsatz(rs5.getInt("umsatz"));
            dbPool.releaseConnection(conn);
            
            
            
        }
        catch(SQLException e){}
        request.setAttribute("stat", stat);
        RequestDispatcher view = request.getRequestDispatcher("statistik.jsp");
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
        processRequest1(request, response);
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
        processRequest1(request, response);
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
