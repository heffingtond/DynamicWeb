package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Vomment
public class LoginAction extends Action
{
	public void execute( HttpServletRequest request,
            			 HttpServletResponse response )
	{
		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession();
		
		String destinationPage = "/JSP/home.jsp";
		this.view( request, response, destinationPage );
	}
}
