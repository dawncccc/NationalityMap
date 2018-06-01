/*
 * 
 * Copyright(c) 田岑熙  TianCenXi tiancenxi@126.com 2016.10.03-
 * 
 * 
 */
package dawn.tinymap.bean;

public class education
{
	private double edu_value;
	private String edu_name;
	
	  public education(double edu_value,String edu_name) 
	    {
	        this.edu_value = edu_value;
	        this.edu_name = edu_name;
	    }

	   public double getEdu_value() 
	    {
	        return edu_value;
	    }
	    public void setEdu_value(double edu_value)
	    {
	        this.edu_value = edu_value;
	    }
	    
	    public String getEdu_name() 
	    {
	        return edu_name;
	    }
	    public void setEdu_name(String edu_name)
	    {
	        this.edu_name = edu_name;
	    }
	  
}
