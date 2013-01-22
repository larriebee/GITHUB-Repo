<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List Items</title>
		<%@ include file="header.jsp" %>
	</head>
	<body>
		<jsp:include page="templateBeforeContent.jsp" />
		
		<c:if  test="${!empty items}">
			<table>
				<thead>
					<tr><td colspan="6"><h2>List of Items</h2></td></tr>
				</thead>
				<tbody>
				<tr>
    				<th>Item Id</th>
    				<th>Title</th>
    				<th>Author</th>
    				<th>Edition</th>
    				<th>Publish Date</th>
    				<th>Loanable</th>
    			</tr>
				<c:forEach items="${items}" var="item">
					<tr>
						<td>${item.itemId}</td>
						<td>${item.title}</td>
						<td>${item.author}</td>
						<td>${item.edition}</td>
						<td>${item.publishDate}</td>
						<td>${item.loanable}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>	
		<c:if  test="${empty items}">
		
			<h2>You currently have no Items</h2>
		
		</c:if>

		<jsp:include page="templateAfterContent.jsp" /> 

	</body>
</html>