
public class Emp {
	int id;
	String ename;
	Date doj;
	
	
	public Emp() {	}

	public Emp(int id, String ename, Date doj) {
		this.id = id;
		this.ename = ename;
		this.doj = doj;
	}

	public String toString() {
		return "Emp [id=" + id + ", ename=" + ename + ", doj=" + doj + "]";
	}

	public static void main(String[] args) {
		
		//Date d1 = new Date(23,9,2020);   //named obj
		
		Emp e1 = new Emp(101,"Nirmaan", new Date(23,9,2020));  //anonymous obj
		System.out.println(e1);
	}
}
