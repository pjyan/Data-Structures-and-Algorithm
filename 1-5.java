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
//�������ż������ôn�Ķ�������1�ĸ�����n/2��1�ĸ�������ͬ��
//���n����������ôn�Ķ�������1�ĸ�����n/2��1�ĸ���+1