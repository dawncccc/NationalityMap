package tDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Point;



//用于就业界面所需数据获取
public class EmploymentDao {
	
	
	//取得就业界面需要得到的起始点
	public  Point getCapital(Connection con,String etnName) throws Exception{
		Point startPoint = new Point();
		String sql = "select majority_x,majority_y  from outline where ethnic  =?";
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
	
	
	//通过对比就业率取得排名前三的三个点
	public List<Point> getDest(Connection con,String etnName) throws Exception{
		List<Point> Dest = new ArrayList<Point>();
		String sql = "select position_x,position_y  from detail " +
				"where address in (select address from optionList where ethnic=?" +
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
