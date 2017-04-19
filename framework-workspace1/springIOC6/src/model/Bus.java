package model;

public class Bus {
	private String model;
	private int seat;
	public Bus(String model, int seat) {
		super();
		this.model = model;
		this.seat = seat;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "Bus [model=" + model + ", seat=" + seat + "]";
	}
	
}
