package Alg;

/*
 * Social network connectivity. Given a social network containing n members and 
 * a log file containing m timestamps at which times pairs of members formed friendships, 
 * design an algorithm to determine the earliest time at which all members are connected 
 * (i.e., every member is a friend of a friend of a friend ... of a friend). 
 * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. 
 * The running time of your algorithm should be mlogn or better and use extra space proportional to n.
 */

/* 
 * Solution: Use weighted quick-union 
 * 
 */
public class SocialNetworkConnectivity {
	
    int[] id;           //the parent of the node i
    int[] sz;           //the size of node i
    int connectedNode;  //the number of connected node 
	
     public SocialNetworkConnectivity(int number){   //initialization
    	     
    	     connectedNode =1;
             id = new int[number];
             sz = new int[number];
             for(int i = 0 ; i<number ; i++){
            	 id[i]=i;
            	 sz[i]=1;
             }

    }
     public int root(int q) {                   //the root of q
		int r = id[q];
		while(id[q]!=q){
			q=r;
		}
		return q;
	}
    
	 public void union(int p,int q){            //connect p and q
   	 
   	 if(root(p)==root(q)) return;
   	 if(sz[p]<sz[q]){
   		 int a = root(p);
   		 id[a] = root(q);
   		 
   	 }else{
   		int a = root(q);
  		 id[a] = root(p);
   	 }
   	 connectedNode++;
    }
     
     public boolean connected(int p,int q){    //check weather p and q are connected 
    	 return root(p)==root(q);
     }
     
     public boolean allConnected(){             //check weather all the nodes are connected 
    	 return connectedNode==sz.length;
     }
     
     public static void main(String[] args){
    	 
    	 //SocialNetworkConnectivity  snc = new SocialNetworkConnectivity(10);
    	 // add some connection and then check it
     }

}
