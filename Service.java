
public class Service extends Product {
	int charges;

	public Service(int prodId, String desc, int charges) {
		super(prodId, desc);
		this.charges = charges;
	}

	public void displayDetails() {
		super.displayDetails();
		System.out.println("Charges : " + charges);
	}

}
