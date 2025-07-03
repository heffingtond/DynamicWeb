package utilities;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DynamicWebUtilities
{
	public static boolean isTimeout( HttpServletRequest request,
			 						 HttpServletResponse response ) throws Exception
	{
		HttpSession session = request.getSession();
		boolean isTimeout = false;
		if( session.isNew() )
		{
			isTimeout = true;
			RequestDispatcher view = null;
			view = request.getRequestDispatcher( "../JSP/login.jsp" );
			view.forward( request, response );
		}
		return isTimeout;
	}
	
	public static String replaceSpecialCharacters( String inString )
	{
		final String SINGLE_QUOTE = "&#39;";
		final String DOUBLE_QUOTE = "&#34;";
		final String LESS_THAN = "&lt;";
		final String GREATER_THAN = "&gt;";
		StringBuffer sb = null;
		if ( inString != null )
		{
			sb = new StringBuffer( inString );
			int totalLength = sb.length();
			for ( int i = totalLength - 1; i >= 0; i-- )
			{
				if ( sb.charAt( i ) == '\'' )
				{
					sb.deleteCharAt( i );
					sb.insert( i, SINGLE_QUOTE );
				}
				else
				if ( sb.charAt( i ) == '"' )
				{
					sb.deleteCharAt( i );
					sb.insert( i, DOUBLE_QUOTE );
				}

			}
			return sb.toString();
		}
		return null;
	}
}
