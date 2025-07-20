
import java.util.ArrayList;
import java.util.Random;

/**
 * Kelas PerformanceComparison untuk membandingkan kinerja Array dan ArrayList
 * Mengukur waktu eksekusi berbagai operasi dasar
 */
public class PerformanceComparison {
    
    private ArrayOperations arrayOps;
    private ArrayListOperations arrayListOps;
    private Random random;
    
    public PerformanceComparison() {
        this.arrayOps = new ArrayOperations();
        this.arrayListOps = new ArrayListOperations();
        this.random = new Random();
    }
    
    /**
     * Mengukur waktu eksekusi operasi traversal
     * @param size Ukuran data untuk pengujian
     * @return Array yang berisi waktu eksekusi [arrayTime, arrayListTime]
     */
    public double[] measureTraversalTime(int size) {
        
        int[] array = generateRandomArray(size);
        ArrayList<Integer> arrayList = generateRandomArrayList(size);
        
        
        long startTime = System.nanoTime();
        arrayOps.traversal(array);
        long endTime = System.nanoTime();
        double arrayTime = (endTime - startTime) / 1_000_000.0; 
        
        
        startTime = System.nanoTime();
        arrayListOps.traversal(arrayList);
        endTime = System.nanoTime();
        double arrayListTime = (endTime - startTime) / 1_000_000.0; 
        
        return new double[]{arrayTime, arrayListTime};
    }
    
    /**
     * Mengukur waktu eksekusi operasi pencarian
     * @param size Ukuran data untuk pengujian
     * @return Array yang berisi waktu eksekusi [arrayTime, arrayListTime]
     */
    public double[] measureSearchTime(int size) {
        
        int[] array = generateRandomArray(size);
        ArrayList<Integer> arrayList = generateRandomArrayList(size);
        int target = array[size / 2]; 
        
        
        long startTime = System.nanoTime();
        arrayOps.linearSearch(array, target);
        long endTime = System.nanoTime();
        double arrayTime = (endTime - startTime) / 1_000_000.0; 
        
        
        startTime = System.nanoTime();
        arrayListOps.linearSearch(arrayList, target);
        endTime = System.nanoTime();
        double arrayListTime = (endTime - startTime) / 1_000_000.0; 
        
        return new double[]{arrayTime, arrayListTime};
    }
    
    /**
     * Mengukur waktu eksekusi operasi penyisipan
     * @param size Ukuran data untuk pengujian
     * @return Array yang berisi waktu eksekusi [arrayTime, arrayListTime]
     */
    public double[] measureInsertionTime(int size) {
        
        int[] array = generateRandomArray(size);
        ArrayList<Integer> arrayList = generateRandomArrayList(size);
        int position = size / 2; 
        int element = 999;
        
        
        long startTime = System.nanoTime();
        arrayOps.insertElement(array, element, position);
        long endTime = System.nanoTime();
        double arrayTime = (endTime - startTime) / 1_000_000.0; 
        
        
        startTime = System.nanoTime();
        arrayListOps.insertElement(arrayList, element, position);
        endTime = System.nanoTime();
        double arrayListTime = (endTime - startTime) / 1_000_000.0; 
        
        return new double[]{arrayTime, arrayListTime};
    }
    
    /**
     * Mengukur waktu eksekusi operasi penghapusan
     * @param size Ukuran data untuk pengujian
     * @return Array yang berisi waktu eksekusi [arrayTime, arrayListTime]
     */
    public double[] measureDeletionTime(int size) {
        
        int[] array = generateRandomArray(size);
        ArrayList<Integer> arrayList = generateRandomArrayList(size);
        int position = size / 2; 
        
        
        long startTime = System.nanoTime();
        arrayOps.deleteElement(array, position);
        long endTime = System.nanoTime();
        double arrayTime = (endTime - startTime) / 1_000_000.0; 
        
        
        startTime = System.nanoTime();
        arrayListOps.removeElementAt(arrayList, position);
        endTime = System.nanoTime();
        double arrayListTime = (endTime - startTime) / 1_000_000.0; 
        
        return new double[]{arrayTime, arrayListTime};
    }
    
    /**
     * Mengukur waktu eksekusi operasi pengurutan
     * @param size Ukuran data untuk pengujian
     * @return Array yang berisi waktu eksekusi [arrayTime, arrayListTime]
     */
    public double[] measureSortingTime(int size) {
        
        int[] array = generateRandomArray(size);
        ArrayList<Integer> arrayList = generateRandomArrayList(size);
        
        
        long startTime = System.nanoTime();
        arrayOps.sortArray(array);
        long endTime = System.nanoTime();
        double arrayTime = (endTime - startTime) / 1_000_000.0; 
        
        
        startTime = System.nanoTime();
        arrayListOps.sortList(arrayListOps.copyList(arrayList));
        endTime = System.nanoTime();
        double arrayListTime = (endTime - startTime) / 1_000_000.0; 
        
        return new double[]{arrayTime, arrayListTime};
    }
    
    /**
     * Membuat array random dengan ukuran tertentu
     * @param size Ukuran array
     * @return Array random
     */
    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }
    
    /**
     * Membuat ArrayList random dengan ukuran tertentu
     * @param size Ukuran ArrayList
     * @return ArrayList random
     */
    private ArrayList<Integer> generateRandomArrayList(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(1000));
        }
        return arrayList;
    }
    
    /**
     * Menampilkan hasil perbandingan kinerja dalam bentuk tabel
     */
    public void displayPerformanceComparison() {
        System.out.println("=".repeat(80));
        System.out.println("PERBANDINGAN KINERJA ARRAY vs ARRAYLIST");
        System.out.println("=".repeat(80));
        
        int[] testSizes = {100, 1000, 5000, 10000};
        
        for (int size : testSizes) {
            System.out.println("\n" + "Test Size: " + size + " elements");
            System.out.println("-".repeat(60));
            System.out.printf("%-20s %-15s %-15s %-15s%n", 
                "Operation", "Array (ms)", "ArrayList (ms)", "Winner");
            System.out.println("-".repeat(60));
            
            
            double[] traversalTime = measureTraversalTime(size);
            System.out.printf("%-20s %-15.6f %-15.6f %-15s%n", 
                "Traversal", traversalTime[0], traversalTime[1], 
                traversalTime[0] < traversalTime[1] ? "Array" : "ArrayList");
            
            
            double[] searchTime = measureSearchTime(size);
            System.out.printf("%-20s %-15.6f %-15.6f %-15s%n", 
                "Search", searchTime[0], searchTime[1], 
                searchTime[0] < searchTime[1] ? "Array" : "ArrayList");
            
            
            double[] insertionTime = measureInsertionTime(size);
            System.out.printf("%-20s %-15.6f %-15.6f %-15s%n", 
                "Insertion", insertionTime[0], insertionTime[1], 
                insertionTime[0] < insertionTime[1] ? "Array" : "ArrayList");
            
            
            double[] deletionTime = measureDeletionTime(size);
            System.out.printf("%-20s %-15.6f %-15.6f %-15s%n", 
                "Deletion", deletionTime[0], deletionTime[1], 
                deletionTime[0] < deletionTime[1] ? "Array" : "ArrayList");
            
            
            double[] sortingTime = measureSortingTime(size);
            System.out.printf("%-20s %-15.6f %-15.6f %-15s%n", 
                "Sorting", sortingTime[0], sortingTime[1], 
                sortingTime[0] < sortingTime[1] ? "Array" : "ArrayList");
        }
    }
}