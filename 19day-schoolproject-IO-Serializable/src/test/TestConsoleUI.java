package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import school.SchoolConsoleUI;

public class TestConsoleUI {
	public static void main(String[] args) {		
	
			try {
				new SchoolConsoleUI().execute();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
