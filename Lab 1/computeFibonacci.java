int computeFibonacci(int n){
	
	int result=1,lastResult=1;
	for(int i=0;i<n-2;i++){
		
		int temp=result;
		result+=lastResult;
		lastResult=temp;
		
		/*Here, result and lastResult are added in order to create a Fibonacci series
		where lastResult is the previous number and Result is the number after.*/
		
	}
	
	return result;
	
}