package mytests.armstrong;

/**
 * Created by PavelOsipenko on 05.04.2016.
 */
public class ArmstrongNumber {
    public static void main(String[] args) {
        int number = 8208;
        if (isArmstrong(number)) {
            System.out.println("Number : " + number + " is an Armstrong number");
        } else {
            System.out.println("Number : " + number + " is not an Armstrong number");
        }

    }

    private static boolean isArmstrong(int number) {

        int result = 0;
        int orig = number;
        while (number != 0) {
            int remainder = number % 10;
            result = result + remainder * remainder * remainder;
//            result = result + remainder * remainder * remainder;
            number = number / 10;
        }
        if (orig == result) {
            return true;
        }
        return false;
    }
}
