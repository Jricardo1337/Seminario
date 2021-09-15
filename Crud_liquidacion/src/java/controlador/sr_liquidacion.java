/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Liquidacion;
import modelo.Conexion;

/**
 *
 * @author Usuario
 */
public class sr_liquidacion extends HttpServlet {
    Liquidacion liquidacion;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            liquidacion = new Liquidacion(Integer.valueOf(request.getParameter("txt_id")),request.getParameter("txt_nombre_liquidacion"),request.getParameter("txt_fecha_inicio_l"),request.getParameter("txt_fecha_fin_l"));
     
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet liquidacion</title>");            
            out.println("</head>");
            out.println("<body>");
             if ("agregar".equals(request.getParameter("btn_agregar"))){
             if (liquidacion.agregar()>0){
             response.sendRedirect("index.jsp");
             
             }else{
             out.println("<h1> xxxxxxx No se Ingreso xxxxxxxxxxxx </h1>");
             out.println("<a href='index.jsp'>Regresar...</a>");
             }
             }
    
     if("modificar".equals(request.getParameter("btn_modificar"))){
             if (liquidacion.modificar()>0){
            response.sendRedirect("index.jsp");
            }
            else{
            out.println("No se pudo modificar");
            }
            }
            
            
            if("eliminar".equals(request.getParameter("btn_eliminar"))){
             if (liquidacion.eliminar()>0){
            response.sendRedirect("index.jsp");
            }
            else{
            out.println("no se pudo eliminar");
            }
            }
            
            out.println("</body>");
            out.println("</html>");
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
