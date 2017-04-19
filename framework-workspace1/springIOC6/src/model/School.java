package model;

import java.util.ArrayList;
import java.util.HashMap;

public class School {
	private ArrayList<String> studentNameList;
	private ArrayList<Bus> busList;
	private HashMap<String, Bus> busMap;
	public ArrayList<String> getStudentNameList() {
		return studentNameList;
	}
	//Spring container로부터 ArrayList를 주입받는다.
	public void setStudentNameList(ArrayList<String> studentNameList) {
		this.studentNameList = studentNameList;
	}
	public ArrayList<Bus> getBusList() {
		return busList;
	}
	public void setBusList(ArrayList<Bus> busList) {
		this.busList = busList;
	}
	public HashMap<String, Bus> getBusMap() {
		return busMap;
	}
	public void setBusMap(HashMap<String, Bus> busMap) {
		this.busMap = busMap;
	}
	
}
