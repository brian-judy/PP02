package PP2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

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
	public static void main(String[] args) throws FileNotFoundException {

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
		
		for (int i = 0; i < n; i++) {
			String fName;
			String lName;
			int id;
			double amount;
			CreditCard card;
			String number;
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
			try {lName = JOptionPane.showInputDialog("Enter customer's last name");
						
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
		else if (id == 0)
			System.exit(0);
		else
			break;
		}//while
		
				
		//Enter purchase amount
		while (true) {
		try {
		amount = Double.parseDouble(JOptionPane.showInputDialog("Enter purchase amount"));
		if (amount < 0)
			throw new Exception();
			break;
		} catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Catch: Invalid Input");

		}// end catch
	   }// end while

		while(true){
		try{
		number = JOptionPane.showInputDialog("Enter card number");
		if (Long.parseLong(number) < 0)
			throw new Exception();
		if(!(validating.aValidNumber(number)))
			throw new Exception();
			break;
		} catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Catch: Invalid Input");

		}// end catch
	   }// end while
		
		while (true) {
		try {
		expDate = JOptionPane.showInputDialog("Enter expiration date number");
		if (expDate == "")
			throw new Exception();
			break;
		} catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Catch: Invalid Input");

		}// end catch
	   }// end while
		
		//Take user input to instantiate a new CreditCard class
		CreditCard newCard = new CreditCard(Long.parseLong(number), expDate);

		//Take user input to instantiate a new Customer class
		Customer newCustomer = new Customer(fName, lName, id, amount, newCard);
		
		//add the new Customer class to the customers array
		addCustomer(newCustomer);
		
	}// end for

	displayStat();
	
	writeToFile();
		
	}//end main

}//end class
