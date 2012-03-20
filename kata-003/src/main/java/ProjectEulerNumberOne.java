import java.util.*;

public class ProjectEulerNumberOne {

    /**
     * This kata is inspired to <a
     * href="http://projecteuler.net/problem=1">Project Euler's
     * Problem #1</a>.
     *
     * If we list all the natural numbers below 10 that are multiples
     * of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     *
     * Find the sum of all the multiples of 3 or 5 below 1000.
     *
     * @return the sum of all the multiples of 3 or 5 below 1000
     */
    private static int MAX=1000;
    private static int THREE=3;
    private static int FIVE=5;
    Set<Integer> multiples = new HashSet<Integer> ();
    public int getResult() {
         int result=0;
        for(int i = 1; i<MAX; i++){
            if(THREE*i < MAX){
                multiples.add(THREE*i);
            }
            if(FIVE*i < MAX){
                multiples.add(FIVE*i);
            }
        }

        for (Integer integer : multiples) {
            result += integer;
        }


        return result;
    }
    
}
