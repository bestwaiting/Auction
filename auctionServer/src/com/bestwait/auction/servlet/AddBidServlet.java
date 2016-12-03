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


public class AddBidServlet extends HttpServlet 
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
		String bidPrice = req.getParameter("bidPrice");
		String userId = (String)req.getSession(true).getAttribute("userId");
		JSONArray jsonArray=JSONArray.fromObject(DaoImpl.updateBidItem(bidPrice,userId,itemId));		
		response.setContentType("text/json;charset=UTF-8");
		// 输出响应
		response.getWriter().println(jsonArray.toString()); 
		response.getWriter().flush();  
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
