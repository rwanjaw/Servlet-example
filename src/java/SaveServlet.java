

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    /*
    gets values from the input fields
    pushes them to empDao to check the mysql database
    
    */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String room=request.getParameter("room");
		String capacity=request.getParameter("capacity");
		String equipment=request.getParameter("equipment");
		String position=request.getParameter("position");
		
		Emp e=new Emp();
		e.setRoom(room);
		e.setCapacity(capacity);
		e.setEquipment(equipment);
		e.setPosition(position);
		
		int status=EmpDao.save(e);
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}
