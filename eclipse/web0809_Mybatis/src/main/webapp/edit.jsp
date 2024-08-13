<%@page import="java.util.HashMap"%>
<%@page import="shop.Product"%>
<%@page import="shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("update"));
	Double total = (Double)session.getAttribute("total");
	ProductDAO productDAO = new ProductDAO();
	Product product = productDAO.getProductById(num);

	// 세션에서 장바구니 가져오기
	HashMap<String, Product> cart = null;
	Object cartObject = session.getAttribute("cart");
	if (cartObject instanceof HashMap<?, ?>) {
	    // 타입 검사를 통과한 경우에만 캐스팅
	    @SuppressWarnings("unchecked")
	    HashMap<String, Product> tempCart = (HashMap<String, Product>) cartObject;
	    // 추가적인 검사: 키와 값의 타입이 정확한지 확인
	    if (tempCart.size() > 0 && 
	        tempCart.keySet().iterator().next() instanceof String &&
	        tempCart.values().iterator().next() instanceof Product) {
	        cart = tempCart;
	    }
	}
	
	if (cart == null) {
        cart = new HashMap<>();
    }
	
	if(total == null){
		total = 0.0;
		session.setAttribute("total", total);
	}
	
	// 물건이 1개 이상 있으면
    if (product.getStock() > 0) {
    	// 갯수 1개 빼서 DB 저장
    	int newStock = product.getStock() -1;
   		product.setStock(newStock);
    	productDAO.updateProduct(product);
        
        // 가격, 물건 이름
        double price = product.getPrice();
        String productName = product.getName();
        
        if (cart.containsKey(productName)) {
            Product cartProduct = cart.get(productName);
            int count = cartProduct.getStock() + 1;
            cartProduct.setStock(count);
            cart.put(productName, cartProduct);
            total += price;
        } else {
          	cart.put(product.getName(),new Product(0,productName,product.getDescription(),price,1));
           	total += price;
        }
        session.setAttribute("cart", cart);
        session.setAttribute("total", total);
    }
%>
<jsp:forward page="products.jsp"/>