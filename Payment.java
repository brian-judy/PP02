package PP2;

public class Payment {

	public static Validation validating;
	public static HashCode hashing;
	public static Customer[] customers;

	// this will check whether a card is valid
	public static Boolean isValidCard(String number){

		return true;

	}// end of the isValidCard method

	// creates a hash code for the credit card number to be stored in file
    public static String createHashCode(String number){

		return null;

	}// end of the createHashCode method


     // it adds a new customer to the array of customers once the payment was successful
 	 public static void addCustomer(Customer customer){

 	 } // end of the addCustomer method


	// it displays the payments AVG, MAX payment, and MIN payment,
	// only for accepted payments with valid cards
	public static void displayStat(){

	}// end of the displayStat method


	// write data to file, the credit card number should be encrypted
	// using one-way hash method in the Hashing class
    public static void writeToFile(){

    } // end of the writeToFile method


	// the main entry method of the program that will get data from user and
	// perform the business logic
	public static void main(String[] args) {


		hashing = new HashCode();
		validating = new  Validation();
               // input the number of customers and store it into variable n
               int n = 0; // must hold the number of customers based on the user input
       		
       				// input number of customers
       		while(true) {
       		try {
       			
       			n = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Customers"));
       			
       			if (n <= 0)
       				throw new Exception();
       			
       		    break;
       		
       		} catch (Exception ex){
       				JOptionPane.showMessageDialog(null, "Catch: Invalid Input, Try Again!");
       				
       			}// end catch
       		}// while
		customers = new Customer[n];
		
		for (int i = 0; i < n + 6; i++) {
			String fName;
			String lName;
			int id;
			double amount;
			CreditCard card;
			long number;
			String expDate;
			
	    //enter customer's first name
		while(true) {
		try {
			fName = JOptionPane.showInputDialog("Enter customer's first name");
		
			if (fName.isEmpty())
                 throw new Exception();
			break;
		
		} catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Catch: Invalid Input, Try Again!");
			//System.exit(0);
		}// end catch
		}// end while
	
				
		// Enter customer's last name
		while(true) {
			try {lName = JOptionPane.showInputDialog("Enter customer's first name");
						
				if (lName.isEmpty())
					throw new Exception();
			break;
			} catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Catch: Invalid Input, Try Again!");
					
				}// end catch
				}//end while
				
	
	
		// Enter customer ID
		while(true) {
		id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));
		if (id < 0) 
			JOptionPane.showMessageDialog(null, "Invalid Input");
		//else if (id == 0)
			//System.exit(0);
		else
			break;
		}//while
		
				
		//Enter purchase amount
		while (true) {
		try {
		amount = Double.parseDouble(JOptionPane.showInputDialog("Enter purchase amount"));
		if (amount < 0)
			throw new Exception();
		} catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Catch: Invalid Input");

		}// end catch
	   }// end while

		while(true){
		try{
		number = Long.parseLong(JOptionPane.showInputDialog("Enter card number"));
		if (number < 0)
			throw new Exception();
		} catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Catch: Invalid Input");

		}// end catch
	   }// end while
		
		while (true) {
		try {
		expDate = JOptionPane.showInputDialog("Enter card number");
		if (expDate == "")
			throw new Exception();
		} catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Catch: Invalid Input");

		}// end catch
	   }// end while
		
	}// end for

}
