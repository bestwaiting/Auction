package com.bestwait.auction.dao;

import java.text.SimpleDateFormat;

import javax.swing.JApplet;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class DateJsonValueProcessor implements JsonValueProcessor
{
	
	private String format;
	public DateJsonValueProcessor(String format){
		this.format = format;
	}
	
    public Object processArrayValue(Object value, JsonConfig jsonConfig)
    {
        return null;
    }

    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig)
    {
        if(value == null)
        {
            return "";
        }
        if(value instanceof java.sql.Timestamp)
        {
            String str = new SimpleDateFormat(format).format((java.sql.Timestamp)value);
            return str;
        }
        if (value instanceof java.sql.Date)
        {
        	System.out.println("fdsfdsfdsf");
            String str = new SimpleDateFormat(format).format((java.sql.Date) value);
        }
        
        return value.toString();
    }
}

