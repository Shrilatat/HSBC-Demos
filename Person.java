package p1;

public class Person {
	int id;
	String pname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) throws InvalidNameException{
		
		if(pname == null) {
			this.pname="Unknown";
			throw new InvalidNameException("No Nulls allowed in Name!!!");
		}
			 
		this.pname = pname;
	}
	

	@Override
	public String toString() {
		return "Person [id=" + id + ", pname=" + pname + "]";
	}

}
