
public class ArrayInsertion {
    
    
    public static int[] insertAtPosition(int[] arr, int element, int position) {
        
        if (position < 0 || position > arr.length) {
            System.out.println("Posisi tidak valid!");
            return arr;
        }
        
        
        int[] newArr = new int[arr.length + 1];
        
        
        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }
        
        
        newArr[position] = element;
        
        
        for (int i = position; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        
        return newArr;
    }
    
    
    public static int[] insertAtBeginning(int[] arr, int element) {
        return insertAtPosition(arr, element, 0);
    }
    
    
    public static int[] insertAtEnd(int[] arr, int element) {
        return insertAtPosition(arr, element, arr.length);
    }
    
    
    public static void printArray(int[] arr, String description) {
        System.out.print(description + ": ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        
        int[] originalArray = {10, 20, 30, 40, 50};
        printArray(originalArray, "Array Awal");
        
        System.out.println("\n=== DEMONSTRASI INSERTION ===");
        
        
        int[] result1 = insertAtBeginning(originalArray, 5);
        printArray(result1, "Insert 5 di awal");
        
        
        int[] result2 = insertAtPosition(originalArray, 25, 2);
        printArray(result2, "Insert 25 di posisi 2");
        
        
        int[] result3 = insertAtEnd(originalArray, 60);
        printArray(result3, "Insert 60 di akhir");
        
        
        System.out.println("\n=== MULTIPLE INSERTIONS ===");
        int[] multiArray = {1, 3, 5};
        printArray(multiArray, "Array awal");
        
        multiArray = insertAtPosition(multiArray, 2, 1);
        printArray(multiArray, "Insert 2 di posisi 1");
        
        multiArray = insertAtPosition(multiArray, 4, 3);
        printArray(multiArray, "Insert 4 di posisi 3");
        
        multiArray = insertAtPosition(multiArray, 6, 5);
        printArray(multiArray, "Insert 6 di posisi 5");
        
        
        System.out.println("\n=== ERROR HANDLING ===");
        int[] errorTest = insertAtPosition(originalArray, 99, 10);
        System.out.println("Mencoba insert di posisi 10 (invalid)");
        
        
        System.out.println("\n=== BONUS: STRING ARRAY ===");
        String[] names = {"Alice", "Charlie", "Eve"};
        String[] newNames = insertStringAtPosition(names, "Bob", 1);
        printStringArray(names, "Array nama awal");
        printStringArray(newNames, "Setelah insert 'Bob' di posisi 1");
    }
    
    
    public static String[] insertStringAtPosition(String[] arr, String element, int position) {
        if (position < 0 || position > arr.length) {
            return arr;
        }
        
        String[] newArr = new String[arr.length + 1];
        
        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }
        
        newArr[position] = element;
        
        for (int i = position; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        
        return newArr;
    }
    
    public static void printStringArray(String[] arr, String description) {
        System.out.print(description + ": ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
}