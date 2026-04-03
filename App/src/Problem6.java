import java.util.*;

public class Problem6 {

    // Linear Search (unsorted)
    static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: threshold=" + target + " → not found (" + comparisons + " comps)");
        }
    }

    // Binary Search Floor (largest <= target)
    static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1, comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                System.out.println("Binary floor comps: " + comparisons);
                return arr[mid];
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary floor comps: " + comparisons);
        return floor;
    }

    // Binary Search Ceiling (smallest >= target)
    static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ceil = -1, comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                System.out.println("Binary ceiling comps: " + comparisons);
                return arr[mid];
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Binary ceiling comps: " + comparisons);
        return ceil;
    }

    // Insertion Point (lower bound)
    static int insertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        int target = 30;

        // Linear Search (unsorted simulation)
        int[] unsorted = {50, 10, 100, 25};
        linearSearch(unsorted, target);

        // Binary Search operations (sorted)
        int f = floor(risks, target);
        int c = ceiling(risks, target);
        int pos = insertionPoint(risks, target);

        System.out.println("Binary floor(" + target + "): " + f);
        System.out.println("Binary ceiling(" + target + "): " + c);
        System.out.println("Insertion position: " + pos);
    }
}