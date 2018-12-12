<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.teamsankya.shoppingcart.dto.ProductBean"%>
   <%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
* {
    box-sizing: border-box;
}

.column {
    float: left;
    width: 33.33%;
    padding: 5px;
}

/* Clearfix (clear floats) */
.row::after {
    content: "";
    clear: both;
    display: table;
}
</style>
</head>
<body>
<div class="row">
<%
		List<ProductBean> beans = (List<ProductBean>) request.getAttribute("product");
	%>
	<ol class="foo">
		<ul><% 
			for (ProductBean bean : beans) {
		%><br>
 <li>
		<div class="column">
			<tr>
			
			<img src="images/<%=bean.getProduct_Id()%>.jpg"alt="superpen" style="width:100%"><br>
				
			</tr>
		</div>

		<%
			}
		%>

</body>
</html>