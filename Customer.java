package PP2;


public class Customer {
	
	private int id;
	private String fName, lName;
	private double amount;
	private CreditCard card;
	
	public Customer(String fName, String lName, int id, double amount, CreditCard card) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.id = id;
		this.amount = amount;
		this.card = card;
		
	}
	
	// add public setter/getter methods, and also the toString method
		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}
	
	// add public setter/getter methods, and also the toString method
	@Override
	public String toString() {
		return fName + "\t" + lName + "\t" + String.valueOf(id) + "\t" + String.valueOf(amount) + "\t" + card;
	}

}
