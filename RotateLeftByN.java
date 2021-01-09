import java.util.Arrays;
import java.util.Scanner;

public class RotateLeftByN {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        int step = sc.nextInt();

        int[] elements = new int[n];
        System.out.println( elements.length);
        for (int i = 0 ; i < n ; i++) {
            elements[i] = sc.nextInt();
        }
        step = step%n;
        

        /** Here we also use an another array to store our result but in that case time complexity=O(N)
         * and space complexity = O(N) { N*space occupied by an int}
         * 
         * METHOD -1 using boolean array to track the indexes we already visited..
         * mainly the work of boolean array comes when this condition n%step==0 will satisfy 
         * Here this method 1 is more optimized the brute force where we reduce space complexity.
         * 
         * time complexity=O(N) and space complexity = O(N) { N*space occupied by a boolean}
         * 
         * */


        int temp, count=0, prev = elements[n-1], index=n-1-step;
        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited, Boolean.FALSE);

        while ( count<n){

            if (index<0){index+=n;}

            if (index>=n){index%=n;}

            if (visited[index]){ index=(index+1)%n; prev = elements[index]; continue;}

            temp = elements[index];
            elements[index] = prev;
            prev = temp;
            visited[index]=true;
            index = index-step;

            count++;
        }
        elements[(index+n)%n] = prev;
        for (int e: elements) { System.out.print( e+ " " ); }

        /** METHOD -2 using if-else clause we reduce the space complexity but time complexity 
         * slightly increased... time complexity = O(N) and space Complexity = O(1)   */
        
        
        int temp1, i=0;
        if (n%step==0){
            int loop = n/step;
            while (i<step){
                int prev1 = elements[n-1-i], index1=n-1-step-i;
                for (int j = 0 ; j < loop ; j++) {

                    if (index1<0){index1+=n;}

                    temp1 = elements[index1];
                    elements[index1] = prev1;
                    prev1 = temp1;
                    index1-=step;
                }
                i++;
            }
        }else {
            int prev1 = elements[n-1], index1=n-1-step;
            while ( i<n){

                if (index1<0){index1+=n;}

                temp1 = elements[index1];
                elements[index1] = prev1;
                prev1 = temp1;
                index1 = index1-step;

                i++;
            }
        }

        for (int e: elements) { System.out.print( e+ " " ); }


    }
}
