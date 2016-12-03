package com.bestwait.auction.dao;

import java.util.List;

public class DaoImpl 
{
	static SqlDBHelper dbhelper;
	static
	{
		dbhelper=new SqlDBHelper();
	}
	static public Object validateLogin(String username,String userpwd)
	{
		String sqlstring="select * from auction_user where username=? and userpass = ?";	
		return dbhelper.executeQuerySingle(sqlstring,new Object[]{username,userpwd});
	}
	static public List<Object> getSuccBidViewItem(Integer userId)
	{
		String sqlstring="select item_name,kind_name,max_price,item_desc from item as a,kind as b where winer_id=? and a.kind_id=b.kind_id";
		return dbhelper.excuteQuery(sqlstring,new Object[]{userId});
	}
	static public List<Object> getFailBidViewItem(Integer state_id)
	{
		String sqlstring="select item_name,kind_name,max_price,item_desc from item as a,kind as b where state_id=? and a.kind_id=b.kind_id";		
		return dbhelper.excuteQuery(sqlstring,new Object[]{state_id});
	}
	
	static public List<Object> getKindViewItem()
	{
		String sqlstring="select * from kind";		
		return dbhelper.excuteQuery(sqlstring,null);
	}
	static public List<Object> getViewItemByKindId(Integer kindId)
	{
		String sqlstring="select * from item where kind_id=?";		
		return dbhelper.excuteQuery(sqlstring,new Object[]{kindId});
	}
	static public List<Object> getViewItemByItemId(Integer itemId)
	{
		String sqlstring="select * from item where item_id=?";		
		return dbhelper.excuteQuery(sqlstring,new Object[]{itemId});
	}
	static public Object insertKindItem(String kindname,String kindesc)
	{
		String sqlstring="insert into kind(kind_name,kind_desc) values(?,?)";		
		return dbhelper.executeUpdate(sqlstring,new Object[]{kindname,kindesc});
	}
	static public Object updateBidItem(String bidPrice,String itemId,String winerId)
	{
		String sqlstring="update item set max_price = ? ,winer_id=? where item_id = ?";		
		return dbhelper.executeUpdate(sqlstring,new Object[]{bidPrice,winerId,itemId});
	}
	static public List<Object> getBidViewItem()
	{
		String sqlstring="select item_name,max_price,addtime,winer_id,owner_id from item";		
		return dbhelper.excuteQuery(sqlstring,null);
	}
	static public List<Object> getOwnerViewItem(Integer userId)
	{
		String sqlstring="select item_name,kind_name,max_price,item_desc,init_price,endtime from item as a,kind as b where owner_id=? and a.kind_id=b.kind_id";
		return dbhelper.excuteQuery(sqlstring,new Object[]{userId});
	}
	static public void getViewItem()
	{
		
	}
}
