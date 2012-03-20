import sun.misc.Regexp;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class SoftwareVersionComparator implements Comparator<String> {

    /**
     * Compares two software version strings. Software versions are made of
     * a maximum of 5 integers separated by dots. For example these are all
     * allowed version numbers:
     *
     * <ul>
     *     <li>3</li>
     *     <li>1.9.2</li>
     *     <li>3.0.678.34.9</li>
     * </ul>
     *
     * @param version1 first version String
     * @param version2 second version String
     * @return a negative integer if version1 is smaller than version2,
     *         zero if version1 equals version2, a positive integer
     *         if version1 is greater than version 2
     */
    @Override
    public int compare(String version1, String version2) {

        int result = 0 ;

        StringTokenizer v1 = new StringTokenizer(version1,".");

        StringTokenizer v2 = new StringTokenizer(version2,".");

        String token1= v1.nextToken();

        String token2= v2.nextToken();

        result = compareDeeper(result, v1, v2, token1, token2);

        return result;
    }

    private int compareDeeper(int result, StringTokenizer v1, StringTokenizer v2, String token1, String token2) {

        result = Integer.parseInt(token1)-Integer.parseInt(token2);

        if(result==0){
            //go deeper
            if(!v1.hasMoreTokens() && !v2.hasMoreTokens()){
                //final
                return result;

            }
            if(v1.hasMoreTokens() && !v2.hasMoreTokens()){
                //go deeper
                return compareDeeper(result,v1,v2,v1.nextToken(),"0");

            }
            if(!v1.hasMoreTokens() && v2.hasMoreTokens()){
                //go deeper
                return compareDeeper(result,v1,v2,"0",v2.nextToken());

            }
            if(v1.hasMoreTokens() && v2.hasMoreTokens()){
                //go deeper
                 return compareDeeper(result,v1,v2,v1.nextToken(),v2.nextToken());
            }
        }


        return result;
    }
}