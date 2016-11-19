package yan;

import java.util.Scanner;
public class HelloWorld{
    private static Scanner name;

 public static void main(String[] args){
       name = new Scanner(System.in);
      int a = name.nextInt();
      System.out.println(abc(a));      
}

 public static int abc(int b){
	 if(b<2)
		 return b;
      return b%2+abc(b/2);
	 
 }
 

}
//如果它是偶数，那么n的二进制中1的个数与n/2中1的个数是相同的
//如果n是奇数，那么n的二进制中1的个数是n/2中1的个数+1