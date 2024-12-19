package org.example;
import org.apache.commons.lang3.StringUtils;

class App {
    public static void main(String[] args) {
        String text = "Hello, Mavennnnnnnnn!";
        String reversedText =StringUtils.reverse(text);
        System.out.println(reversedText);
    }
}