package step4;

public class MyDate {
	private int day;
	private int month;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month>0 && month <13){
			this.month = month;
		}else {
			System.out.println("잘못된 월입니다.");
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(day>31 || day<1){
			System.out.println("잘못된 일입니다.");
		}else{
			this.day = day;
			//System.out.println("안녕");
		}
			
	}
}
