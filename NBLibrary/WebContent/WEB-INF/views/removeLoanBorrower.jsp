<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ include file="taglibs.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Return Item</title>
		<%@ include file="header.jsp" %>
	</head>
	<body>
		<jsp:include page="templateBeforeContent.jsp" />
		
		<br/><h2>Select the Loan(s) that are being returned</h2><br/>
		
		<c:if  test="${!empty loans}">
		<form:form  method="post" action="removeLoanSubmission.html" commandName="loan">
			<table>
				<c:forEach items="${loans}" var="loan" varStatus="status">
				    <tr>
				        <td><input type="checkbox" name="returnedLoans" value="${loan.loanId}" class="checkbox"></td>
				        <td><label>Loan Id: ${loan.loanId}<br/>Title: ${items[status.count-1].title}<br/>Start Date: <fmt:formatDate value="${loan.startDate}" pattern="d MMMM yyyy"/><br/>End Date: <fmt:formatDate value="${loan.endDate}" pattern="d MMMM yyyy"/></label></td>
				    </tr>
			    </c:forEach>
			    <tr>
			        <td colspan="2">
			            <input type="submit" value="Return Loans" class="submitButton"/>
			        </td>
			    </tr>
			</table>
		</form:form>
		</c:if>	
		<c:if  test="${empty loans}">
		
			<h2>Borrower currently has no Loans</h2>
		
		</c:if>

		<jsp:include page="templateAfterContent.jsp" />

	</body>
</html>