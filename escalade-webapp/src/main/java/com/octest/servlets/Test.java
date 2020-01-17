package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exemple.demo.business.SiteService;
import org.exemple.demo.model.bean.Site;

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
		site.setDescripSite(request.getParameter("descripSite"));
		site.setCotationSite(request.getParameter("cotationSite"));

//		Sites tableSite = new Sites();
//		tableSite.ajouterSite(site);
//
//		request.setAttribute("sites", tableSite.recupererSites());

		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}
}