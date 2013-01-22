<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home</title>
		<%@ include file="header.jsp" %>
	</head>
	<body>
		<jsp:include page="templateBeforeContent.jsp" />
			
		<!--form:form method="POST" action="/HelloForms/addStudent"-->
   
			<table>
				<tr>
					<td><label><h3>Search for Books</h3></label><br/></td>
				</tr>
				<tr>
					<td colspan="1" ><input type="text" value="Enter Search Criteria..." 
						   onfocus="if(this.value == this.defaultValue) this.value = ''" size="50"/>
					</td>
				</tr>
			    <tr>
					<td>
				    	<input name="search_type" type="radio" />
				    </td>
				    <td>
				    	<label>By Title</label>
				    </td>
				</tr>
				<tr>
					<td>
					    <input name="search_type" type="radio" />By Author
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Search" class="submitButton"/>
					</td>
				</tr>
			    <tr>
				    <td colspan="2"></td>
				</tr>
				
			</table>  
			<table>
				<thead>
					<tr>
						<td><label><h3>Search for Books</h3></label><br/></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="1">
						<input type="text" value="Enter Search Criteria..." 
						   onfocus="if(this.value == this.defaultValue) this.value = ''" maxlength="100" size="100"/>
						</td>
					</tr>
					<tr>
						<td>
							<input name="search_type" type="radio" />By Title
						</td>
					</tr>
					<tr>
						<td>
							<input name="search_type" type="radio" />By Author
						</td>
					</tr>
				</tbody>
			</table>
			
			<!-- Start of Queen's University Library QCAT search box code -->
<form action="https://qcat.library.queensu.ca/vwebv/search" method="get">
<label for="qcat-input">Search QCAT:</label><br />
<input name="searchArg" id="qcat-input" />
<select name="searchCode" size="1" >
<option selected="selected" value="GKEY^">Keyword</option>
<option value="CMD">Keyword Boolean</option>
<option value="TKEY^">Title Keyword</option>
<option value="TALL">Title Exact</option>
<option value="JALL">Journal Title Exact</option>
<option value="NAME+">Author</option>
<option value="SUBJ+">Subject Heading</option>
<option value="CALL">Call Number</option>
</select>
<input value="25" name="recCount" type="hidden" />
<input value="1" name="searchType" type="hidden" />
<input value="Search" type="submit" />
</form>
<!-- End of Queen's University Library QCAT search box code -->
			
		<!--/form:form-->
            
		<br/><br/>
		
		<jsp:include page="templateAfterContent.jsp" /> 

	</body>
</html>