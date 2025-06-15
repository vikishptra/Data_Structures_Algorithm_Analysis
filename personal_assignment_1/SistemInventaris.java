package personal_assignment_1;
import java.util.Scanner;


class Barang {
    private String nama;
    private int jumlahStok;
    private double harga;
    
    
    public Barang(String nama, int jumlahStok, double harga) {
        this.nama = nama;
        this.jumlahStok = jumlahStok;
        this.harga = harga;
    }
    
    
    public String getNama() {
        return nama;
    }
    
    public int getJumlahStok() {
        return jumlahStok;
    }
    
    public double getHarga() {
        return harga;
    }
    
    
    public void setJumlahStok(int jumlahStok) {
        this.jumlahStok = jumlahStok;
    }
    
    public String toString() {
        return "Nama: " + nama + ", Jumlah Stok: " + jumlahStok + ", Harga: " + (int)harga;
    }
}

public class SistemInventaris {
    private static Barang[] inventaris = new Barang[10];
    private static int jumlahBarang = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        inisialisasiInventaris();
        
        System.out.println("=== SISTEM MANAJEMEN INVENTARIS TOKO ===\n");
        tampilkanInventaris();
        
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tampilkan Inventaris");
            System.out.println("2. Update Stok Barang");
            System.out.println("3. Cari Barang");
            System.out.println("4. Tambah Barang Baru");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 
            switch (pilihan) {
                case 1:
                    tampilkanInventaris();
                    break;
                case 2:
                    System.out.print("Masukkan nama barang yang ingin diupdate: ");
                    String namaUpdate = scanner.nextLine();
                    System.out.print("Masukkan jumlah stok baru: ");
                    int stokBaru = scanner.nextInt();
                    updateStok(namaUpdate, stokBaru);
                    System.out.println("\nInventaris setelah diupdate:");
                    tampilkanInventaris();
                    break;
                case 3:
                    System.out.print("Masukkan nama barang yang dicari: ");
                    String namaCari = scanner.nextLine();
                    cariBarang(namaCari);
                    break;
                case 4:
                    tambahBarangBaru(scanner);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem inventaris!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    public static void inisialisasiInventaris() {
        inventaris[0] = new Barang("Pensil", 50, 2000);
        inventaris[1] = new Barang("Buku", 30, 15000);
        inventaris[2] = new Barang("Penghapus", 20, 500);
        jumlahBarang = 3;
    }
    
    public static void tampilkanInventaris() {
        System.out.println("Inventaris Toko:");
        if (jumlahBarang == 0) {
            System.out.println("Inventaris kosong.");
            return;
        }
        
        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println((i + 1) + ". " + inventaris[i].toString());
        }
    }
    
    public static void updateStok(String nama, int jumlahBaru) {
        boolean ditemukan = false;
        
        for (int i = 0; i < jumlahBarang; i++) {
            if (inventaris[i].getNama().equalsIgnoreCase(nama)) {
                inventaris[i].setJumlahStok(jumlahBaru);
                System.out.println("Stok barang '" + nama + "' berhasil diupdate menjadi " + jumlahBaru);
                ditemukan = true;
                break;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Barang dengan nama '" + nama + "' tidak ditemukan.");
        }
    }
    
    public static void cariBarang(String nama) {
        boolean ditemukan = false;
        
        System.out.println("Hasil pencarian:");
        for (int i = 0; i < jumlahBarang; i++) {
            if (inventaris[i].getNama().equalsIgnoreCase(nama)) {
                System.out.println(inventaris[i].toString());
                ditemukan = true;
                break;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Barang dengan nama '" + nama + "' tidak ditemukan dalam inventaris.");
        }
    }
    
    public static void tambahBarangBaru(Scanner scanner) {
        if (jumlahBarang >= inventaris.length) {
            System.out.println("Inventaris sudah penuh! Tidak dapat menambah barang baru.");
            return;
        }
        
        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();
        
        System.out.print("Masukkan jumlah stok: ");
        int stok = scanner.nextInt();
        
        System.out.print("Masukkan harga: ");
        double harga = scanner.nextDouble();
        
        inventaris[jumlahBarang] = new Barang(nama, stok, harga);
        jumlahBarang++;
        
        System.out.println("Barang '" + nama + "' berhasil ditambahkan ke inventaris!");
    }
}
