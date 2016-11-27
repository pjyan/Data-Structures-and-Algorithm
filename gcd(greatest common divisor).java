package yan;

public class One{
   
	public static void main(String[] args){
           System.out.println(gcd(45,15));
		
    }
	public static long gcd(long a,long b){
		while(b != 0){
			long c = a % b;
			     a = b;
			     b = c;
		}
		return a;
	}
} 