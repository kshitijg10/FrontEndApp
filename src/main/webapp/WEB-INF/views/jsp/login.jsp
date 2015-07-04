<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Kshitij Gupta - Front End App</title>
 
<spring:url value="/resources/core/css/index.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
 
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Front End Dev - Kshitij Gupta</a>
	</div>
  </div>
</nav>

 
<div class="jumbotron">
  <div class="container">
    <h2>Welcome!</h2>
    <a style="font-size:8" href="/messages">[Messages]</a>
    <a style="font-size:8" href="/states">[States]</a>
    <a style="font-size:8" href="/logout">[Logout]</a>
    </div>
</div>
 
<div class="container">
 
  <div class="row">
	<div class="col-md-4">
	<table style="width:100%" border="1" >
	<tr>
	<th nowrap>State Name</th>
	<th nowrap>Capital</th>
	<th nowrap>Populous City</th>
	<th nowrap>Population</th>
	<th nowrap>Square miles</th>
	<th nowrap>Time Zone 1</th>
	<th nowrap>Time Zone 2</th>
	<th nowrap>DST</th>
	
	</tr>
	   <c:forEach var="state" items="${states}"> 
	    
  <tr>
    <td><a href="/state/${state.abbreviation}" ><c:out value="${state.name}"/></a></td>
    <td><c:out value="${state.capital}"/></td>
    <td><c:out value="${state.mostPopulousCity}"/></td>
    <td><c:out value="${state.population}"/></td>
    <td><c:out value="${state.squareMiles}"/></td>
    <td><c:out value="${state.timeZone1}"/></td>
    <td><c:out value="${state.timeZone2}"/></td>
    <td><c:out value="${state.dst}"/></td>
  </tr>

		    
		    
		    
		    
		</c:forEach>
		</table> 
	</div>
  </div>
 
 
  <hr>
  <footer>
	<p>&copy; Kshitij Gupta</p>
  </footer>
</div>
 
<spring:url value="/resources/core/css/index.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />
 
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 
</body>
</html>