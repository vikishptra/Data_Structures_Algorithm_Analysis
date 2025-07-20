
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Kelas TestProgram untuk menguji semua fungsionalitas yang telah diimplementasikan
 * Melakukan unit testing untuk memastikan semua method bekerja dengan benar
 */
public class TestProgram {
    
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("UNIT TESTING - ARRAY vs ARRAYLIST OPERATIONS");
        System.out.println("=".repeat(80));
        
       
        testArrayOperations();
        
       
        testArrayListOperations();
        
       
        testPerformanceComparison();
        
       
        displayTestResults();
    }
    
    /**
     * Test semua operasi Array
     */
    private static void testArrayOperations() {
        System.out.println("\n1. TESTING ARRAY OPERATIONS");
        System.out.println("-".repeat(50));
        
        ArrayOperations arrayOps = new ArrayOperations();
        
       
        testCase("Array Traversal", () -> {
            int[] arr = {1, 2, 3, 4, 5};
            String result = arrayOps.traversal(arr);
            return result.equals("[1, 2, 3, 4, 5]");
        });
        
       
        testCase("Array Linear Search (Found)", () -> {
            int[] arr = {10, 20, 30, 40, 50};
            int index = arrayOps.linearSearch(arr, 30);
            return index == 2;
        });
        
       
        testCase("Array Linear Search (Not Found)", () -> {
            int[] arr = {10, 20, 30, 40, 50};
            int index = arrayOps.linearSearch(arr, 100);
            return index == -1;
        });
        
       
        testCase("Array Binary Search", () -> {
            int[] arr = {10, 20, 30, 40, 50};
            int index = arrayOps.binarySearch(arr, 30);
            return index == 2;
        });
        
       
        testCase("Array Insert Element", () -> {
            int[] arr = {10, 20, 40, 50};
            int[] newArr = arrayOps.insertElement(arr, 30, 2);
            return Arrays.equals(newArr, new int[]{10, 20, 30, 40, 50});
        });
        
       
        testCase("Array Delete Element", () -> {
            int[] arr = {10, 20, 30, 40, 50};
            int[] newArr = arrayOps.deleteElement(arr, 2);
            return Arrays.equals(newArr, new int[]{10, 20, 40, 50});
        });
        
       
        testCase("Array Sort", () -> {
            int[] arr = {50, 30, 40, 10, 20};
            int[] sortedArr = arrayOps.sortArray(arr);
            return Arrays.equals(sortedArr, new int[]{10, 20, 30, 40, 50});
        });
        
       
        testCase("Array Insert at Beginning", () -> {
            int[] arr = {20, 30, 40};
            int[] newArr = arrayOps.insertElement(arr, 10, 0);
            return Arrays.equals(newArr, new int[]{10, 20, 30, 40});
        });
        
        testCase("Array Insert at End", () -> {
            int[] arr = {10, 20, 30};
            int[] newArr = arrayOps.insertElement(arr, 40, 3);
            return Arrays.equals(newArr, new int[]{10, 20, 30, 40});
        });
    }
    
    /**
     * Test semua operasi ArrayList
     */
    private static void testArrayListOperations() {
        System.out.println("\n2. TESTING ARRAYLIST OPERATIONS");
        System.out.println("-".repeat(50));
        
        ArrayListOperations arrayListOps = new ArrayListOperations();
        
       
        testCase("ArrayList Traversal", () -> {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            String result = arrayListOps.traversal(list);
            return result.equals("[1, 2, 3, 4, 5]");
        });
        
       
        testCase("ArrayList Add Element", () -> {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
            arrayListOps.addElement(list, 5);
            return list.equals(Arrays.asList(1, 2, 3, 4, 5));
        });
        
       
        testCase("ArrayList Insert Element", () -> {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 40, 50));
            arrayListOps.insertElement(list, 30, 2);
            return list.equals(Arrays.asList(10, 20, 30, 40, 50));
        });
        
       
        testCase("ArrayList Remove by Value", () -> {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
            arrayListOps.removeElement(list, 30);
            return list.equals(Arrays.asList(10, 20, 40, 50));
        });
        
       
        testCase("ArrayList Remove by Index", () -> {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
            arrayListOps.removeElementAt(list, 2);
            return list.equals(Arrays.asList(10, 20, 40, 50));
        });
        
       
        testCase("ArrayList Search Element", () -> {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
            int index = arrayListOps.searchElement(list, 30);
            return index == 2;
        });
        
       
        testCase("ArrayList Linear Search", () -> {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
            int index = arrayListOps.linearSearch(list, 30);
            return index == 2;
        });
        
       
        testCase("ArrayList Binary Search", () -> {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
            int index = arrayListOps.binarySearch(list, 30);
            return index == 2;
        });
        
       
        testCase("ArrayList Sort", () -> {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(50, 30, 40, 10, 20));
            arrayListOps.sortList(list);
            return list.equals(Arrays.asList(10, 20, 30, 40, 50));
        });
        
       
        testCase("ArrayList Copy", () -> {
            ArrayList<Integer> original = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            ArrayList<Integer> copy = arrayListOps.copyList(original);
            return copy.equals(original) && copy != original;
        });
    }
    
    /**
     * Test Performance Comparison
     */
    private static void testPerformanceComparison() {
        System.out.println("\n3. TESTING PERFORMANCE COMPARISON");
        System.out.println("-".repeat(50));
        
        PerformanceComparison comparison = new PerformanceComparison();
        
       
        testCase("Performance - Traversal Time", () -> {
            double[] times = comparison.measureTraversalTime(100);
            return times.length == 2 && times[0] >= 0 && times[1] >= 0;
        });
        
       
        testCase("Performance - Search Time", () -> {
            double[] times = comparison.measureSearchTime(100);
            return times.length == 2 && times[0] >= 0 && times[1] >= 0;
        });
        
       
        testCase("Performance - Insertion Time", () -> {
            double[] times = comparison.measureInsertionTime(100);
            return times.length == 2 && times[0] >= 0 && times[1] >= 0;
        });
        
       
        testCase("Performance - Deletion Time", () -> {
            double[] times = comparison.measureDeletionTime(100);
            return times.length == 2 && times[0] >= 0 && times[1] >= 0;
        });
        
       
        testCase("Performance - Sorting Time", () -> {
            double[] times = comparison.measureSortingTime(100);
            return times.length == 2 && times[0] >= 0 && times[1] >= 0;
        });
    }
    
    /**
     * Method untuk menjalankan test case
     */
    private static void testCase(String testName, TestFunction test) {
        totalTests++;
        try {
            boolean result = test.run();
            if (result) {
                testsPassed++;
                System.out.println("✓ " + testName + " - PASSED");
            } else {
                System.out.println("✗ " + testName + " - FAILED");
            }
        } catch (Exception e) {
            System.out.println("✗ " + testName + " - ERROR: " + e.getMessage());
        }
    }
    
    /**
     * Menampilkan hasil testing
     */
    private static void displayTestResults() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("TEST RESULTS SUMMARY");
        System.out.println("=".repeat(80));
        
        System.out.println("Total Tests: " + totalTests);
        System.out.println("Tests Passed: " + testsPassed);
        System.out.println("Tests Failed: " + (totalTests - testsPassed));
        System.out.println("Success Rate: " + 
                          String.format("%.2f", (double) testsPassed / totalTests * 100) + "%");
        
        if (testsPassed == totalTests) {
            System.out.println("\n🎉 ALL TESTS PASSED! 🎉");
            System.out.println("Semua fungsionalitas bekerja dengan benar.");
        } else {
            System.out.println("\n⚠️  SOME TESTS FAILED ⚠️");
            System.out.println("Periksa kembali implementasi yang gagal.");
        }
        
        System.out.println("\n" + "=".repeat(80));
    }
    
    /**
     * Functional interface untuk test function
     */
    @FunctionalInterface
    interface TestFunction {
        boolean run() throws Exception;
    }
}