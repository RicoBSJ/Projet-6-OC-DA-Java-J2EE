package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aubrun.eric.projet6.business.service.UtilisateurService;

@WebServlet( "/inscription" )
public class Inscription extends HttpServlet {

    private static final long  serialVersionUID   = 1L;

    /* Constantes */
    public static final String VUE                = "/WEB-INF/jsp/inscription.jsp";

    private UtilisateurService utilisateurService = new UtilisateurService();

    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        request.setAttribute( "utilisateur", utilisateurService.recordUser() );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet( request, response );
    }

}
