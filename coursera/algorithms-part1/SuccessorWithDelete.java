package Alg;
/*
 * Given a set of n integers S={0,1,...,n-1} and a sequence of requests of the following form:
 *Remove x from S
 *Find the successor of x: the smallest y in S such that y>=x.
 *design a data type so that all operations (except construction) take logarithmic time or better in the worst case.
 */



/* 
 * Solution: For example in set {1,2,3,4}, 2 is removed then we can use weighted union-find to connect 1-2-3 ,
 * and we can say 3 is the element we want.
 * We can use class UnionFindwithSpecificCanonicalElement to help us find '3'.
 */

public class SuccessorWithDelete {
	private  int number;   //the number of integers in the set
    private  UnionFindwithSpecificCanonicalElement uf; //use it to find the successor(y) of x
	private boolean[] removed;  //check x is removed or not
	
	
	public SuccessorWithDelete(int num){
		number = num;
		removed = new boolean[num];
		for(int i=0; i<num ; i++){
			removed[i] = false;
		}
		uf=new UnionFindwithSpecificCanonicalElement(num);
	}
	
	public void remove(int i){
		removed[i] = true;
		if(i-1>=0 && !removed[i-1])   uf.union(i, i-1);
		if(i+1<number  && !removed[i+1])   uf.union(i, i+1);
	}
   public int find(int i){
	   
	  if(!removed[i]){
		  System.out.println("i haven't been removed");
		  return -1;
	  }
	  int y = uf.find(i);
	  if(y>i&&!removed[y]){
		  return y;
	  }else{
		  System.out.println("Out of the range");
		  return -1;
	  }
   }
   
   public static void main(String[] args) {
	   SuccessorWithDelete test = new SuccessorWithDelete(10);
       test.remove(2);
       System.out.println(test.find(2) == 3);    //true
       test.remove(3);
       System.out.println(test.find(2) == 4);     //true
       System.out.println(test.find(8) == 8);     //i haven't been removed  + false
       test.remove(8);
       System.out.println(test.find(8) == 9);     //true
       test.remove(9);
       System.out.println(test.find(8) == -1);    //out of range + true
       test.remove(5);
       test.remove(4);
       System.out.println(test.find(3) == 6);     //true
   }
}
