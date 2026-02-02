package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Selection Sort!!!"); 

        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i; // Step 1: Assume current number is the smallest ** This starts at index 0.

            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j; // Step 2: Change index if a smaller number is found
                }
            }

            // Step 3: Swap the smallest number with the current position
            int temp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = temp;
        }
    }
} 
// Summary: Selection sort basically assigns the first value as the minimum. 
// It then traverses through the array to find anything smaller and switches the values if one is present.
// It keeps going for each term.