package root;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modal.Studentdetails;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sonav
 */
public class Register extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;
        try {
            /* TODO output your page here. You may use following sample code. */
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String mobile = request.getParameter("mobile");
            String email = request.getParameter("email");
            String semester = request.getParameter("semester");
            String clg = request.getParameter("clg");
            String result = request.getParameter("result");
            
            String msg = "Failed";
            
            
            Studentdetails sd = new Studentdetails();
            
            Session se = NewHibernateUtil.getSessionFactory().openSession();
            Transaction t = se.beginTransaction();
            
            sd.setEmailID(email);
            sd.setFirstName(fname);
            sd.setLastName(lname);
            sd.setSemester(semester);
            sd.setMobile(mobile);
            sd.setCollege(clg);
            sd.setResult(result);
            
            se.save(sd);
            t.commit();
            msg = "Successful";
            
            if(msg=="Successful")
            {
                rd = request.getRequestDispatcher("Success.jsp");
                rd.forward(request, response);
            }
            
            else
            {
                rd = request.getRequestDispatcher("Failed.jsp");
                rd.forward(request, response);
            }
        }
        catch(Exception e){
            out.print(e.getMessage());
            rd = request.getRequestDispatcher("Failed.jsp");
            rd.forward(request, response);
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
