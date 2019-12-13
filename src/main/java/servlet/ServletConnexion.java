/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.DataSourceFactory;
import DAO.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Quentin
 */
public class ServletConnexion extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        String views ="PageAccueil.jsp";
        System.out.print(action);
        try{
            LoginDAO dao = new LoginDAO(DataSourceFactory.getDataSource());
            switch (action) {
		case "Se connecter":
                    System.out.println(email + "     " + mdp);
                    if(dao.isAdmin(email, mdp)){
                        HttpSession session = request.getSession();
                        session.setAttribute("admin", "admin");
                        response.sendRedirect("");
                    } else {
                        if(dao.getLogin(email,mdp)){
                            HttpSession session = request.getSession();
                            session.setAttribute("email", "mdp");
                            response.sendRedirect("");
                            
                        } else {
                            request.setAttribute("error_message", "Mauvais identifiant");
                            request.getRequestDispatcher(views).forward(request, response);
                        }
                        
                    }
                    break;
                
            }
            
            
        }catch (IOException | SQLException | ServletException ex) {
            request.setAttribute("error_message", "Identifiant/Mot de passe invalide");
            request.getRequestDispatcher(views).forward(request, response);
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
