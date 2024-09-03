//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
      int n = arr.length;

        // If the array has only one element, no jump is needed.
        if (n == 1) {
            return 0;
        }

        // If the first element is 0, we can't move anywhere.
        if (arr[0] == 0) {
            return -1;
        }

        // Initialize variables.
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n; i++) {
            // Update the farthest point we can reach from the current position.
            farthest = Math.max(farthest, i + arr[i]);

            // If we have reached the end of the current jump range:
            if (i == currentEnd) {
                // If we're not at the last element, we need another jump.
                if (i != n - 1) {
                    jumps++;
                    currentEnd = farthest;
                    // If the farthest we can reach is beyond the last index, we're done.
                    if (currentEnd >= n - 1) {
                        return jumps;
                    }
                } else {
                    return -1;
                }
            }
        }

        // If we complete the loop without returning, check if we've reached the end.
        return (currentEnd >= n - 1) ? jumps : -1;
    }
}