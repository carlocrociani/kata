
public class FizzBuzz {
    private static final int rangeMin=1;
    private static final int rangeMax=100;

    /**
     * This method accepts the numbers from 1 to 100 and returns them as a String.
     * But for multiples of three it returns the String "Fizz" instead of the number and for the
     * multiples of five it returns the String "Buzz". For numbers which are multiples of both
     * three and five the method returns the String "FizzBuzz".
     *
     * @param number a number from 1 to 100
     * @return a String representing the number or the Strings "Fizz", "Buzz" and "FizzBuzz"
     *         as described above
     * @throws IllegalArgumentException if the number is not in the 1-100 range.
     */
    public String toFizzBuzzString(int number) {

        if(number<rangeMin || number>rangeMax){
            throw new IllegalArgumentException("Out of bound");
        }

        String result= String.valueOf(number);

        switch (number%3){
            case 0: result="Fizz";
                    switch (number%5){
                        case 0: result+="Buzz";
                            break;

                        }
            default: break;
        }
        switch (number%5){
            case 0: result="Buzz";
                switch (number%3){
                    case 0: result="Fizz"+result;
                        break;

                }
            default: break;
        }

        return result;
    }

}
