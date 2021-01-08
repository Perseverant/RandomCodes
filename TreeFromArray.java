/**  THIS IS NOT AN OPTIMIZED CODE BUT YOU CAN FURTHER OPTIMIZED (SPEED AS WELL AS MEMORY) THIS BY REMOVING UNNECESSARY VARIABLE  */
/**  LET ME KNOW IF IT FAILS ANY  TESTCASE BUT FROM MY SIDE IT WORKS VERY WELL......  */


import java.util.*;

public class TreeFromArray {
    public static void main(String[] args) {
        int[] num1= {1,3,3,5,5,7,6,6};
        int[] num2= {3,2,4,1,8,5,2,9};
        
        /**
        *   Here num1 & num2 is the list nodes and node at ith index in num1 is connected to node at
        *   ith index in num2.
        *   
        *   Here edge list points to the nth edge which is going to cut i.e., we have to find the maximum
        *   size of the tree after cutting a particular edge which results into two sub-trees.
        * 
        *   in edge list, 1st element which is 1 refers to 1st edge or 2nd element 
        *   which is 3 refers to 3rd edge.
        * 
        *   Step of solving this problem:
        *   1. we first merge the two list into one list(res) in parent child fashion- 
        *   res = {1,3,3,2,3,4,5,1,5,8,7,5,6,2,6,9}
        * 
        * */
        
        
        int[] res = new int[num1.length + num2.length];
        int[] edge = {1,3};

        List<Integer> result = new ArrayList<Integer>
                ( Collections.nCopies(3*num1.length* num2.length, 0));

        int j=0;
        for(int x=0; x< num1.length; x++){
            res[j] = num1[x];
            res[j+1] = num2[x];
            j=j+2;  
        }
    /**
    *   
    *   here we first list called as result and initialize them all  to  zero.
    * 
    *   Here tree formation starts, in which it first check ith element is present or not. if it is 
    *   present then it add (i+1)th element as child  to the ith element otherwise we simply add 
    *   the ith element and then add (i+1)th element as their child
    * 
    * */
        
    //Tree formation starts*
        
        int i=0, x=0;
        while( i < res.length){

            if(result.contains(res[i])) {
                int temp = result.indexOf( res[i] );
                if (result.get(2*temp + 1)==0){
                    result.set(2*temp + 1, res[i+1]);
                }else {
                    result.set(2*temp + 2, res[i+1]);
                }

                x=x+1;

            } else if (result.contains(res[i+1])){
                int temp = result.indexOf( res[i+1] );
                if (result.get(2*temp + 1)==0){
                    result.set(2*temp + 1, res[i]);
                }else {
                    result.set(2*temp + 2, res[i]);
                }

                x=x+2;

            } else {
                result.add(x,res[i]);
                int temp = result.indexOf(res[i]);
                if (result.get(2*temp + 1)==0){
                    result.set(2*temp + 1, res[i+1]);
                }else {
                    result.set(2*temp + 2, res[i+1]);
                }

                x=x+2;
            }
            i = i+2;
        }

        int index=0;
        for (int ii=0; ii<result.size(); ii++) {
            if (result.get( ii )!=0){ index=ii; }
        }
        
//        System.out.println(result.toString());

        /**  Here we are trim out trailing zeroes from the list   */

        result = result.subList( 0,index+1 );
        System.out.println(result.toString());
        System.out.println(result.size());

        List<Integer> cutPos = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int temp =0, s=0;
        int node1Index=0, node2Index=0;

        for (int e:edge) {
            int cut = e-1;
            int node1 = num1[cut];
            int node2 = num2[cut];
            node1Index = result.indexOf( node1 );
            node2Index = result.indexOf( node2 );
            cutPos.add( node1Index );
            cutPos.add( node2Index );
            
            /** here we call the traverse the tree   **/

            s = TraverseTree(result, node1Index, node2 );
            sizes.add( s );
            if (s>temp){temp=s;}

            s = TraverseTree(result, node2Index, node1 );
            sizes.add( s );
            if (s>temp){temp=s;}

        }

//        System.out.println(sizes.toString());
//        System.out.println("max size: "+temp);
//        System.out.println(cutPos.toString());

    }
    
    /**  this is the tree traversal method  */

    private static int TraverseTree(List<Integer> result, int pos, int target) {

        if (pos<0 || pos >=result.size() || result.get( pos )==target ){
            return 0;
        }

        int left = TraverseTree(result, 2*pos+1, target);
        int right = TraverseTree( result, 2*pos+2, target);

        if (result.get( pos )==0){
            return left + right;
        }else {
            return left + right + 1;
        }

    }
}
