package com.bestwait.auction.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.bestwait.auction.dao.DaoImpl;
import com.bestwait.auction.dao.DateJsonValueProcessor;


public class ViewOwnerItemServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException{
		Integer userId = (Integer)req.getSession(true).getAttribute("userId");
		JsonConfig jf = new JsonConfig();    
        jf.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
        jf.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
		JSONArray jsonArray=JSONArray.fromObject(DaoImpl.getOwnerViewItem(userId),jf);	
		response.setContentType("text/json;charset=UTF-8");
		//  ‰≥ˆœÏ”¶
		response.getWriter().println(jsonArray.toString()); 
		response.getWriter().flush(); 
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
