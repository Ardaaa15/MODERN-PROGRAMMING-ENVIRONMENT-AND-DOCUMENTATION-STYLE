package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Kelas untuk item menu di restoran
class MenuItem {
    private String nama;
    private double harga;

    public MenuItem(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}

// Kelas untuk item pesanan
class OrderItem {
    private MenuItem menuItem;
    private int kuantitas;

    public OrderItem(MenuItem menuItem, int kuantitas) {
        this.menuItem = menuItem;
        this.kuantitas = kuantitas;
    }

    public double hitungHargaTotal() {
        return menuItem.getHarga() * kuantitas;
    }

    public String getDetail() {
        return menuItem.getNama() + " x" + kuantitas + " = Rp " + hitungHargaTotal();
    }
}

// Kelas untuk nota pemesanan
public class NotaPemesanan {
    private List<OrderItem> daftarPesanan = new ArrayList<>();

    // Metode untuk menambah item pesanan
    public void tambahPesanan(MenuItem menuItem, int kuantitas) {
        OrderItem orderItem = new OrderItem(menuItem, kuantitas);
        daftarPesanan.add(orderItem);
    }

    // Metode untuk menghitung total seluruh pesanan menggunakan Stream API
    public double hitungTotalPesanan() {
        return daftarPesanan.stream()
                .mapToDouble(OrderItem::hitungHargaTotal)
                .sum();
    }

    // Metode untuk menampilkan nota
    public void tampilkanNota() {
        System.out.println("===== NOTA PEMESANAN =====");
        for (OrderItem item : daftarPesanan) {
            System.out.println(item.getDetail());
        }
        System.out.printf("Total Harga: Rp %.2f%n", hitungTotalPesanan());
        System.out.println("==========================");
    }

    // Metode untuk menampilkan menu
    private void tampilkanMenu(MenuItem nasiGoreng, MenuItem mieAyam, MenuItem esTeh) {
        System.out.println("Pilih Menu:");
        System.out.println("1. " + nasiGoreng.getNama() + " - Rp " + nasiGoreng.getHarga());
        System.out.println("2. " + mieAyam.getNama() + " - Rp " + mieAyam.getHarga());
        System.out.println("3. " + esTeh.getNama() + " - Rp " + esTeh.getHarga());
    }

    // Metode untuk memproses input pengguna
    private void prosesInput(Scanner input, MenuItem nasiGoreng, MenuItem mieAyam, MenuItem esTeh) {
        while (true) {
            System.out.print("Masukkan nomor menu (0 untuk selesai): ");
            int pilihan = input.nextInt();
            if (pilihan == 0) break;

            System.out.print("Masukkan kuantitas: ");
            int kuantitas = input.nextInt();

            switch (pilihan) {
                case 1 -> tambahPesanan(nasiGoreng, kuantitas);
                case 2 -> tambahPesanan(mieAyam, kuantitas);
                case 3 -> tambahPesanan(esTeh, kuantitas);
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Simulasi menu dengan variabel yang lebih deskriptif
        MenuItem nasiGoreng = new MenuItem("Nasi Goreng", 20000);
        MenuItem mieAyam = new MenuItem("Mie Ayam", 15000);
        MenuItem esTeh = new MenuItem("Es Teh", 5000);

        NotaPemesanan nota = new NotaPemesanan();

        // Tampilkan menu dan proses input
        nota.tampilkanMenu(nasiGoreng, mieAyam, esTeh);
        nota.prosesInput(input, nasiGoreng, mieAyam, esTeh);

        // Menampilkan nota
        nota.tampilkanNota();
    }
}
