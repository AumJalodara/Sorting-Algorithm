import java.util.*;

public class Problem5 {

    // Linear Search (first & last occurrence)
    static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1, comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear first " + target + ": " + first);
        System.out.println("Linear last " + target + ": " + last);
        System.out.println("Comparisons: " + comparisons);
    }

    // Binary Search (find one occurrence)
    static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1, comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println("Binary " + target + ": index " + mid +
                        " (" + comparisons + " comparisons)");
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary " + target + ": not found");
        return -1;
    }

    // Count duplicates using binary expansion
    static int countOccurrences(String[] arr, int index, String target) {
        if (index == -1) return 0;

        int count = 1;

        int left = index - 1;
        while (left >= 0 && arr[left].equals(target)) {
            count++;
            left--;
        }

        int right = index + 1;
        while (right < arr.length && arr[right].equals(target)) {
            count++;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // Linear Search (unsorted)
        linearSearch(logs, "accB");

        // Sort for Binary Search
        Arrays.sort(logs);
        System.out.println("Sorted logs: " + Arrays.toString(logs));

        // Binary Search
        int index = binarySearch(logs, "accB");

        // Count duplicates
        int count = countOccurrences(logs, index, "accB");
        System.out.println("Count of accB: " + count);
    }
}