package org.kosta.springmvc16.model;

public class SharesVO {
	private String id;
	private String symbol;
	private int quantity;
	private int total;
	
	public SharesVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SharesVO(String id, String symbol, int quantity, int total) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.quantity = quantity;
		this.total = total;
	}

	public SharesVO(String id, String symbol, int quantity) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.quantity = quantity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "SharesVO [id=" + id + ", symbol=" + symbol + ", quantity=" + quantity + "]";
	}
	
}
