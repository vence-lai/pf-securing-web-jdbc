<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<link href="<c:url value="css/app.css" />" rel="stylesheet"type="text/css">
	<title>Hello World!</title>
</head>

<script
			  src="https://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script>

<body class="security-app">
	<div class="details">

		<h2>Spring Security - JDBC Authentication</h2>
		<a href="http://www.programming-free.com/2015/09/spring-security-jdbc-authentication.html" class="button green small">Tutorial</a> 
		<a href="https://github.com/priyadb/SpringSecurityJdbcApp/archive/master.zip"
			class="button red small">Download</a>
	</div>

	<div class="lc-block">
		<h1>
			Hello <b><c:out value="${pageContext.request.remoteUser}"></c:out></b>
		</h1>
		<form action="/logout" method="post">
			<input type="submit" class="button red big" value="Sign Out" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
	
	<div>
		<button type="button" onclick="get()">GET udf_header</button>
	</div>
	
	
	
	<script type="text/javascript">
	//获取服务器上的Header值
    function get() {
        $.get('hello', { },
                function (data, textStatus,resObj) {
                    //获取自定义header值
                    //$('#sid').html(resObj.getResponseHeader('SID'));
                    alert(resObj.getResponseHeader('udf_header'));
                    
                    //无法获取Set-Cookie的值
                    //alert(resObj.getResponseHeader("Set-Cookie"));
                    
                    //获取所有header值
                    //console.log(resObj.getAllResponseHeaders());
                    /*
                     * erver: Apache-Coyote/1.1
                     * SID: sid_786
                     * Content-Length: 21
                     * Date: Tue, 15 Apr 2014 14:23:48 GMT
                     */
                },'text');
    }
	
	
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>