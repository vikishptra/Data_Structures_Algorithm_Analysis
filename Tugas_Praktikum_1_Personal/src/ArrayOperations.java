

import java.util.Arrays;

/**
 * Kelas ArrayOperations untuk melakukan operasi dasar pada Array
 * Mencakup traversal, pencarian, penyisipan, dan penghapusan
 */
public class ArrayOperations {
    
    /**
     * Melakukan traversal pada array (menampilkan isi array)
     * @param arr Array yang akan ditampilkan
     * @return String representasi dari array
     */
    public String traversal(int[] arr) {
        return Arrays.toString(arr);
    }
    
    /**
     * Melakukan linear search pada array
     * @param arr Array yang akan dicari
     * @param target Nilai yang dicari
     * @return Index dari elemen yang ditemukan, atau -1 jika tidak ditemukan
     */
    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Melakukan binary search pada array yang sudah terurut
     * @param arr Array yang sudah terurut
     * @param target Nilai yang dicari
     * @return Index dari elemen yang ditemukan, atau -1 jika tidak ditemukan
     */
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    /**
     * Menyisipkan elemen ke dalam array pada posisi tertentu
     * @param arr Array asli
     * @param element Elemen yang akan disisipkan
     * @param position Posisi tempat penyisipan
     * @return Array baru dengan elemen yang disisipkan
     */
    public int[] insertElement(int[] arr, int element, int position) {
       
        if (position < 0 || position > arr.length) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        
       
        int[] newArr = new int[arr.length + 1];
        
       
        System.arraycopy(arr, 0, newArr, 0, position);
        
       
        newArr[position] = element;
        
       
        System.arraycopy(arr, position, newArr, position + 1, arr.length - position);
        
        return newArr;
    }
    
    /**
     * Menghapus elemen dari array pada posisi tertentu
     * @param arr Array asli
     * @param position Posisi elemen yang akan dihapus
     * @return Array baru tanpa elemen yang dihapus
     */
    public int[] deleteElement(int[] arr, int position) {
       
        if (position < 0 || position >= arr.length) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        
       
        int[] newArr = new int[arr.length - 1];
        
       
        System.arraycopy(arr, 0, newArr, 0, position);
        
       
        System.arraycopy(arr, position + 1, newArr, position, arr.length - position - 1);
        
        return newArr;
    }
    
    /**
     * Mengurutkan array menggunakan Arrays.sort()
     * @param arr Array yang akan diurutkan
     * @return Array yang sudah terurut
     */
    public int[] sortArray(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        return sortedArr;
    }
}