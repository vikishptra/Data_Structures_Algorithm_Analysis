package kelompok_assignment;



import java.util.Scanner;


class Book {
    private String title;
    private String author;
    private boolean isAvailable;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    
    // Getter methods
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    
    // Setter methods
    public void setAvailable(boolean available) { this.isAvailable = available; }
    
    @Override
    public String toString() {
        return "Judul: " + title + ", Pengarang: " + author + 
               ", Status: " + (isAvailable ? "Tersedia" : "Dipinjam");
    }
}

abstract class User {
    protected String name;
    protected String userId;
    
    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }
    
    // Getter methods
    public String getName() { return name; }
    public String getUserId() { return userId; }
    
    // Abstract method untuk POLYMORPHISM
    public abstract void interact(LibrarySystem library);
    
    // Method umum yang bisa digunakan semua user
    public void displayInfo() {
        System.out.println("Nama: " + name + ", ID: " + userId);
    }
}




class Admin extends User {
    
    public Admin(String name, String userId) {
        super(name, userId);
    }
    
    // POLYMORPHISM - Override method interact
    @Override
    public void interact(LibrarySystem library) {
        Scanner scanner = new Scanner(System.in);
        boolean continueAdmin = true;
        
        while (continueAdmin) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Lihat Semua Buku");
            System.out.println("4. Cari Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    addBook(library, scanner);
                    break;
                case 2:
                    removeBook(library, scanner);
                    break;
                case 3:
                    library.displayAllBooks();
                    break;
                case 4:
                    searchBook(library, scanner);
                    break;
                case 5:
                    continueAdmin = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    // Method khusus admin untuk menambah buku
    private void addBook(LibrarySystem library, Scanner scanner) {
        System.out.print("Masukkan judul buku: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan pengarang: ");
        String author = scanner.nextLine();
        
        library.addBook(new Book(title, author));
        System.out.println("Buku berhasil ditambahkan!");
    }
    
    // Method khusus admin untuk menghapus buku
    private void removeBook(LibrarySystem library, Scanner scanner) {
        System.out.print("Masukkan judul buku yang akan dihapus: ");
        String title = scanner.nextLine();
        
        if (library.removeBook(title)) {
            System.out.println("Buku berhasil dihapus!");
        } else {
            System.out.println("Buku tidak ditemukan!");
        }
    }
    
    // Method untuk mencari buku
    private void searchBook(LibrarySystem library, Scanner scanner) {
        System.out.print("Masukkan judul buku yang dicari: ");
        String title = scanner.nextLine();
        
        Book book = library.searchBook(title);
        if (book != null) {
            System.out.println("Buku ditemukan: " + book);
        } else {
            System.out.println("Buku tidak ditemukan!");
        }
    }
}


class Member extends User {
    
    public Member(String name, String userId) {
        super(name, userId);
    }
    
    // POLYMORPHISM - Override method interact
    @Override
    public void interact(LibrarySystem library) {
        Scanner scanner = new Scanner(System.in);
        boolean continueMember = true;
        
        while (continueMember) {
            System.out.println("\n=== MENU MEMBER ===");
            System.out.println("1. Lihat Buku Tersedia");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Cari Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    borrowBook(library, scanner);
                    break;
                case 3:
                    returnBook(library, scanner);
                    break;
                case 4:
                    searchBook(library, scanner);
                    break;
                case 5:
                    continueMember = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    // Method untuk meminjam buku
    private void borrowBook(LibrarySystem library, Scanner scanner) {
        System.out.print("Masukkan judul buku yang ingin dipinjam: ");
        String title = scanner.nextLine();
        
        if (library.borrowBook(title)) {
            System.out.println("Buku berhasil dipinjam!");
        } else {
            System.out.println("Buku tidak tersedia atau tidak ditemukan!");
        }
    }
    
    // Method untuk mengembalikan buku
    private void returnBook(LibrarySystem library, Scanner scanner) {
        System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
        String title = scanner.nextLine();
        
        if (library.returnBook(title)) {
            System.out.println("Buku berhasil dikembalikan!");
        } else {
            System.out.println("Buku tidak ditemukan atau sudah tersedia!");
        }
    }
    
    // Method untuk mencari buku
    private void searchBook(LibrarySystem library, Scanner scanner) {
        System.out.print("Masukkan judul buku yang dicari: ");
        String title = scanner.nextLine();
        
        Book book = library.searchBook(title);
        if (book != null) {
            System.out.println("Buku ditemukan: " + book);
        } else {
            System.out.println("Buku tidak ditemukan!");
        }
    }
}


class LibrarySystem {
    private Book[] books;
    private int bookCount;
    private final int MAX_BOOKS = 100;
    
    public LibrarySystem() {
        books = new Book[MAX_BOOKS];
        bookCount = 0;
    }
    
    // OPERASI ARRAY: Menambah buku
    public void addBook(Book book) {
        if (bookCount < MAX_BOOKS) {
            books[bookCount] = book;
            bookCount++;
        } else {
            System.out.println("Perpustakaan sudah penuh!");
        }
    }
    
    // OPERASI ARRAY: Menghapus buku berdasarkan judul
    public boolean removeBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                // Shift elemen ke kiri untuk mengisi ruang kosong
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[bookCount - 1] = null;
                bookCount--;
                return true;
            }
        }
        return false;
    }
    
    // OPERASI ARRAY: Mencari buku berdasarkan judul
    public Book searchBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }
    
    // Menampilkan semua buku
    public void displayAllBooks() {
        System.out.println("\n=== DAFTAR SEMUA BUKU ===");
        if (bookCount == 0) {
            System.out.println("Tidak ada buku di perpustakaan.");
            return;
        }
        
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
    }
    
    // Menampilkan buku yang tersedia
    public void displayAvailableBooks() {
        System.out.println("\n=== DAFTAR BUKU TERSEDIA ===");
        boolean hasAvailable = false;
        
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                System.out.println((i + 1) + ". " + books[i]);
                hasAvailable = true;
            }
        }
        
        if (!hasAvailable) {
            System.out.println("Tidak ada buku yang tersedia.");
        }
    }
    
    // Meminjam buku
    public boolean borrowBook(String title) {
        Book book = searchBook(title);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }
    
    // Mengembalikan buku
    public boolean returnBook(String title) {
        Book book = searchBook(title);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);
        
        // Inisialisasi beberapa buku untuk testing
        library.addBook(new Book("Java Programming", "Oracle"));
        library.addBook(new Book("Data Structures", "Robert Lafore"));
        library.addBook(new Book("Algorithms", "Thomas Cormen"));
        library.addBook(new Book("Object Oriented Programming", "Grady Booch"));
        
        System.out.println("=== SELAMAT DATANG DI SISTEM PERPUSTAKAAN ===");
        
        boolean continueProgram = true;
        while (continueProgram) {
            System.out.println("\n=== LOGIN SISTEM ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Member");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama admin: ");
                    String adminName = scanner.nextLine();
                    System.out.print("Masukkan ID admin: ");
                    String adminId = scanner.nextLine();
                    
                    Admin admin = new Admin(adminName, adminId);
                    admin.displayInfo();
                    admin.interact(library); // POLYMORPHISM
                    break;
                    
                case 2:
                    System.out.print("Masukkan nama member: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Masukkan ID member: ");
                    String memberId = scanner.nextLine();
                    
                    Member member = new Member(memberName, memberId);
                    member.displayInfo();
                    member.interact(library); // POLYMORPHISM
                    break;
                    
                case 3:
                    continueProgram = false;
                    System.out.println("Terima kasih telah menggunakan sistem perpustakaan!");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        
        scanner.close();
    }
}