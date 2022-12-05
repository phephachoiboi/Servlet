package webapp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.data.DataBase;
import servlet.data.Entry;


public class ForumServlet extends HttpServlet {
 /**
  *
  */
 private static final long serialVersionUID = 1L;
 
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
  
	 // Here we set the MIME type of the response, "text/html"
  response.setContentType("text/html");
  // Here we use a PrintWriter to send text data
  // to the client who has requested the servlet
  java.io.PrintWriter out = response.getWriter();
  
  String username, message;
  
  String action=request.getParameter("action");
  
  //Here we add forum data to the database
  
  if(action !=null && !action.isEmpty()) {
	  
	  username=request.getParameter("username");
	  message=request.getParameter("message");
	  
	  if(username!=null && !username.isEmpty() && message!=null && !message.isEmpty() )
		  DataBase.addEntry(new Entry(username, message));
	  
  }
  
  
  // Here we start assembling the HTML content
  out.println("<html><head>");
  out.println("<title>Froum Messages</title>");
  out.println("<link rel='stylesheet' type='text/css' href='styles.css' />");
  out.println("</head><body>");
  out.println("<table>");
  
  //Here we get all entry data in the database
  out.println(DataBase.getAll());
  
  
  out.println("</table>");
  
  
  
  out.println("<div id='link'>");
  out.println("<hr/>");
  out.println("<a href='index.html'>Back</a>");
  out.println("</div>");
  
  
  out.println("</body></html>");
  
  out.close();
  
  
  
 }


}