/*
 * 
 * Copyright(c) 田岑熙  TianCenXi tiancenxi@126.com 2016.10.03-
 * 
 * 
 */
package dawn.tinymap.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dawn.tinymap.bean.education;
import dawn.tinymap.bean.province;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class addServlet
 */
@WebServlet("/addServlet")
public class addProvince extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProvince() 
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
		int i;
		request.setCharacterEncoding("UTF-8"); 
        response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html,charset=UTF-8");
		response.setHeader("Cache-Control","on-cache");
		PrintWriter out = response.getWriter();
		
		String ethnic = request.getParameter("ethnic");
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control","no-cache");
		out.println("<response>");
		ArrayList<String> list = new ArrayList<String>();
		list.add("广西");
		list.add("西藏");
		list.add("四川");
		for(i =0;i <3;i++)
		{
			out.println("<province>"+list.get(i)+"</province>");
		}
		out.println("</response>");
		/*
		List<province> list = new ArrayList<province>();
		list.add(new province("广西","西藏","四川"));
		JSONArray jsonArray = JSONArray.fromObject(list);
		response.setContentType("text/html; charset=utf-8");
		
	    System.out.println(jsonArray.toString());
		out.write(jsonArray.toString());*/
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
