<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Update Item</title>
		<%@ include file="header.jsp" %>
	</head>
	<body>
		<jsp:include page="templateBeforeContent.jsp" />
		
		<br/><h2>Enter the Item's new details</h2><br/>
		
		<form:form  method="post" action="updateItem.html" commandName="item">
			<table>
			    <tr>
			        <td><form:label path="title">Title:</form:label></td>
			        <td><form:input path="title" value="${item.title}" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="author">Author:</form:label></td>
			        <td><form:input path="author" value="${item.author}" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="edition">Edition:</form:label></td>
			        <td><form:input path="edition" value="${item.edition}" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="publishDate">Publish Date:</form:label></td>
			        <td><form:input path="publishDate" class="datepicker" value="${item.publishDate}" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="loanable">Loanable:</form:label></td>
			        <td><form:input path="loanable" value="${item.loanable}" /></td>
			    </tr>
			    <tr>
			        <td colspan="2">
			            <input type="submit" value="Update Item" class="submitButton"/>
			        </td>
			    </tr>
			</table>
		</form:form>

		<jsp:include page="templateAfterContent.jsp" /> 

	</body>
</html>