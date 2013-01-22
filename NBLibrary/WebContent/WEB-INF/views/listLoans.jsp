<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List Loans</title>
		<%@ include file="header.jsp" %>
	</head>
	<body>
		<jsp:include page="templateBeforeContent.jsp" />
		
		<c:if  test="${!empty loans}">
			<table>
				<thead>
					<tr><td colspan="7"><h2>List of Loans</h2></td></tr>
				</thead>
				<tbody>
				<tr>
    				<th>Loan Id</th>
    				<th>Start Date</th>
    				<th>End Date</th>
    				<th>Open</th>
    				<th>Overdue</th>
    				<th>Borrower</th>
    				<th>Item</th>
    			</tr>
				<c:forEach items="${loans}" var="loan" varStatus="status">
					<tr>
						<td>${loan.loanId}</td>
						<td><fmt:formatDate value="${loan.startDate}" pattern="d MMMM yyyy"/></td>
						<td><fmt:formatDate value="${loan.endDate}" pattern="d MMMM yyyy"/></td>
						<td>${loan.open}</td>
						<td>${loan.overdue}</td>
						<td>${borrowers[status.count-1].name}</td>
						<td>${items[status.count-1].title}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>	
		<c:if  test="${empty loans}">
		
			<h2>You currently have no open Loans</h2>
		
		</c:if>

		<jsp:include page="templateAfterContent.jsp" /> 

	</body>
</html>