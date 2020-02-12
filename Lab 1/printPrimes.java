void printPrimes(int max){
	
	for(int n=2;n<=max;n++){
		
		boolean prime=true;
		for(int f=2;f<=Math.sqrt(n);f++){
			
		// Testing for factors
			
			if(n%f==0){	
				prime=false;
			}
			
		}
		
		if(prime){
			
			//Since PRIME is still true, n is a prime number and hence will be printed.
			
			System.out.println(n + " is prime");
		}
		
	}
	
}