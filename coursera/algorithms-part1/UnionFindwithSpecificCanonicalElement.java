package Alg;

/*
 * Union-find with specific canonical element. 
 * Add a method find() to the union-find data type 
 * so that find(i) returns the largest element in the connected component containing i. 
 * The operations, union(), connected(), and find() should all take logarithmic time or better.
 *
 * For example, if one of the connected components is {1,2,6,9}, 
 * then the find() method should return 9 for each of the four elements in the connected components.
 */


/* 
 * Solution: Use weighted quick-union 
 * 
 */
public class UnionFindwithSpecificCanonicalElement {

	
	private int[] id;  //the parent of the node i
	private int[] sz;  //the size of node i
 	private int[] max; //the largest element in the connected component containing i.
	
	public UnionFindwithSpecificCanonicalElement(int N)  //initialization
	{
	   id = new int[N];
	   sz = new int[N];
	   max = new int[N];
	   for (int i = 0; i < N; i++) {
		   id[i] = i;
		   max[i]=i;
		   sz[i]=1;
	   }
	}
	private int root(int i)                   //the root of node i
	{
	  while (i != id[i]) i = id[i];
	       return i;
	}
	public boolean connected(int p, int q)   //connect??
	{
	    return root(p) == root(q);
	}
	public void union(int p, int q)              //union
	{
	     int i = root(p);
	     int j = root(q);
	     if(i==j) return;
	     if(sz[i]>sz[j]){
	    	 id[j] =i;
	    	 max[i] = Math.max(max[i], max[j]);
	    	 max[j] = Math.max(max[i], max[j]);
	     }else{
	    	 id[i] =j;
	    	 max[i] = Math.max(max[i], max[j]);
	    	 max[j] = Math.max(max[i], max[j]);
	     }
	}
	public int find(int num){
		return max[root(num)];
	}
	
	public static void main(String[] args){
		
		// Do some test here...
	}
}
