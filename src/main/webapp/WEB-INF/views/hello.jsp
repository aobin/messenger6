<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<body>
<h2>hello</h2>

sessionID=<%=session.getId()%>,name=<%=session.getAttribute("name")%><br>

查看session的值：<a href="/">Jersey resource</a>

</body>
</html>
