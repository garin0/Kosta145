package kosta.model;

public class ProductService {
	public void registerProduct() {
		System.out.println("registerProduct");
	}

	public void insertProduct(String id, String name) {
		System.out.println("insertProduct:" + id + " " + name);
	}

	public String getMaker() {
		return "LG";
	}

	public void sellProduct(int count) throws InventoryException {
		if (count < 1)
			throw new InventoryException("잘못된 상품수..");
		System.out.println("sell" + count);
	}
}
