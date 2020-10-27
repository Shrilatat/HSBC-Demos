
public class Calc {
	
	//Method overloading

	public int add(int a, int b) {
		return a + b;
	}
	
	public int add(int a, int b, int c) {
		return a + b + c;
	}
	
	public String add(String a, String b) {
		return a + b;
	}
	
	public String add(String a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		Calc c = new Calc();
		
		System.out.println(c.add(10, 20));
		System.out.println(c.add(10, 20, 30));
		System.out.println(c.add("Tulika"," Goyal"));
		System.out.println(c.add("Tulika",23));
	}
}
