package com.bestwait.auction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.bestwait.auction.dao.DaoImpl;


public class LoginServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException{
		String username = req.getParameter("username");
		String password = req.getParameter("userpwd");
		System.out.println(username+":"+password);
		JSONObject jsonObj = new JSONObject();
		response.setContentType("text/json;charset=UTF-8");
		if (username != null && password != null)
		{			
			try
			{
				Object object=DaoImpl.validateLogin(username, password);
				System.out.println(object);
				if(object==null)
					jsonObj.put("userId","0");
				else
				{
					jsonObj.put("userId",Integer.parseInt(String.valueOf(object)));
					req.getSession(true).setAttribute("userId" , Integer.parseInt(String.valueOf(object)));
				}
				
			} 
			catch (JSONException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();				
			}
		}
		System.out.println(jsonObj);
		//  ‰≥ˆœÏ”¶
		response.getWriter().println(jsonObj); 
		response.getWriter().flush(); 
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
