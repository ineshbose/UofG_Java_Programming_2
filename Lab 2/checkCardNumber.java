// Inesh Bose
// 2504266B

boolean checkCardNumber (String cardNumber) {
	
	boolean finalResult=false,checkLength=false,checkDigit=false;
	int remainder=0,firstTwo = Integer.valueOf(cardNumber.substring(0,2));
	String cardType;
	
	// Step 1: Determining Issuing Network of the Card
	
	if(firstTwo>=40 && firstTwo<=49){
		
		cardType="Visa";
		
	}
	
	else if(firstTwo==34 || firstTwo==37){
		
		cardType="American Express";
		
	}
	
	else if((firstTwo>=51 && firstTwo<=55) || (firstTwo>=2221 && firstTwo<=2720)){
		
		cardType="MasterCard";
		
	}
	
	else{
		
		cardType="Unknown";
		
	}
	
	// Step 2: Checking Length of the Card Number
	
	switch(cardNumber.length()){
		
		case 13:
		case 19:
		
			if(cardType.equals("Visa")){
				
				checkLength=true;
				
			}
			
			break;
			
		case 15:
		
			if(cardType.equals("American Express")){
				
				checkLength=true;
				
			}
			
			break;
			
		case 16:
		
			if(cardType.equals("Visa") || cardType.equals("MasterCard")){
				
				checkLength=true;
				
			}
			
			break;
			
		default: checkLength=false;
	
	}
	
	// Step 3: Checking Valid Card Number
	
	for(int i=cardNumber.length()-1;i>=0;i--){
		
		if(cardNumber.length()%2!=0){
			
			if(i%2!=0){
				
				int doubleValue=2*Character.getNumericValue(cardNumber.charAt(i));
				if(doubleValue>9){
					
					doubleValue-=9;
					
				}
				
				remainder+=doubleValue;
				
			}
			
			else{
				
				remainder+=Character.getNumericValue(cardNumber.charAt(i));
				
			}
			
		}
		
		else{
			
			if(i%2==0){
				
				int doubleValue=2*Character.getNumericValue(cardNumber.charAt(i));
				if(doubleValue>9){
					
					doubleValue-=9;
					
				}
				
				remainder+=doubleValue;
				
			}
			
			else{
				
				remainder+=Character.getNumericValue(cardNumber.charAt(i));
				
			}
			
		}
		
	}
	
	if(remainder%10==0){
		
		checkDigit=true;
		
	}
	
	else{
		
		checkDigit=false;
		
	}
	
	// Step 4: Checking all factors & computing result
	
	if(checkLength == true && checkDigit==true && !cardType.equals("Unknown")){
		
		finalResult=true;
		
	}
	
	return finalResult;
	
}