
import java.util.ArrayList;
import java.util.Collections;

/**
 * Kelas ArrayListOperations untuk melakukan operasi dasar pada ArrayList
 * Mencakup penambahan, penghapusan, pencarian, dan pengurutan
 */
public class ArrayListOperations {
    
    /**
     * Melakukan traversal pada ArrayList (menampilkan isi ArrayList)
     * @param list ArrayList yang akan ditampilkan
     * @return String representasi dari ArrayList
     */
    public String traversal(ArrayList<Integer> list) {
        return list.toString();
    }
    
    /**
     * Menambahkan elemen ke dalam ArrayList
     * @param list ArrayList yang akan ditambahkan elemen
     * @param element Elemen yang akan ditambahkan
     * @return ArrayList setelah penambahan elemen
     */
    public ArrayList<Integer> addElement(ArrayList<Integer> list, int element) {
        list.add(element);
        return list;
    }
    
    /**
     * Menambahkan elemen ke dalam ArrayList pada posisi tertentu
     * @param list ArrayList yang akan ditambahkan elemen
     * @param element Elemen yang akan ditambahkan
     * @param position Posisi tempat penambahan
     * @return ArrayList setelah penambahan elemen
     */
    public ArrayList<Integer> insertElement(ArrayList<Integer> list, int element, int position) {
        // Validasi posisi
        if (position < 0 || position > list.size()) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        
        list.add(position, element);
        return list;
    }
    
    /**
     * Menghapus elemen dari ArrayList berdasarkan nilai
     * @param list ArrayList yang akan dihapus elemennya
     * @param element Elemen yang akan dihapus
     * @return ArrayList setelah penghapusan elemen
     */
    public ArrayList<Integer> removeElement(ArrayList<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
        return list;
    }
    
    /**
     * Menghapus elemen dari ArrayList berdasarkan posisi
     * @param list ArrayList yang akan dihapus elemennya
     * @param position Posisi elemen yang akan dihapus
     * @return ArrayList setelah penghapusan elemen
     */
    public ArrayList<Integer> removeElementAt(ArrayList<Integer> list, int position) {
        // Validasi posisi
        if (position < 0 || position >= list.size()) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        
        list.remove(position);
        return list;
    }
    
    /**
     * Melakukan pencarian elemen dalam ArrayList
     * @param list ArrayList yang akan dicari
     * @param target Nilai yang dicari
     * @return Index dari elemen yang ditemukan, atau -1 jika tidak ditemukan
     */
    public int searchElement(ArrayList<Integer> list, int target) {
        return list.indexOf(target);
    }
    
    /**
     * Melakukan linear search manual pada ArrayList
     * @param list ArrayList yang akan dicari
     * @param target Nilai yang dicari
     * @return Index dari elemen yang ditemukan, atau -1 jika tidak ditemukan
     */
    public int linearSearch(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Melakukan binary search pada ArrayList yang sudah terurut
     * @param list ArrayList yang sudah terurut
     * @param target Nilai yang dicari
     * @return Index dari elemen yang ditemukan, atau -1 jika tidak ditemukan
     */
    public int binarySearch(ArrayList<Integer> list, int target) {
        return Collections.binarySearch(list, target);
    }
    
    /**
     * Mengurutkan ArrayList menggunakan Collections.sort()
     * @param list ArrayList yang akan diurutkan
     * @return ArrayList yang sudah terurut
     */
    public ArrayList<Integer> sortList(ArrayList<Integer> list) {
        Collections.sort(list);
        return list;
    }
    
    /**
     * Membuat copy dari ArrayList
     * @param list ArrayList yang akan dicopy
     * @return Copy dari ArrayList
     */
    public ArrayList<Integer> copyList(ArrayList<Integer> list) {
        return new ArrayList<>(list);
    }
}
