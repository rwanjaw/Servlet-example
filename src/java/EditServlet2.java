

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
    /*
    get the value from the emp class
    push to empDaofor sql authentication
    redirect to viewserver
    
    */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String room=request.getParameter("room");
		String capacity=request.getParameter("capacity");
		String equipment=request.getParameter("equipment");
		String position=request.getParameter("position");
		
		Emp e=new Emp();
		e.setId(id);
		e.setRoom(room);
		e.setCapacity(capacity);
		e.setEquipment(equipment);
		e.setPosition(position);
		
		int status=EmpDao.update(e);
		if(status>0){
			response.sendRedirect("ViewServer");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
