package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Action;
import actions.LoginAction;
import utilities.DynamicWebUtilities;

/**
 * Servlet implementation class DynamicWebServlet
 */
@WebServlet("/DynamicWebServlet")
public class DynamicWebServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		boolean timeout = false;
		try
		{
			timeout = DynamicWebUtilities.isTimeout( request, response );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		if ( ! timeout )
		{
			Action action = null;
			if ( DynamicWebUtilities.replaceSpecialCharacters( request.getParameter( "LoginAction" ) ) != null )
				action = new LoginAction();
			
			action.execute( request, response );
		}
	}
}
