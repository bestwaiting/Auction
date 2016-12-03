package com.bestwait.auction.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.sf.json.JSONArray;

import com.bestwait.auction.dao.DaoImpl;


public class AddItemServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException{
		String kindname = req.getParameter("kindName");
		String kindesc = req.getParameter("kindDesc");
		JSONArray jsonArray=JSONArray.fromObject( DaoImpl.insertKindItem(kindname, kindesc));		
		response.setContentType("text/json;charset=UTF-8");
		//  ‰≥ˆœÏ”¶
		response.getWriter().println(jsonArray.toString()); 
		response.getWriter().flush(); 
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
