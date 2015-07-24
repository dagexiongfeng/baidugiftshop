package baidu.giftshop.frk;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baidu.giftshop.entity.Account;

public class AdminFilter extends HttpServlet implements Filter{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void destroy() {
		super.destroy();
	}
	

	@Override
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		HttpSession session = request.getSession();
		String url = request.getServletPath();
		String contextPath = request.getContextPath();
	    url = url.substring(url.lastIndexOf("/") + 1, url.length());
		if(url.equals(""))
			url+="/";
		if(url.startsWith("/") || url.equals("left.jsp")){

			    Account user = (Account)session.getAttribute("user");
			if(user==null){
				   response.sendRedirect(contextPath+"/login.jsp");
				   return;
			   }else if(user.getAccount().equals("administor")){
				   
			   }else{
				   response.sendRedirect(contextPath+"/login.jsp");
				   return;
			   }
		    }
		filterChain.doFilter(sRequest, sResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
