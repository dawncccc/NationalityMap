/*
 * 
 * Copyright(c) 田岑熙  TianCenXi tiancenxi@126.com 2016.10.03-
 * 
 * 
 */

package dawn.tinymap.jersey.api;
import javax.ws.rs.core.MediaType;

import dawn.tinymap.db.EthnicDAO;
import dawn.tinymap.bean.*;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Path("/ethnic")//the route is to be resolved
@Singleton
public class EthnicAPI 
{
	@GET //assigin the function blow used for the  application GET
	@Produces(MediaType.APPLICATION_JSON)
	//IS EQUAL TO THE STATEMENT:Content-Type:application/json
	
	public String getNationList() throws SQLException//get the whole information for the icon
	{
		List<Outline> list = EthnicDAO.getOutlineList();
		JSONArray jsonarray = JSONArray.fromObject(list);
		return jsonarray.toString();
	}
	
	@GET 
	@Path("/province_1")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSecondList(@QueryParam("ethnic_name") String ethnic_name) throws Exception
	{
		List<province> list = EthnicDAO.getProvinceList(ethnic_name);
		JSONArray jsonarray = JSONArray.fromObject(list);
		return jsonarray.toString();
	}

}
