<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List Borrowers</title>
		<%@ include file="header.jsp" %>
	</head>
	<body>
		<jsp:include page="templateBeforeContent.jsp" />
		
		<c:if  test="${!empty borrowers}">
			<form  method="get" action="listBorrowersSubmission.html">
			<table>
				<thead>
					<tr><td colspan="5"><h2>List of Borrowers</h2></td></tr>
				</thead>
				<tbody>
				<tr>
					<th>Selection</th>
    				<th>Borrower Id</th>
    				<th>Name</th>
    				<th>Email</th>
    				<th>Blacklisted</th>
    				<th>Strikes</th>
    			</tr>
				<c:forEach items="${borrowers}" var="borrower">
					<tr>
						<td class="checkbox"><input type="radio" name="borrowerSelection" value="${borrower.borrowerId}" class="checkbox"/></td>
						<td>${borrower.borrowerId}</td>
						<td>${borrower.name}</td>
						<td>${borrower.email}</td>
						<td>${borrower.blacklisted}</td>
						<td>${borrower.strikes}</td>
					</tr>
				</c:forEach>
				<tr>
			        <td colspan="2">
			           	<input type="submit" value="Update Borrower" class="submitButton"/>
			        </td>
			        <td colspan="2">
			           	<input type="submit" value="Remove Borrower" class="submitButton"/>
			        </td>
			        <td colspan="2">
			           	<input type="submit" value="New Borrower" class="submitButton"/>
			        </td>
			    </tr>
				</tbody>
			</table>
			</form>
		</c:if>	
		<c:if  test="${empty borrowers}">
		
			<h2>You currently have no Borrowers</h2>
		
		</c:if>

		<jsp:include page="templateAfterContent.jsp" /> 

	</body>
</html>