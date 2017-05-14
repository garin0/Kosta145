package org.kosta.springmvc16.model;

public class StockVO {
	private String symbol;
	private int price;
	public StockVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StockVO(String symbol, int price) {
		super();
		this.symbol = symbol;
		this.price = price;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "StockVO [symbol=" + symbol + ", price=" + price + "]";
	}
	
}
