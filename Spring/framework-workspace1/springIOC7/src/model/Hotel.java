package model;

public class Hotel implements Residence {
	private String hotelName;
	private int cost;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public void reside() {
		System.out.println(hotelName + " " + cost + "만원");
	}

}
