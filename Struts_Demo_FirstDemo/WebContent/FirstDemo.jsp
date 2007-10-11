<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Try First Demo</title>
	</head>
	<body>
		<h3>
			Try First Demo
		</h3>
		<s:form action="FirstDemo">
            Secret: <s:textfield name="secret" />
			<s:submit />
		</s:form>
		
	</body>
</html>