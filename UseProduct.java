
public class UseProduct {
public static void main(String[] args) {
	Product p1 = new Item(1, "p1-desc", 10, 10, "mfr-1");
	Product p2 = new Item(2, "p2-desc", 20, 20, "mfr-2");
	
	Product p3 = new Service(3, "p3-desc", 2500);
	Product p4 = new Service(4, "p4-desc", 4000);
	
	Product p5 = new Product(101, "prod desc");
	
	
	Product[] products = {p1, p2, p3, p4, p5};
	
	for(Product p : products)
		p.displayDetails();
	
}
}
