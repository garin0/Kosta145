package test;

public class TestUnit {
	public static void main(String[] args) {
		String url = " redirect:find_ok.jsp";
		if(url.trim().startsWith("redirect:")){
			System.out.println("리다이렉트!");
			System.out.println(url.trim().substring(9)); // redirect: 제외한 주소
		}else{
			System.out.println("리다이렉트 아님!"); 
		}
	}
}
