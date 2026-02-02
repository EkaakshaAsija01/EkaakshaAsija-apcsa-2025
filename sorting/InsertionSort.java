package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Insertion Sort!!!");
        for (int i = 1; i < input.length; i++) {
            int key = input[i]; // Current element
            int j = i - 1;

            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j]; // Shift right
                j--; // Move left
            }

            input[j + 1] = key; // Insert element
        }
    }
} // Starts with the second number. 
// It compares this number to the ones before it and moves it to the correct spot. 
// Repeats for each number until the whole list is sorted.
