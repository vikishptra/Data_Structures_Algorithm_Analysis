
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Kelas utama untuk menjalankan program dan mendemonstrasikan
 * operasi Array dan ArrayList beserta perbandingan kinerjanya
 */
public class MainProgram {
    
    public static void main(String[] args) {
        
        ArrayOperations arrayOps = new ArrayOperations();
        ArrayListOperations arrayListOps = new ArrayListOperations();
        PerformanceComparison comparison = new PerformanceComparison();
        
        System.out.println("=".repeat(80));
        System.out.println("TUGAS PRAKTIKUM 1 - ARRAY vs ARRAYLIST OPERATIONS");
        System.out.println("=".repeat(80));
        
        
        demonstrateBasicOperations(arrayOps, arrayListOps);
        
        
        demonstrateSearchOperations(arrayOps, arrayListOps);
        
        
        demonstrateInsertionDeletion(arrayOps, arrayListOps);
        
        
        System.out.println("\n\n");
        comparison.displayPerformanceComparison();
        
        
        displayConclusion();
    }
    
    /**
     * Demonstrasi operasi dasar Array dan ArrayList
     */
    private static void demonstrateBasicOperations(ArrayOperations arrayOps, 
                                                  ArrayListOperations arrayListOps) {
        System.out.println("\n1. OPERASI DASAR - TRAVERSAL");
        System.out.println("-".repeat(50));
        
        
        int[] array = {10, 20, 30, 40, 50};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        
        
        System.out.println("Array Traversal: " + arrayOps.traversal(array));
        System.out.println("ArrayList Traversal: " + arrayListOps.traversal(arrayList));
    }
    
    /**
     * Demonstrasi operasi pencarian
     */
    private static void demonstrateSearchOperations(ArrayOperations arrayOps, 
                                                   ArrayListOperations arrayListOps) {
        System.out.println("\n2. OPERASI PENCARIAN");
        System.out.println("-".repeat(50));
        
        
        int[] array = {10, 20, 30, 40, 50};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int target = 30;
        
        
        int arrayIndex = arrayOps.linearSearch(array, target);
        int arrayListIndex = arrayListOps.linearSearch(arrayList, target);
        
        System.out.println("Pencarian " + target + " dalam Array: " + 
                          (arrayIndex != -1 ? "Ditemukan di indeks " + arrayIndex : "Tidak ditemukan"));
        System.out.println("Pencarian " + target + " dalam ArrayList: " + 
                          (arrayListIndex != -1 ? "Ditemukan di indeks " + arrayListIndex : "Tidak ditemukan"));
        
        
        int[] sortedArray = arrayOps.sortArray(array);
        ArrayList<Integer> sortedArrayList = arrayListOps.sortList(arrayListOps.copyList(arrayList));
        
        int binaryArrayIndex = arrayOps.binarySearch(sortedArray, target);
        int binaryArrayListIndex = arrayListOps.binarySearch(sortedArrayList, target);
        
        System.out.println("Binary Search " + target + " dalam Array: " + 
                          (binaryArrayIndex != -1 ? "Ditemukan di indeks " + binaryArrayIndex : "Tidak ditemukan"));
        System.out.println("Binary Search " + target + " dalam ArrayList: " + 
                          (binaryArrayListIndex >= 0 ? "Ditemukan di indeks " + binaryArrayListIndex : "Tidak ditemukan"));
    }
    
    /**
     * Demonstrasi operasi penyisipan dan penghapusan
     */
    private static void demonstrateInsertionDeletion(ArrayOperations arrayOps, 
                                                    ArrayListOperations arrayListOps) {
        System.out.println("\n3. OPERASI PENYISIPAN DAN PENGHAPUSAN");
        System.out.println("-".repeat(50));
        
        
        int[] array = {10, 20, 30, 40, 50};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        
        System.out.println("Data awal:");
        System.out.println("Array: " + arrayOps.traversal(array));
        System.out.println("ArrayList: " + arrayListOps.traversal(arrayList));
        
        
        int elementToInsert = 25;
        int insertPosition = 2;
        
        int[] newArray = arrayOps.insertElement(array, elementToInsert, insertPosition);
        arrayListOps.insertElement(arrayList, elementToInsert, insertPosition);
        
        System.out.println("\nSetelah penyisipan elemen " + elementToInsert + " di posisi " + insertPosition + ":");
        System.out.println("Array: " + arrayOps.traversal(newArray));
        System.out.println("ArrayList: " + arrayListOps.traversal(arrayList));
        
        
        int deletePosition = 3;
        
        int[] arrayAfterDeletion = arrayOps.deleteElement(newArray, deletePosition);
        arrayListOps.removeElementAt(arrayList, deletePosition);
        
        System.out.println("\nSetelah penghapusan elemen di posisi " + deletePosition + ":");
        System.out.println("Array: " + arrayOps.traversal(arrayAfterDeletion));
        System.out.println("ArrayList: " + arrayListOps.traversal(arrayList));
        
        
        int[] unsortedArray = {50, 30, 20, 40, 10};
        ArrayList<Integer> unsortedArrayList = new ArrayList<>(Arrays.asList(50, 30, 20, 40, 10));
        
        System.out.println("\nData sebelum pengurutan:");
        System.out.println("Array: " + arrayOps.traversal(unsortedArray));
        System.out.println("ArrayList: " + arrayListOps.traversal(unsortedArrayList));
        
        int[] sortedArray = arrayOps.sortArray(unsortedArray);
        arrayListOps.sortList(unsortedArrayList);
        
        System.out.println("\nData setelah pengurutan:");
        System.out.println("Array: " + arrayOps.traversal(sortedArray));
        System.out.println("ArrayList: " + arrayListOps.traversal(unsortedArrayList));
    }
    
    /**
     * Menampilkan kesimpulan analisis
     */
    private static void displayConclusion() {
        System.out.println("\n\n" + "=".repeat(80));
        System.out.println("KESIMPULAN ANALISIS");
        System.out.println("=".repeat(80));
        
        System.out.println("\nKELEBIHAN ARRAY:");
        System.out.println("• Akses elemen lebih cepat (direct memory access)");
        System.out.println("• Penggunaan memori lebih efisien");
        System.out.println("• Cocok untuk data dengan ukuran tetap");
        System.out.println("• Performa traversal dan akses random yang baik");
        
        System.out.println("\nKEKURangan ARRAY:");
        System.out.println("• Ukuran harus ditentukan saat deklarasi");
        System.out.println("• Operasi insertion dan deletion memerlukan shifting manual");
        System.out.println("• Tidak ada built-in method untuk operasi kompleks");
        System.out.println("• Sulit untuk mengubah ukuran array");
        
        System.out.println("\nKELEBIHAN ARRAYLIST:");
        System.out.println("• Ukuran dinamis (dapat bertambah/berkurang)");
        System.out.println("• Banyak built-in method yang memudahkan operasi");
        System.out.println("• Operasi insertion dan deletion lebih mudah");
        System.out.println("• Implementasi Collection Framework yang lengkap");
        
        System.out.println("\nKEKURangan ARRAYLIST:");
        System.out.println("• Overhead memory karena boxing/unboxing");
        System.out.println("• Sedikit lebih lambat untuk akses elemen");
        System.out.println("• Menggunakan lebih banyak memori");
        System.out.println("• Kapasitas default mungkin tidak optimal");
        
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("Program selesai dijalankan!");
        System.out.println("=".repeat(80));
    }
}
