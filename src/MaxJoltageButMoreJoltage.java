import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxJoltageButMoreJoltage {
    public static long findMaxJoltage(File input){
        int numOfDigits = 12;
        long sum = 0;
        try (Scanner scan = new Scanner(input)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                sum += bestOfLine(line,0,numOfDigits);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FUCKKKK ITS ALL GONE WRONG: " + e.getMessage());
        }
        return sum;
    }

    private static long bestOfLine(String line, int start, int numOfRemainingDigits){
        if  (numOfRemainingDigits == 0){
            return 0;
        }
        int max = 0;
        int location = start;
        for  (int i = start; i <= line.length()-numOfRemainingDigits; i++) {
            int digit = Character.getNumericValue(line.charAt(i));
            if (digit > max) {
                max = digit;
                location = i;
            }
        }
        long factor = (long) Math.pow(10, numOfRemainingDigits-1);
        return max * factor + bestOfLine(line, location+1, numOfRemainingDigits-1);
    }
}
