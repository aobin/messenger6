<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/myresource">Jersey resource</a>
    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey!<br>
    <%
            String sessionId = session.getId();
            %>
    sessionID=<%=sessionId%>,name=<%=session.getAttribute("name")%><br>
    查看session的值：<a href="springmvc/hello">Jersey resource</a>
</body>
</html>
