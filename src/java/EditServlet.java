

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
    create table from values in emp class and viewservlet
    
    */
            response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Employee</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Emp e=EmpDao.getRoomById(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>Room:</td><td><input type='text' name='room' value='"+e.getRoom()+"'/></td></tr>");
		out.print("<tr><td>Capacity:</td><td><input type='capacity' name='capacity' value='"+e.getCapacity()+"'/></td></tr>");
		out.print("<tr><td>Equipment:</td><td><input type='equipment' name='equipment' value='"+e.getEquipment()+"'/></td></tr>");
		out.print("<tr><td>Position:</td><td>");
		out.print("<select name='position' style='width:150px'>");
		out.print("<option>Phase-1</option>");
		out.print("<option>phase-2</option>");
		out.print("<option>Phase-3</option>");
		out.print("<option>Other</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
