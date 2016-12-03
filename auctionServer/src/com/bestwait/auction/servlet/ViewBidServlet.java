package com.bestwait.auction.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.bestwait.auction.dao.DaoImpl;
import com.bestwait.auction.dao.DateJsonValueProcessor;


public class ViewBidServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException{
		JsonConfig jf = new JsonConfig();    
        jf.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
        jf.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
        List<Object> list= DaoImpl.getBidViewItem();
        System.out.println(list.toString());
		JSONArray jsonArray=JSONArray.fromObject(list,jf);		
		response.setContentType("text/json;charset=UTF-8");
		//  ‰≥ˆœÏ”¶
		response.getWriter().println(jsonArray.toString()); 
		response.getWriter().flush(); 
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
