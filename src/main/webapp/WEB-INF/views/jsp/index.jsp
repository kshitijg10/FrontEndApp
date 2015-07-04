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
    </div>
</div>
 
<div class="container">
 
  <div class="row">
	<div class="col-md-4">
	   <form action="/login" method="post">
			Username: <input name="user" id="user" type="text"  ><br>
			Password: <input name="pass" id="pass" type="password" ><br>
			<input type="submit" value="Login" >
		</form>
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