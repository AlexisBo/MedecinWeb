/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Departement;
import modele.Medecin;
import modele.Pays;
import modele.PaysDAO;
import modele.Specialite;

/**
 *
 * @author sio
 */
public class control extends HttpServlet {

    private Pays p;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        p = new Pays();
    }

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

        String page = "dep.jsp";
        String page2 = "med.jsp";
        String page3 = "medTrier.jsp";
        String page4 = "spe.jsp";

        String choix = request.getParameter("choix") == null ? "accueil" : request.getParameter("choix");

        switch (choix) {
            case "accueil":
                request.setAttribute("listeDeps", p.getLesDeps().values());
                request.setAttribute("listeSpec", p.getLesSpes().values());
                request.getRequestDispatcher(page).forward(request, response);
                break;
            case "dep":
                Integer dep = Integer.parseInt(request.getParameter("dep"));
                Collection<Medecin> unMed = p.getLeDep(dep).getLesMeds();
                request.setAttribute("liste", unMed);
                request.getRequestDispatcher(page2).forward(request, response);
                break;
            case "trier":
                Collection<Medecin> lesMedecins = new TreeSet<>();
                for (Departement unDepartement : this.p.getLesDeps().values()) {
                    lesMedecins.addAll(unDepartement.getLesMeds(request.getParameter("prefix")));
                }
                request.setAttribute("liste", lesMedecins);
                request.getRequestDispatcher(page3).forward(request, response);
                break;
            case "spec":
                request.setAttribute("liste", this.p.getLaSpe(request.getParameter("spec")).getLesMeds());
                request.getRequestDispatcher(page2).forward(request, response);
                break;
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
