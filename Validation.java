package validation;

public class Validation {

// Return true if the card number is valid, otherwise returns false
public boolean aValidNumber(String n) {
	long number = Long.parseLong(n);
	return  (numLength(number) >= 13) && (numLength(number) <= 16) &&
        (prefixCheck(number, 4) || prefixCheck(number, 5) ||
        prefixCheck(number, 6) || prefixCheck(number, 37)) &&
        (totalEvenNumbers(number) + totalOddNumbers(number)) % 10 == 0;
}

//get the sum of even places numbers, Starting from the second digit from right
private static int totalEvenNumbers(long number) {
	int sumEven = 0;
	int length = numLength(number);
	
	//Convert long to String to index length of card number
	String numAsString = String.valueOf(number);
	
	//Set index to length of card number
	int index = length;
	
	//Sum values at even indexes of card number
	for(int i = length - 1; i >= 0; i--) {
		if(index % 2 == 0)
			sumEven += Character.getNumericValue(numAsString.charAt(i));
		index--;
	}
	
	return sumEven;
}


private static int totalOddNumbers(long number) {
	int sumOdd = 0;
	int length = numLength(number);
	String numAsString = String.valueOf(number);
	
	//Set index to length of card number
	int index = length;
	
	//Sum values at odd indexes of card number
	for(int i = length - 1; i >= 0; i--) {
		if(index % 2 == 1)
			sumOdd += Character.getNumericValue(numAsString.charAt(i));
		index--;
	}
	
	return sumOdd;
}

//TODO finish singleDigit method
//Return the same number if it is a single digit, otherwise, return the sum of
// the two digits in this number
private static int singleDigit(int number) {
	int sumSingleDigit = 0;
	int length = numLength(number);
	boolean secondDigit = false;
	
	//Convert long to String to index length of card number
	String numAsString = String.valueOf(number);
	
	//Sum values at even indexes of card number
	for(int i = length - 1; i >= 0; i--) {
		int digit = numAsString.charAt(i) - '0';
		
		if(secondDigit == true)
			digit = digit * 2;
		
		//Add digits if doubling results in double digit number. 
        sumSingleDigit += digit / 10;
        sumSingleDigit += digit % 10;
 
        secondDigit = !secondDigit;
	}
   return sumSingleDigit;
}
	
	

//Return true if the digit d is a prefix for number
private boolean prefixCheck(long number, int d) {
	//Convert long to String to index length of card number
	String numAsString = String.valueOf(number);
	int prefix = 
	
	if(numAsString.charAt(0) == d)
		return true;
	else
		return false;
}

//TODO finish numPrefix method
private long numPrefix(long number, int k) {
	int numPrefix = 0;
	return numPrefix;
}

//Return the number of digits in this number parameter
private static int numLength (long number) {
	int numDigits = 0;
	
	//Convert long to string
	String num = String.valueOf(number);
	
	//Set numDigits to length of string
	numDigits = num.length();
	
	return numDigits;
}

	public static void main(String[] args) {
		
		long cardNo = 79927398713L;
		System.out.println("SUM EVEN: " + totalEvenNumbers(cardNo));
		System.out.println("SUM ODD: " + totalOddNumbers(cardNo));
		System.out.println("NUMBER OF DIGITS: " + numLength(cardNo));
		System.out.println("VALID PREFIX: " + prefixCheck(cardNo, prefix);

	}

}
