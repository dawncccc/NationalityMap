<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="./css/Index.css" type=text/css rel=stylesheet media=all>
<script src="./echarts-js/echarts.js"></script>
<script type=text/javascript src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
<script src="./js/jquery.min.js"></script>
<script src="./js/forEdu01.js"></script>
<title>Test</title>
</head>
 
<body>
 <div style="width:1250px;margin:0px auto;height:790px;border:#ccc solid 1px" class="mapframe">
	    
	    <div style="position:relative;top:5px;left:380px" id="menu">
		<ul> 
			<li class="yes"><a indepth="true" href="./"  title="民族分布">民族分布</a></li>
			<li ><a indepth="true" href="./edu01.html" title="教育情况">教育情况</a></li>
			<li ><a href="./emp01.html" title="就业情况">就业情况</a></li>
		</ul>		
	    </div>
    
       <select style="position:relative;top:100px;left:1130px" id="sizer_one" onchange="province()" >
              <option value ="nomean">请选择民族</option>
			  <option value ="Tibetan">藏族</option>
			  <option value ="Zhuang">壮族</option>
			  <option value="Qiang">羌族</option>
			  <option value="Yi">彝族</option>
		</select>   
		<select style="position:relative;top:220px;left:1030px" id="sizer_two" onchange="area()">
		<option value ="nomean">请选择省份</option>
		</select> 
		
     	<div style="width:950px;margin:0px auto;height:700px;border:#ccc solid 1px" id="dituContent"></div>

  </div>
</body>
</html>