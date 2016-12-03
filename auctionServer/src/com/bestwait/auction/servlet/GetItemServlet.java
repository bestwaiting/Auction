package com.bestwait.auction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;









import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.bestwait.auction.dao.DaoImpl;
import com.bestwait.auction.dao.DateJsonValueProcessor;


public class GetItemServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		// 获取物品种类ID
		String itemId = req.getParameter("itemId");
		JsonConfig jf = new JsonConfig();    
        jf.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
        jf.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));  
		JSONArray jsonArray=JSONArray.fromObject(DaoImpl.getViewItemByItemId(Integer.valueOf(itemId)),jf);		
		response.setContentType("text/json;charset=UTF-8");
		// 输出响应
		response.getWriter().println(jsonArray.toString()); 
		response.getWriter().flush(); 
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
