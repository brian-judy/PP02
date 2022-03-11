package PP2;

public class Payment {

	public static Validation validating;
	public static HashCode hashing;
	public static Customer[] customers;
	//create counter for addCustomer
	public static int i = 0;

	// this will check whether a card is valid
	public static Boolean isValidCard(String number){

		return validating.aValidNumber(number);

	}// end of the isValidCard method

	// creates a hash code for the credit card number to be stored in file
    public static String createHashCode(String number){

		return hashing.getHashCode(number);

	}// end of the createHashCode method


     // it adds a new customer to the array of customers once the payment was successful
 	 public static void addCustomer(Customer customer){

		 String fName = customer.getfName();
 		 String lName = customer.getlName();
 		 int id = customer.getId();
 		 double amount = customer.getAmount();
 		 CreditCard card = customer.getCard();
 		 customers[i] = new Customer(fName, lName, id, amount, card);
 		 i++;
 	 } // end of the addCustomer method


	// it displays the payments AVG, MAX payment, and MIN payment,
	// only for accepted payments with valid cards
	public static void displayStat(){
		double average = 0.0;
		double max = customers[0].getAmount();
		double min = customers[0].getAmount();
		double total = 0.0;
		
		for(int i = 0; i < customers.length; i++) {
			total += customers[i].getAmount();
			if(customers[i].getAmount() > max)
				max = customers[i].getAmount();
			else if (customers[i].getAmount() < min)
				min = customers[i].getAmount();
			
		}
		average = total / customers.length;
		
		JOptionPane.showMessageDialog(null, "Average payment: " + average + "\n" +
											"Max payment: " + max + "\n" +
											"Min payment: " + min);
	}// end of the displayStat method


	// write data to file, the credit card number should be encrypted
	// using one-way hash method in the Hashing class
    public static void writeToFile() throws FileNotFoundException {
		File file = new File("customers.txt");
		
		PrintWriter write = new PrintWriter(file);
		
		String outCustomers = "";
		
		for(int i = 0; i < customers.length; i++)
			outCustomers += customers.toString() + "\n";
		
		write.print(outCustomers);
		
		write.close();
    } // end of the writeToFile method


	// the main entry method of the program that will get data from user and
	// perform the business logic
	public static void main(String[] args) {

		hashing = new HashCode();
		validating = new  Validation();
               // input the number of customers and stor it into variable n
               int n; // must hold the number of customers based on the user input
		customers = new Customer[n];

	}

}
