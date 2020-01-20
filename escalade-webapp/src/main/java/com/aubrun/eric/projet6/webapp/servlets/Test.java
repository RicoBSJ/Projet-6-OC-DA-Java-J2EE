package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aubrun.eric.projet6.business.service.SiteService;
import com.aubrun.eric.projet6.consumer.DAO.SiteDAO;
import com.aubrun.eric.projet6.model.bean.Site;

@WebServlet("/Test")
public class Test extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private SiteService siteService = new SiteService();

	public Test() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("sites", siteService.findAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Site site = new Site();
		site.setNomSite(request.getParameter("nomSite"));

		SiteDAO tableSiteDAO = new SiteDAO();
		tableSiteDAO.ajouterSite(site);

		request.setAttribute("sites", tableSiteDAO.recupererSites());

		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}
}