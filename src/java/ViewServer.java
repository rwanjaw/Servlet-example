

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ViewServer")
public class ViewServer extends HttpServlet {
    /*
    Gets values from the empDao.getAllRoom
    checks if session is present
    creates a html table 
    */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
                   HttpSession session=request.getSession(false); 
                 if(session!=null){  
        String name=(String)session.getAttribute("name");  
          
        out.print("Hello, "+name+" Welcome to Profile");  
        }  
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
		out.println("<a href='index.html'>Add New Room</a>");
                out.println("<a href='logout'>LOG OUT</>");
		out.println("<h1>Room List</h1>");
		
		List<Emp> list=EmpDao.getAllRoom();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Room</th><th>capacity</th><th>Equipment</th><th>position</th><th>Edit</th><th>Delete</th></tr>");
		for(Emp e:list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getRoom()+"</td><td>"+e.getRoom()+"</td><td>"+e.getCapacity()+"</td><td>"+e.getPosition()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
