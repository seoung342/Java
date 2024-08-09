<%@page import="java.util.HashMap"%>
<%@page import="shop.Product"%>
<%@page import="shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("update"));
	ProductDAO productDAO = new ProductDAO();
	Product product = productDAO.getProductById(num);
	if(session.getAttribute("total") == null){
		session.setAttribute("total", 0.0);
	}
        int first = product.getStock();
        String id = String.valueOf(product.getId());
        if (product.getStock() > 0) {
            product.setStock(first - 1);
            productDAO.updateProduct(product);

            HashMap<String, Product> cart = (HashMap<String, Product>) session.getAttribute("cart");
            if (cart == null) {
                cart = new HashMap<>();
            }
            if (cart.containsKey(product.getName())) {
            	int count = (Integer)session.getAttribute(id) + 1;
            	double price = (Double)session.getAttribute(id+'*');
				if(session.getAttribute("total") != null){
					double a = (Double)session.getAttribute("total") + price;
					session.setAttribute("total", a);
				}
                cart.put(product.getName(),new Product(0,product.getName(),product.getDescription(),product.getPrice(),count));
                session.setAttribute(id,count);
            } else {
            	cart.put(product.getName(),new Product(0,product.getName(),product.getDescription(),product.getPrice(),1));
            	session.setAttribute(id,1);
            	session.setAttribute(id+'*',product.getPrice());
            	if(session.getAttribute("total") != null){
					double a = (Double)session.getAttribute("total") + product.getPrice();
					session.setAttribute("total", a);
				}
            }
            session.setAttribute("cart", cart);
        }
    
%>
<jsp:forward page="products.jsp"/>