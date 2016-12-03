package com.bestwait.auction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.bestwait.auction.dao.DaoImpl;


public class ItemListServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		// 获取物品种类ID
		String kindId = req.getParameter("kindId");
		JSONArray jsonArray=JSONArray.fromObject(DaoImpl.getViewItemByKindId(Integer.valueOf(kindId)));		
		response.setContentType("text/json;charset=UTF-8");
		// 输出响应
		response.getWriter().println(jsonArray.toString()); 
		response.getWriter().flush(); 
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
