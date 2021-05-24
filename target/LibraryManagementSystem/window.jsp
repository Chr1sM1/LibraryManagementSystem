<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2021/5/25
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String message = request.getParameter("message");
    if (message != null && !message.equals("")) {
%>
<script src="./layui/layui.all.js"></script>
<script>
    layer.msg("<%=message%>");
</script>
<%
    }
%>
</body>

</html>
