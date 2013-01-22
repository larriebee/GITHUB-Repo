<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Loan</title>
		<%@ include file="header.jsp" %>
	</head>
	<body>
		<jsp:include page="templateBeforeContent.jsp" />
		
		<br/><h2>Confirm the details of your Loan</h2><br/>
		
		<h3>Borrower Name: ${borrower.name}</h3>
		<h3>Item Title: ${item.title}</h3>
		
		<form:form  method="post" action="addLoanSubmission.html" commandName="loan">
			<table>
			    <tr>
			    	<td><form:hidden path="borrowerId" value="${borrower.borrowerId}" />
			    	<td><form:hidden path="itemId" value="${item.itemId}" />
			    </tr>
			    <tr>
			        <td colspan="2">
			            <input type="submit" value="Add Loan" class="submitButton"/>
			        </td>
			    </tr>
			</table>
		</form:form>


		<jsp:include page="templateAfterContent.jsp" /> 

	</body>
</html>