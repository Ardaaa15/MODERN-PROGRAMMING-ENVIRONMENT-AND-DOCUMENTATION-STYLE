package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ini adalah kelas menu item
 */

public class MenuItem {
    private String name;
    private double price;

    /**
     * ini adalah method menu item / constructor
     * @param name nama item / daftar menu
     * @param price harga item / harga menu
     */

    public MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

    /**
     * ini adalah method grtName
     * @return
     */

    public String getName() {
        return name;
    }

    /**
     * ini adalah method getPrice
     * @return
     */

    public double getPrice() {
        return price;
    }
}




