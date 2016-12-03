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

import com.bestwait.auction.dao.DaoImpl;


public class ViewFailServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException{
		JSONArray jsonArray=JSONArray.fromObject(DaoImpl.getFailBidViewItem(3));	
		response.setContentType("text/json;charset=UTF-8");
		//  ‰≥ˆœÏ”¶
		response.getWriter().println(jsonArray.toString()); 
		response.getWriter().flush(); 
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
