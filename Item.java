
public class Item extends Product{
	
	int warrenty, cost;
	String mfr;
	
	
	public Item(int prodId, String desc, int warrenty, int cost, String mfr) {
		super(prodId, desc);
		this.warrenty = warrenty;
		this.cost = cost;
		this.mfr = mfr;
	}


	public void displayDetails() {
		super.displayDetails();
		System.out.println("Warr : "+ warrenty + " Mfr : " + mfr);
	}

}
