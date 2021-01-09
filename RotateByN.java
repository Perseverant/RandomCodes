import java.util.Scanner;

/**  HERE YOU CAN ROTATE THE ARRAY BY ANY STEP IN EITHER SIDE  */

public class RotateLeftByN {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        int step = sc.nextInt();
        boolean isRight = sc.nextBoolean();

        int[] elements = new int[n];
        System.out.println( elements.length);
        for (int i = 0 ; i < n ; i++){ elements[i] = sc.nextInt(); }
        step = step%n;

        int temp1, i=0;
        if (isRight){       /**  whether we rotate left aur right   */

        /**
         * 
         * Nested if-else is checking  whether n%step==0 satisfy or not
         * 
         * */
        
        
            if (n%step==0){
                int loop = n/step;
                while (i<step){
                    int prev1 = elements[i], index1=step+i;
                    for (int j = 0 ; j < loop ; j++) {

                        if (index1>=n){index1%=n;}

                        temp1 = elements[index1];
                        elements[index1] = prev1;
                        prev1 = temp1;
                        index1+=step;
                    }
                    i++;
                }
            }else {
                int prev1 = elements[0], index1=step;
                while ( i<n){

                    if (index1>=n){index1%=n;}

                    temp1 = elements[index1];
                    elements[index1] = prev1;
                    prev1 = temp1;
                    index1 = index1+step;

                    i++;
                }
            }

        }else {

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
        }

        for (int e: elements) { System.out.print( e+ " " ); }

    }
}
