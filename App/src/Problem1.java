import java.util.*;

public class Problem1 {

    static class Transaction {
        String id;
        double fee;
        String timestamp;

        Transaction(String id, double fee, String timestamp) {
            this.id = id;
            this.fee = fee;
            this.timestamp = timestamp;
        }

        int getTimeValue() {
            String[] t = timestamp.split(":");
            return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        }

        public String toString() {
            return id + ":" + fee + "@" + timestamp;
        }
    }

    // Bubble Sort (by fee)
    static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        int passes = 0, swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        System.out.println("BubbleSort (fees): " + format(list));
        System.out.println("Passes: " + passes + ", Swaps: " + swaps);
    }

    // Insertion Sort (fee + timestamp)
    static void insertionSort(List<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 &&
                    (list.get(j).fee > key.fee ||
                            (list.get(j).fee == key.fee &&
                                    list.get(j).getTimeValue() > key.getTimeValue()))) {

                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }

        System.out.println("InsertionSort (fee+ts): " + list);
    }

    // Outliers (>50)
    static void findOutliers(List<Transaction> list) {
        boolean found = false;

        for (Transaction t : list) {
            if (t.fee > 50) {
                if (!found) {
                    System.out.print("High-fee outliers: ");
                    found = true;
                }
                System.out.print(t + " ");
            }
        }

        if (!found) {
            System.out.println("High-fee outliers: none");
        } else {
            System.out.println();
        }
    }

    static String format(List<Transaction> list) {
        List<String> res = new ArrayList<>();
        for (Transaction t : list) {
            res.add(t.id + ":" + t.fee);
        }
        return res.toString();
    }

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        List<Transaction> smallBatch = new ArrayList<>(transactions);
        bubbleSort(smallBatch);

        List<Transaction> mediumBatch = new ArrayList<>(transactions);
        insertionSort(mediumBatch);

        findOutliers(transactions);
    }
}