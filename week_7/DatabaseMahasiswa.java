package week_7;


import java.util.Scanner;

class Node {
    String nim;
    String nama;
    String jurusan;
    Node next;
    
    public Node(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.next = null;
    }
}

public class DatabaseMahasiswa {
    private Node head;
    private int count;
    private final int MAX_DATA = 5;
    
    public DatabaseMahasiswa() {
        head = null;
        count = 0;
    }
    
    
    public boolean pushData(String nim, String nama, String jurusan) {
        
        if (count >= MAX_DATA) {
            System.out.println("Database penuh! Maksimal 5 data.");
            return false;
        }
        
        
        if (nim.length() > 10 || !nim.matches("\\d+")) {
            System.out.println("NIM tidak valid! Maksimal 10 angka.");
            return false;
        }
        if (nama.length() > 30) {
            System.out.println("Nama terlalu panjang! Maksimal 30 karakter.");
            return false;
        }
        if (jurusan.length() > 50) {
            System.out.println("Jurusan terlalu panjang! Maksimal 50 karakter.");
            return false;
        }
        
        
        Node newNode = new Node(nim, nama, jurusan);
        newNode.next = head;
        head = newNode;
        count++;
        
        System.out.println("Data berhasil ditambahkan!");
        return true;
    }
    
    
    public void displaySorted() {
        if (head == null) {
            System.out.println("Database kosong!");
            return;
        }
        
        
        Node[] nodeArray = new Node[count];
        Node current = head;
        for (int i = 0; i < count; i++) {
            nodeArray[i] = current;
            current = current.next;
        }
        
        
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (Long.parseLong(nodeArray[j].nim) > Long.parseLong(nodeArray[j + 1].nim)) {
                    Node temp = nodeArray[j];
                    nodeArray[j] = nodeArray[j + 1];
                    nodeArray[j + 1] = temp;
                }
            }
        }
        
        
        System.out.println("\n=== DAFTAR MAHASISWA (Terurut berdasarkan NIM) ===");
        System.out.printf("%-12s %-32s %-52s%n", "NIM", "NAMA", "JURUSAN");
        System.out.println("=".repeat(96));
        
        for (int i = 0; i < count; i++) {
            System.out.printf("%-12s %-32s %-52s%n", 
                nodeArray[i].nim, nodeArray[i].nama, nodeArray[i].jurusan);
        }
    }
    
    
    public void popAllData() {
        head = null;
        count = 0;
        System.out.println("Semua data berhasil dihapus!");
    }
    
    
    public static void main(String[] args) {
        DatabaseMahasiswa db = new DatabaseMahasiswa();
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        
        do {
            System.out.println("1. Push Data Mahasiswa");
            System.out.println("2. Tampilkan Semua Data (Terurut NIM)");
            System.out.println("3. Pop Semua Data");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            
            pilihan = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM (maks 10 angka): ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama (maks 30 karakter): ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Jurusan (maks 50 karakter): ");
                    String jurusan = scanner.nextLine();
                    
                    db.pushData(nim, nama, jurusan);
                    break;
                    
                case 2:
                    db.displaySorted();
                    break;
                    
                case 3:
                    db.popAllData();
                    break;
                    
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 4);
        
        scanner.close();
    }
}