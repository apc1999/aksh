package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAOClass;
import Model.DTOClass;
@WebServlet(urlPatterns = {"/registerlink","/userdetailslink","/updateuserlink"})
public class ServletController extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String url=req.getServletPath();

    	switch(url) {
    	case "/registerlink":
    		registeruser(req,resp);
    		break;
    	case "/userdetailslink":
    		getUserDetails(req,resp);
    		break;
    	case "/updateuserlink":
    		getUpdateDetails(req,resp);
    		break;
    	default:
    		resp.getWriter().println("Unknown Link");
    	}
    }


	private void getUpdateDetails(HttpServletRequest req, HttpServletResponse resp) {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		DAOClass d=new DAOClass();
		int result=d.updateUser(id,name);

	
	}

	private void getUserDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOClass d1=new DAOClass();
	    ArrayList<DTOClass> userlist=d1.getUserDetails();
	    req.setAttribute("userlist", userlist);
	    RequestDispatcher rd=req.getRequestDispatcher("user.jsp");
	    rd.forward(req, resp);

	}
	private void registeruser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		req.setAttribute("name", name);
		DAOClass d1=new DAOClass();
		int result=d1.addName(name);
		if (result>0) {

			req.setAttribute("result",result );
			RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		}

	}

}
