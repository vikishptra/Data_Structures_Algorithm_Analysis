public class ArraySearching {
    
    
    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Search - Comparisons: " + comparisons);
                return i; 
            }
        }
        System.out.println("Linear Search - Comparisons: " + comparisons);
        return -1; 
    }
    
    
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int comparisons = 0;
        
        while (left <= right) {
            comparisons++;
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                System.out.println("Binary Search - Comparisons: " + comparisons);
                return mid;
            }
            
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Binary Search - Comparisons: " + comparisons);
        return -1;
    }
    
    
    public static int binarySearchRecursive(int[] arr, int target, int left, int right, int comparisons) {
        if (left > right) {
            System.out.println("Binary Search Recursive - Comparisons: " + comparisons);
            return -1;
        }
        
        comparisons++;
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            System.out.println("Binary Search Recursive - Comparisons: " + comparisons);
            return mid;
        }
        
        if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right, comparisons);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1, comparisons);
        }
    }
    
    
    public static void linearSearchAll(int[] arr, int target) {
        System.out.print("Linear Search All - Indices found: ");
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("Not found");
        }
        System.out.println();
    }
    
    
    public static void printArray(int[] arr, String description) {
        System.out.print(description + ": ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
    
    
    public static void printSearchResult(int result, int target, String method) {
        if (result != -1) {
            System.out.println(method + " - Element " + target + " found at index: " + result);
        } else {
            System.out.println(method + " - Element " + target + " not found");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== ARRAY SEARCHING DEMONSTRATION ===\n");
        
        
        int[] unsortedArray = {64, 34, 25, 12, 22, 11, 90, 5, 77, 30};
        printArray(unsortedArray, "Unsorted Array");
        
        System.out.println("\n--- LINEAR SEARCH ON UNSORTED ARRAY ---");
        int target1 = 22;
        int result1 = linearSearch(unsortedArray, target1);
        printSearchResult(result1, target1, "Linear Search");
        
        int target2 = 99;
        int result2 = linearSearch(unsortedArray, target2);
        printSearchResult(result2, target2, "Linear Search");
        
        
        int[] sortedArray = {5, 11, 12, 22, 25, 30, 34, 64, 77, 90};
        printArray(sortedArray, "\nSorted Array");
        
        System.out.println("\n--- BINARY SEARCH ON SORTED ARRAY ---");
        int target3 = 25;
        int result3 = binarySearch(sortedArray, target3);
        printSearchResult(result3, target3, "Binary Search");
        
        int target4 = 77;
        int result4 = binarySearchRecursive(sortedArray, target4, 0, sortedArray.length - 1, 0);
        printSearchResult(result4, target4, "Binary Search Recursive");
        
        int target5 = 50;
        int result5 = binarySearch(sortedArray, target5);
        printSearchResult(result5, target5, "Binary Search");
        
        
        System.out.println("\n--- PERFORMANCE COMPARISON ---");
        System.out.println("Searching for element 77:");
        
        
        System.out.println("\n--- HANDLING DUPLICATES ---");
        int[] arrayWithDuplicates = {1, 3, 5, 7, 7, 7, 9, 11, 13};
        printArray(arrayWithDuplicates, "Array with Duplicates");
        
        linearSearchAll(arrayWithDuplicates, 7);
        int firstOccurrence = binarySearch(arrayWithDuplicates, 7);
        System.out.println("Binary Search - First occurrence of 7 found at index: " + firstOccurrence);
        
        
        System.out.println("\n--- EDGE CASES ---");
        int[] emptyArray = {};
        int[] singleElement = {42};
        
        System.out.println("Empty array search:");
        printSearchResult(linearSearch(emptyArray, 5), 5, "Linear Search");
        
        System.out.println("Single element array search:");
        printSearchResult(linearSearch(singleElement, 42), 42, "Linear Search");
        printSearchResult(binarySearch(singleElement, 42), 42, "Binary Search");
        
    
    }
}