package p1;

public class TestPerson {
	public static void main(String[] args) {

		Person p1 = new Person();
		p1.setId(101);

		try {
			p1.setPname(null);
		} catch (InvalidNameException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(p1);

	}
}
