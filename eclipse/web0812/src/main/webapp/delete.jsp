<%@page import="shop.ProductDAO"%>
<%@page import="shop.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("delete"));
	ProductDAO productDAO = new ProductDAO();
	productDAO.deleteProduct(num);
%>
<jsp:forward page="products.jsp"/>