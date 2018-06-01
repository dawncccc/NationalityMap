/*
 * 
 * Copyright(c) 田岑熙  TianCenXi tiancenxi@126.com 2016.10.03-
 * 
 * 
 */
package dawn.tinymap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
//import net.sf.json.*; 
import java.util.Map;
import java.util.Set;

import net.sf.json.*;//解决了jsonarray类型无法使用的问题

//import com.fasterxml.jackson.databind.ObjectMapper;
import dawn.tinymap.bean.*;

/**
 * Servlet implementation class addPiesData
 */
@WebServlet("/addPiesData")
public class addPiesData extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPiesData() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8"); 
        response.setCharacterEncoding("UTF-8");
        
		response.setContentType("text/html,charset=UTF-8");
		response.setHeader("Cache-Control","on-cache");
		PrintWriter out = response.getWriter();
		
		List<education> list = new ArrayList<education>();
		list.add(new education(23.34,"小学"));
		list.add(new education(87.4,"中学"));
		list.add(new education(12.36,"大学"));
		list.add(new education(13.08,"制造业"));
		list.add(new education(34.6,"金融、证券、保险业"));
		list.add(new education(1.36,"政府机关"));
		list.add(new education(0.96,"医药食品业"));
		list.add(new education(12.21,"旅游交通民航业"));
		list.add(new education(8.03,"IT通讯业"));
		list.add(new education(45.79,"商贸业"));
		list.add(new education(58.16,"其他"));
		
	    JSONArray jsonArray = JSONArray.fromObject(list);
				
			 
			// ObjectMapper mapper = new ObjectMapper();    //提供java-json相互转换功能的类--系统提示无效
		    // String json = mapper.writeValueAsString(list); //   将list中的对象转换为Json格式的数组
			//System.out.println(json);
	        
	        //将json数据返回给客户端
	        //System.out.println(jsonArray);
	        System.out.println( jsonArray.toString());
	        out.write(jsonArray.toString());
	        out.flush();
	        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
