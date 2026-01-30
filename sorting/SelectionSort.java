package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Selection Sort!!!"); 

        // Loop through each element
        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i; // Assume current is smallest

            // Find smallest element in remaining array
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j; // Update smallest index
                }
            }

            // Swap smallest with current element
            int temp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = temp;
            
        }
    }
}
//Summary: Selection sort basically assigns a random (first) value as the minimum. 
//It then traverses through the array to find anything smaller and switches the values if one is present.
// It keeps going for each term.