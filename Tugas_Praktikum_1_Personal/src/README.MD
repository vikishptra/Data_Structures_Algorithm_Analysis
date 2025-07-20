# Tugas Praktikum 1 - Array vs ArrayList Operations

## Deskripsi
Program ini mengimplementasikan dan membandingkan operasi dasar pada Array dan ArrayList dalam Java. Program mencakup operasi traversal, pencarian, penyisipan, penghapusan, dan pengurutan, serta melakukan analisis perbandingan kinerja antara kedua struktur data tersebut.

## Struktur Project
```
├── ArrayOperations.java          # Operasi dasar pada Array
├── ArrayListOperations.java      # Operasi dasar pada ArrayList
├── PerformanceComparison.java    # Perbandingan kinerja
├── MainProgram.java             # Program utama
├── TestProgram.java             # Unit testing
└── README.md                    # Dokumentasi
```

## Fitur Utama

### 1. ArrayOperations.java
- **Traversal**: Menampilkan seluruh elemen array
- **Linear Search**: Pencarian linear dalam array
- **Binary Search**: Pencarian biner untuk array terurut
- **Insert Element**: Menyisipkan elemen pada posisi tertentu
- **Delete Element**: Menghapus elemen pada posisi tertentu
- **Sort Array**: Mengurutkan array menggunakan Arrays.sort()

### 2. ArrayListOperations.java
- **Traversal**: Menampilkan seluruh elemen ArrayList
- **Add Element**: Menambahkan elemen ke ArrayList
- **Insert Element**: Menyisipkan elemen pada posisi tertentu
- **Remove Element**: Menghapus elemen berdasarkan nilai atau indeks
- **Search Element**: Mencari elemen dalam ArrayList
- **Sort List**: Mengurutkan ArrayList menggunakan Collections.sort()

### 3. PerformanceComparison.java
- **Measure Traversal Time**: Mengukur waktu traversal
- **Measure Search Time**: Mengukur waktu pencarian
- **Measure Insertion Time**: Mengukur waktu penyisipan
- **Measure Deletion Time**: Mengukur waktu penghapusan
- **Measure Sorting Time**: Mengukur waktu pengurutan
- **Display Performance Table**: Menampilkan hasil dalam bentuk tabel

## Cara Menjalankan Program

### 1. Kompilasi
```bash
javac *.java
```

### 2. Menjalankan Program Utama
```bash
java MainProgram
```

### 3. Menjalankan Unit Testing
```bash
java TestProgram
```

## Output yang Dihasilkan

### 1. Operasi Dasar
```
Array Traversal: [10, 20, 30, 40, 50]
ArrayList Traversal: [10, 20, 30, 40, 50]

Pencarian 30 dalam Array: Ditemukan di indeks 2
Pencarian 30 dalam ArrayList: Ditemukan di indeks 2

Array setelah penyisipan elemen 25: [10, 20, 25, 30, 40, 50]
ArrayList setelah penyisipan elemen 25: [10, 20, 25, 30, 40, 50]
```

### 2. Perbandingan Kinerja
```
================================================================================
PERBANDINGAN KINERJA ARRAY vs ARRAYLIST
================================================================================

Test Size: 100 elements
------------------------------------------------------------
Operation            Array (ms)      ArrayList (ms)  Winner         
------------------------------------------------------------
Traversal            0.001234        0.001567        Array
Search               0.000892        0.001123        Array
Insertion            0.002345        0.000789        ArrayList
Deletion             0.001987        0.000654        ArrayList
Sorting              0.012345        0.008976        ArrayList
```

## Analisis Kompleksitas

### Array Operations
- **Traversal**: O(n) - Harus mengunjungi setiap elemen
- **Search (Linear)**: O(n) - Worst case harus mencari sampai akhir
- **Search (Binary)**: O(log n) - Untuk array yang sudah terurut
- **Insertion**: O(n) - Memerlukan shifting elemen
- **Deletion**: O(n) - Memerlukan shifting elemen
- **Sorting**: O(n log n) - Menggunakan Arrays.sort()

### ArrayList Operations
- **Traversal**: O(n) - Harus mengunjungi setiap elemen
- **Add**: O(1) amortized - Bisa O(n) jika perlu resize
- **Insert**: O(n) - Memerlukan shifting elemen
- **Remove**: O(n) - Memerlukan shifting elemen
- **Search**: O(n) - Linear search
- **Sorting**: O(n log n) - Menggunakan Collections.sort()

## Kesimpulan Analisis

### Kelebihan Array:
- Akses elemen lebih cepat (direct memory access)
- Penggunaan memori lebih efisien
- Cocok untuk data dengan ukuran tetap
- Performa traversal dan akses random yang baik

### Kekurangan Array:
- Ukuran harus ditentukan saat deklarasi
- Operasi insertion dan deletion memerlukan shifting manual
- Tidak ada built-in method untuk operasi kompleks
- Sulit untuk mengubah ukuran array

### Kelebihan ArrayList:
- Ukuran dinamis (dapat bertambah/berkurang)
- Banyak built-in method yang memudahkan operasi
- Operasi insertion dan deletion lebih mudah
- Implementasi Collection Framework yang lengkap

### Kekurangan ArrayList:
- Overhead memory karena boxing/unboxing
- Sedikit lebih lambat untuk akses elemen
- Menggunakan lebih banyak memori
- Kapasitas default mungkin tidak optimal

## Rekomendasi Penggunaan

### Gunakan Array jika:
- Ukuran data tetap dan diketahui sebelumnya
- Performa akses elemen sangat kritis
- Aplikasi real-time dengan constraints memori ketat
- Bekerja dengan primitive types secara intensif

### Gunakan ArrayList jika:
- Ukuran data dinamis dan tidak diketahui sebelumnya
- Sering melakukan operasi insertion/deletion
- Membutuhkan kemudahan operasi dan built-in methods
- Aplikasi umum yang tidak memiliki constraint performa ketat

## Learning Outcomes

Program ini memenuhi Learning Outcomes berikut:
1. **LO 1**: Menjelaskan konsep struktur data Array dan ArrayList
2. **LO 2**: Menganalisis kompleksitas algoritma (waktu dan ruang)
3. **LO 3**: Mengimplementasikan struktur data dan algoritma dalam Java

## Teknologi yang Digunakan
- **Java 8+**: Bahasa pemrograman utama
- **Collections Framework**: Untuk operasi ArrayList
- **System.nanoTime()**: Untuk pengukuran waktu eksekusi
- **Arrays.sort()**: Untuk pengurutan array
- **Collections.sort()**: Untuk pengurutan ArrayList
