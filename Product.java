
public class Product {
	int prodId;
	String desc;

	public Product(int prodId, String desc) {
		this.prodId = prodId;
		this.desc = desc;
	}

	public Product() {}

	public void displayDetails() {
		System.out.println("Id : " + prodId + "  Desc : " + desc);
	}

}
