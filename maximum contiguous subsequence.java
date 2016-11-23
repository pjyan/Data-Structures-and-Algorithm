package yan;
public class HelloWorld2{
	
	public static void main(String[] args){
		int[] a ={1,2,3,-4,-9,5};
		System.out.println(maxSum(a));
	}		
	public static int maxSum(int[] a){	
		int maxSum = 0;
		int thisSum = 0;
		for(int j=0;j<a.length;j++){
			thisSum += a[j];
			if(thisSum>maxSum)
				maxSum = thisSum;
			if(thisSum<0)
				thisSum =0;
		}
		return maxSum;
	}
 }
 