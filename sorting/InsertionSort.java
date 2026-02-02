package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Insertion Sort!!!");

        for (int i = 1; i < input.length; i++) {
            int key = input[i]; // Step 1: Pick the current number
            int j = i - 1;      // Step 2: compare with previous numbers

            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j]; // Step 3: Shift bigger numbers right
                j--; // Step 4: Move left
            }

            input[j + 1] = key; // Step 5: Insert number in the correct spot
        }
    }
} 
// Starts with the second number. 
// It compares this number to the ones before it and moves it to the correct spot. 
// Repeats for each number until the whole list is sorted.