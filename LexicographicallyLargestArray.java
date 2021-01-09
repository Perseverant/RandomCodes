
/***   INTERVIEWBIT CONTEST RPBLEM SOLUTION.. PRBLEM : LEXICOGRAPHICALLY LARGEST ARRAY */

/*** THIS IS ONLY FOR LEARNING PURPOSE */

/**  IT IS SIMPLY LEXICOGRAPHIC PROBLEM IN WHICH DATA IS GIVEN IN ARRAY FORMAT
*   YOU WERE ASKED TO CREATE AN ARRAY S = X + REVERSE OF Y IN WHICH X IS PREFIX OF ARRAY & Y IS POSTFIX
*   LEN(S)<= LEN(A)
*   NOTE THAT :  X & Y CAN BE EMPTY
*
*/

public class Solution {
    public int[] solve(int[] A) {
        
        if (A.length==1){
            return A;
        }

        int last = A[A.length-1];
        int index=-1;
        int i=0;
        
        while(i < A.length){
            if (A[i]<last){ index=i; break;}
            i++;
        }

        if (index ==-1 ){ return A; }

        int  start=index, stop = A.length-1;

        if(index == A.length-1){ start=0; }

        while(start<stop){
            int temp = A[start];
            A[start] = A[stop];
            A[stop] = temp;

            stop--;
            start++;
        }

         return A;
    }
}

