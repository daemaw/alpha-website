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
import java.sql.SQLException;
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
@WebServlet(name = "ExNutzerAnlegen", urlPatterns = {"/exnutzer_anlegen"})
public class ExNutzerAnlegen extends HttpServlet {

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
        String username = request.getParameter("username");
        String vorname = request.getParameter("vorname");
        String nachname = request.getParameter("nachname");
        String passwort = request.getParameter("passwort");
        String sql = "insert into users (username, vorname, nachname, passwort, isadmin) values (?,?,?,?, false)";
        
        ConnectionPool dbPool = (ConnectionPool)getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, vorname);
            pstm.setString(3, nachname);
            pstm.setString(4, passwort);
            
            pstm.executeUpdate();
            request.setAttribute("succMsg", "Nutzer erfolgreich angelegt, Sie können sich nun einloggen");
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
        }
        catch (SQLException e){
            response.getWriter().println(e.getMessage());
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
