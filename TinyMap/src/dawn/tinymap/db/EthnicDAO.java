package dawn.tinymap.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import dawn.tinymap.db.DBClient;
import dawn.tinymap.bean.Outline;
import dawn.tinymap.bean.Point;
import dawn.tinymap.bean.province;

public class EthnicDAO 
{
	private static Connection conn;
	
		//1、这里是能够返回所有的outline里面的数组 然后取到每个点的所有值
	public static List<Outline> getOutlineList() throws SQLException
	{
		     conn = DBClient.getConnection();
		     String listSQL="select * from outline";
			 List<Outline> outlineList = new ArrayList<Outline>();
			try
			{
				PreparedStatement psmt = conn.prepareStatement(listSQL);
				ResultSet rs = psmt.executeQuery();
				while(rs.next())
				{
					conn.commit();
					int nid = rs.getInt("nid");
					String ethnic_name = rs.getString("ethnic_name");
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
					String ethnic_brief = rs.getString("ethnic_brief");
					
			
					Outline ol = new Outline();
					
					ol.setNid(nid);
					ol.setEthnic_name(ethnic_name);
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
					ol.setEthnic_brief(ethnic_brief);
					
					outlineList.add(ol);
				}
				psmt.close();
				rs.close();
				conn.close();
				
			}
			catch(SQLException e)
			{
				conn.rollback();
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return outlineList;
	}
 
 
	 
	 //2、选取所有民族名称
   public List<String> getPrimaryList() throws Exception
   {
	   conn = DBClient.getConnection();
	   List<String> getPL = new ArrayList<String>();
	   PreparedStatement smt =  conn.prepareStatement("select ethnic_name from outline");
		ResultSet rs = smt.executeQuery();
		while(rs.next())
		{
			String ethnic_name = rs.getString("ethnic_name");
			getPL.add(ethnic_name);
		}
		return getPL;
	}
   
   
   //3、在这里的时候应该已经得到了一级菜单里面的民族的值，所以应该传入一个民族的字符串值
   public static  List<province>  getProvinceList(String etnName) throws Exception
   {
	   conn = DBClient.getConnection();
	   List<province> getSL = new ArrayList<province>();
	   String sql = "select  province_name,sum(population) from  ethnic_option"
					+"where ethnic_name =?"
					+"group by province_name"
					+"order by population desc" 
					+"limit 0,3";
 
	   PreparedStatement smt =  conn.prepareStatement(sql);
	   smt.setString(1,etnName);
	   ResultSet rs = smt.executeQuery();
	   int count=0;
	   province pp = new province();
		while(rs.next())
		{
			count++;
			String provinceName = rs.getString("province_name");
			if(count==1)
			{
				pp.setProvince_one(provinceName);
			}
			else
			 if(count==2)
			 {
				 pp.setProvince_two(provinceName);
			 }
			else
			 if(count==3)
			 {
				 pp.setProvince_three(provinceName);
			 }
		}
		getSL.add(pp);
		return  getSL;
   }

   //4、得到选择一级联动框之后所筛选得到的点 
   public List<Point> getFristPoints(Connection con,String etnName) throws Exception{
	   List<Point> FPList = new ArrayList<Point>();
	   String  sql="select point_x,point_y from detail where address in "
	   		+ " (select address from ethnic_option where province_name in (select  province_name "
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
	  return FPList;
	   }
   
   //5、得到两级联动过后的点
   public  List<Point> getSecondPoints(Connection con,String etnName,String pvcName) throws Exception
   {
	   List<Point> SPList = new ArrayList<Point>();
	   String sql ="select point_x,point_y  from detail where address  in" +
	   		" (select address from ethnic_option where ethnic_name=? and province_name=?)";
	   PreparedStatement smt = con.prepareStatement(sql);
	   smt.setString(1,etnName);
	   smt.setString(2,pvcName);
	   ResultSet rs = smt.executeQuery();
	   while(rs.next())
	   {
		   double point_x = rs.getDouble("point_x");
		   double point_y = rs.getDouble("point_y");
		   
		   Point point = new Point();
		   
		   point.setX(point_x);
		   point.setY(point_y);
		   
		   SPList.add(point);
	   }
	 return SPList;
   }

	//6、取得就业界面需要得到的起始点
	public  Point getCapital(Connection con,String etnName) throws Exception
	{
		Point startPoint = new Point();
		String sql = "select majority_x,majority_y  from outline where ethnic_name  =?";
		PreparedStatement smt = con.prepareStatement(sql);
		smt.setString(1, etnName);
		ResultSet rs = smt.executeQuery();
		while(rs.next()){
			double startPoint_x = rs.getDouble("majority_x");
			double startPoint_y = rs.getDouble("majority_y");
			
		//	Point startPoint = new Point();
			//原来这句话是放在这里的，但是放在这里面好像变成了局部变量，返回那个地方会报错，说无法识别这个类型。
			//解决方法：放到循环外部。
			startPoint.setX(startPoint_x);
			startPoint.setY(startPoint_y);
			
			
		}
		return startPoint;
	}
	
	
	//7、通过对比就业率取得排名前三的三个点
	public List<Point> getDest(Connection con,String etnName) throws Exception
	{
		List<Point> Dest = new ArrayList<Point>();
		String sql = "select point_x,point_y  from detail " +
				"where address in (select address from ethnic_option where ethnic_name=?" +
				" order by empRate desc)";
		PreparedStatement smt = con.prepareStatement(sql);
		smt.setString(1, etnName);
		ResultSet rs = smt.executeQuery();
		while(rs.next())
		{
			double point_x = rs.getDouble("point_x");
			double point_y = rs.getDouble("point_y");
			
			Point endPoint = new Point();
			endPoint.setX(point_x);
			endPoint.setY(point_y);
			
			Dest.add(endPoint);
		}
		return Dest;
		
	}
}
