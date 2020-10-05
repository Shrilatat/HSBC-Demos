<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
response.resetBuffer();
response.setContentType("text/xml");

String str="<items><item>pepsi</item><item>coke</item><item>thumps up</item><item>limca</item><item>sprite</item></items>";
out.print(str);
%>
