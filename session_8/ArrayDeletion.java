public class ArrayDeletion {
    
    
    public static int[] deleteByIndex(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            System.out.println("Index tidak valid!");
            return arr;
        }
        
        int[] newArr = new int[arr.length - 1];
        
        
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        
        
        for (int i = index + 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }
        
        return newArr;
    }
    
    
    public static int[] deleteByValue(int[] arr, int value) {
        
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }
        
        if (index == -1) {
            System.out.println("Value " + value + " tidak ditemukan!");
            return arr;
        }
        
        return deleteByIndex(arr, index);
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
        
        int[] arr = {10, 20, 30, 40, 50};
        printArray(arr, "Array Awal");
        
        
        int[] result1 = deleteByIndex(arr, 2); 
        printArray(result1, "Setelah delete index 2");
        
        
        int[] result2 = deleteByValue(arr, 40); 
        printArray(result2, "Setelah delete value 40");
        
        
        int[] result3 = deleteByIndex(arr, 0);
        printArray(result3, "Setelah delete dari awal");
        
        
        int[] result4 = deleteByIndex(arr, arr.length - 1);
        printArray(result4, "Setelah delete dari akhir");
        
        
        int[] result5 = deleteByValue(arr, 99);
        printArray(result5, "Setelah delete value 99");
    }
}