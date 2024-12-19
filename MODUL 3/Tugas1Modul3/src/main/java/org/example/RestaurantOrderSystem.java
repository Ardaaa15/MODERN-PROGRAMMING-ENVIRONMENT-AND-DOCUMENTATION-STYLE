package org.example;

import java.util.Scanner;

/**
 * ini adalah kelas restauran order sistem
 */
public class RestaurantOrderSystem {
    private static MenuItem[] menu = {
            new MenuItem("Nasi Goreng", 20000),
            new MenuItem("Mie Goreng", 18000),
            new MenuItem("Ayam Penyet", 25000),
            new MenuItem("Sate", 22000),
            new MenuItem("Es Teh", 5000)
    };

    /**
     *ini adalah method main, untuk menjalankan program
     * @param args
     */

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Order order = new Order();

            System.out.println("=== Menu Restoran ===");
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i].getName() + " - " + menu[i].getPrice());
            }

            while (true) {
                System.out.print("Pilih menu (nomor) atau ketik 0 untuk selesai: ");
                int choice = scanner.nextInt();
                if (choice == 0) {
                    break;
                }
                if (choice > 0 && choice <= menu.length) {
                    order.addItem(menu[choice - 1]);
                    System.out.println(menu[choice - 1].getName() + " ditambahkan ke pesanan.");
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            }

        order.printReceipt();
        scanner.close();
    }
}
