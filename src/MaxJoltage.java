import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxJoltage {
    public static int findMaxJoltage(File input){
        int sum = 0;
        try (Scanner scan = new Scanner(input)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();

                int[] firstDigit = findMaxLocation(line, 0, 1);
                int[] secondDigit = findMaxLocation(line, firstDigit[1] + 1, 0);

                int best = (firstDigit[0] * 10) + secondDigit[0];

                sum += best;
            }
        } catch (FileNotFoundException e) {
            System.out.println("FUCKKKK ITS ALL GONE WRONG: " + e.getMessage());
        }

        return sum;

    }
    private static int[] findMaxLocation(String input, int start, int endChop){
        int max = 0;
        int location = start;
        for  (int i = start; i < input.length()-endChop; i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            if (digit > max) {
                max = digit;
                location = i;
            }
        }
        return new int[]{max, location};
    }
}
