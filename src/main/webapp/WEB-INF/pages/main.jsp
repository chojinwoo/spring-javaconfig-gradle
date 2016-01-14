<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: bangae1
  Date: 2016-01-14
  Time: 오후 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<sec:authentication property="principal" var="principal"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${principal.email}</p>
<p>${principal.age}</p>
<p>${principal.name}</p>
</body>
</html>
