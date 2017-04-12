<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();//
    /*String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";*/
    String basePath ="http://10.10.59.72:8088"+path+"/";
%>
<html>
<body>
<h2>hello</h2>

sessionID=<%=session.getId()%>,name=<%=session.getAttribute("name")%><br>
basePath=<%=basePath%><br>
查看session的值：<a href="<%=basePath%>">Jersey resource</a>

</body>
</html>
