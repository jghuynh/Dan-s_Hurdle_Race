import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hurdleRace function below.

    /**
     * Deterines how many magic potions Dan must drink to jump over all the hurdles
     * @param jump the maximum height he can jump
     * @param height an array of hurdle heights
     * @return the number of magic potions he must drink
     */
    static int hurdleRace(int jump, int[] height) {
        int maxHurdle = height[0];
        // find the max height
        for (int index = 1; index < height.length; index ++) {
            if (height[index] > maxHurdle) {
                maxHurdle = height[index];
            }
        }
        if (maxHurdle > jump) {
            return maxHurdle - jump;
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] height = new int[n];

        String[] heightItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int heightItem = Integer.parseInt(heightItems[i]);
            height[i] = heightItem;
        }

        int result = hurdleRace(k, height);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

