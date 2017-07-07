/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author William Wanja
 */
public class login extends HttpServlet {
/*
   Gets values from the class empDao
    creates sessions with the username
    dispatches to index.html
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String name=request.getParameter("uname");
		String password=request.getParameter("pass");
                System.out.println("gxe5r6tfugy");
		int status=EmpDao.User( name, password);
		if(status>0){
                    HttpSession session=request.getSession();
		session.setAttribute("name",name);
                    System.out.println("fguyuhjkbvchj");
			response.sendRedirect("ViewServer");
		
		out.print("Welcome, "+name);
		
                request.getRequestDispatcher("index.html").include(request, response);
		}
		else{
			out.print("Sorry, username or password error!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

}
