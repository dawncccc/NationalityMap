package tDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DbUtil;



import bean.Outline;
import bean.Point;




//用于分布部分的数据获取
public class DistributionDao {
	
//	这里是能够返回所有的outline里面的数组 然后取到每个点的所有值
	public List<Outline> getOutlineList(Connection con,Outline o_outline)throws Exception {
	 List<Outline> outlineList = new ArrayList<Outline>();
	
	PreparedStatement smt =  con.prepareStatement("select * from outline");
	ResultSet rs = smt.executeQuery();
//	System.out.println("这是调试===================");
	while(rs.next()){
		int nid = rs.getInt("nid");
		String ethnic = rs.getString("ethnic");
		String mj_name = rs.getString("mj_name");
		double majority_x = rs.getDouble("majority_x");
		double majority_y = rs.getDouble("majority_y");
		int mapOffset_x = rs.getInt("mapOffset_x");
		int mapOffset_y = rs.getInt("mapOffset_y");
		int mapSize_x = rs.getInt("mapSize_x");
		int mapSize_y = rs.getInt("mapSize_y");
		int mapAnchor_x = rs.getInt("mapAnchor_x");
		int mapAnchor_y = rs.getInt("mapAnchor_y");
		String imgPath = rs.getString("imgPath");
		String sightPath = rs.getString("sightPath");
		String brief = rs.getString("brief");
		

//		System.out.println(nid);
//		System.out.println(ethnic);
//		System.out.println(mj_name);
//		System.out.println(majority_x);
//		System.out.println(majority_y);
//		System.out.println(mapOffset_x);
//		System.out.println(mapOffset_y);
//		System.out.println(mapSize_x);
//		System.out.println(mapSize_y);
//		System.out.println(mapAnchor_x);
//		System.out.println(mapAnchor_y);
//		System.out.println(imgPath);
//		System.out.println(sightPath);
//		System.out.println(brief);



		Outline ol = new Outline();
		
		ol.setNid(nid);
		ol.setEthnic(ethnic);
		ol.setMj_name(mj_name);
		ol.setMajority_x(majority_x);
		ol.setMajority_y(majority_y);
		ol.setMapOffset_x(mapOffset_x);
		ol.setMapOffset_y(mapOffset_y);
		ol.setMapAnchor_x(mapAnchor_x);
		ol.setMapAnchor_y(mapAnchor_y);
		ol.setMapSize_x(mapSize_x);
		ol.setMapSize_y(mapSize_y);
		ol.setImgPath(imgPath);
		ol.setSightPath(sightPath);
		ol.setBrief(brief);
		
		outlineList.add(ol);
	}
	//System.out.println("=====================");
	return outlineList;
	}
 
 
	 
	 //这个是得到一级联动的菜单 这个动作应该在初始化页面的时候就应该加入
   public List<String> getPrimaryList(Connection con) throws Exception{
	   List<String> getPL = new ArrayList<String>();
	   PreparedStatement smt =  con.prepareStatement("select ethnic from outline");
		ResultSet rs = smt.executeQuery();
	//	System.out.println("这是调试===================");
		while(rs.next()){
			String ethnicName = rs.getString("ethnic");
			
		
//			System.out.println(ethnicName);
		
			
			getPL.add(ethnicName);
		}
	//	System.out.println("=====================");
		return getPL;
		}
   
   
   //在这里的时候应该已经得到了一级菜单里面的民族的值，所以应该传入一个民族的字符串值
   public  List<String>  getSecondList(Connection con,String etnName) throws Exception{
	   List<String> getSL = new ArrayList<String>();
	   String sql = "select  province  from view_option where ethnic=? ";
	   PreparedStatement smt =  con.prepareStatement(sql);
	     smt.setString(1,etnName);
		ResultSet rs = smt.executeQuery();
		System.out.println("这是调试===================");
		System.out.println(etnName);
		
		while(rs.next()){
			String provinceName = rs.getString("province");
			
			System.out.println("****");
		
			System.out.println(provinceName);
		
			
			getSL.add(provinceName);
		}
      
		 System.out.println("=====================");
   return  getSL;
   }

   //得到选择一级联动框之后所筛选得到的点 
   public List<Point> getFristPoints(Connection con,String etnName) throws Exception{
	   List<Point> FPList = new ArrayList<Point>();
	   String  sql="select point_x,point_y from detail where address in "
	   		+ " (select address from optionList where province in (select  province "
	   		+ " from view_option where ethnic =?))";
	   PreparedStatement smt = con.prepareStatement(sql);
	   smt.setString(1,etnName);
	   ResultSet rs = smt.executeQuery();	    
		//System.out.println("这是调试===================");
	   while(rs.next())
	   {
		    Point point = new Point();
		    
		    double point_x = rs.getDouble("point_x");
		    double point_y = rs.getDouble("point_y");
		    
	
			System.out.println(point_x);
			System.out.println(point_y);
		
		    
		    point.setX(point_x);
		    point.setY(point_y);
		    
		    FPList.add(point);
		    
	   }	
	 //  System.out.println("=====================");
	  return FPList;
	   }
   
   //得到两级联动过后的点
   public  List<Point> getSecondPoints(Connection con,String etnName,String pvcName) throws Exception{
	   List<Point> SPList = new ArrayList<Point>();
	   String sql ="select point_x,point_y  from detail where address  in" +
	   		" (select address from optionList where ethnic=? and province=?)";
	   PreparedStatement smt = con.prepareStatement(sql);
	   smt.setString(1,etnName);
	   smt.setString(2,pvcName);
	   ResultSet rs = smt.executeQuery();
	  // System.out.println("这是调试===================");
	   while(rs.next()){
		   double point_x = rs.getDouble("point_x");
		   double point_y = rs.getDouble("point_y");
		   
		 
			System.out.println(point_x);
			System.out.println(point_y);
		
		   
		   Point point = new Point();
		   
		   point.setX(point_x);
		   point.setY(point_y);
		   
		   SPList.add(point);
	   }
	  // 	System.out.println("=====================");
	 return SPList;
   }
   
   public static void main(String[] args) throws Exception{
		Connection con = null;
		DbUtil dbUtil = new DbUtil();
		Outline outLine = new Outline();
		con=dbUtil.getCon();
		String etnName = "藏族";
		String pvcName = "四川";
		
	
		
		
   }
}
