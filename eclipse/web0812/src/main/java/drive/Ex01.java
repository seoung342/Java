package drive;

import shop.Product;
import shop.ProductDAO;

public class Ex01 {
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		Product product = new Product(2,"황도 복숭아","물복이 최고다",7868.0,777);
		dao.updateProduct(product);
		System.out.println("수정 완료");
	}
}
