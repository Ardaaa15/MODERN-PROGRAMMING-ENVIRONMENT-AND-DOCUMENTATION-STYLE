package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * ini adalah kelas order
 */

public class Order {
    private List<MenuItem> items;
    private double total;

    /**
     * ini adalah method order
     */

    public Order() {
        items = new ArrayList<>();
        total = 0.0;
    }

    /**
     * ini adalah method add item
     * @param item
     */

    public void addItem(MenuItem item) {
        items.add(item);
        total += item.getPrice();
    }

    /**
     * ini adalah method get total
     * @return
     */

    public double getTotal() {
        return total;
    }

    /**
     * ini adalah method print nota pemesanan
     */

    public void printReceipt() {
        System.out.println("=== Nota Pemesanan ===");
        for (MenuItem item : items) {
            System.out.println(item.getName() + " - " + item.getPrice());
        }
        System.out.println("-----------------------");
        System.out.println("Total: " + getTotal());
    }
}
