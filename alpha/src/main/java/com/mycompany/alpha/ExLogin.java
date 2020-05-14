/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alpha;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
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
@WebServlet(name = "ExLogin", urlPatterns = {"/exlogin"})
public class ExLogin extends HttpServlet {

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
        String passwort = request.getParameter("passwort");
        
        String sql = "select * from users where username=? and passwort=?";
        
        ConnectionPool dbPool = (ConnectionPool)getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();
        
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, passwort);
            
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                //response.getWriter().println(request.getSession().getId());
                
                
                User user = new User(rs.getInt("uid"), rs.getBoolean("isadmin"), username, rs.getString("vorname"), rs.getString("nachname"), passwort);
                
                try{                    
                    String token = Tokens.createLoginToken(user);
                    
                    request.getSession().setAttribute("user", user);
                    request.getSession().setAttribute("token", token);
                    
                    
                }
                catch(JWTCreationException exception){}
                RequestDispatcher view;
                if(user.getAdmin()){
                    view = request.getRequestDispatcher("admin/auswerten");
                }
                else {
                    view = request.getRequestDispatcher("customer/landingpage.jsp");
                }
                view.forward(request, response);
            }else{
                request.setAttribute("errMsg", "Username oder Passwort falsch!");
                
                RequestDispatcher view = request.getRequestDispatcher("login.jsp");
                view.forward(request, response);
            }
            
        }
        catch(SQLException e) {}        
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
