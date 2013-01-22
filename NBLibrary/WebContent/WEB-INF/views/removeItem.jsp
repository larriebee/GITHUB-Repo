<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Remove Item</title>
		<%@ include file="header.jsp" %>
	</head>
	<body>
		<jsp:include page="templateBeforeContent.jsp" />
		
		<br/><h2>Enter the title of the Item to remove</h2><br/>
		
		<p class="error">${errorMessage}</p>
		
		<form action="removeItemSubmission.html" method="get">
			<table>
			    <tr>
			        <td><label>Item title:</label></td>
			        <td><input type="text" name="title"></td>
			    </tr>
			    <tr>
			    	<td colspan="2">
			    		<input type="submit" value="Remove Title" class="submitButton">
			    	</td>
			    </tr>
			</table>
		</form>

		<jsp:include page="templateAfterContent.jsp" /> 

	</body>
</html>