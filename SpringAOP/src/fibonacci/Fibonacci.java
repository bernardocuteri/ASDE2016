package fibonacci;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class Fibonacci {
	
	private int n=1;
	
	public int compute()
	{
		if (n == 1 || n == 2) {
			return 1;
		}
		int fibo1 = 1, fibo2 = 1, fibonacci = 1;
		for (int i = 3; i <= n; i++) {
			fibonacci = fibo1 + fibo2; 
			fibo1 = fibo2;
			fibo2 = fibonacci;
 
		}
		return fibonacci; 
	}
	
	public int getFibonacciGiven(int n){
		this.n=n;
		return compute();
		
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	
}
