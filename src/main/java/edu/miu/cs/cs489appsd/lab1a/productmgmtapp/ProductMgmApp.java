package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmApp {

    public static void main(String[] args){
        System.out.println("App start");

        Product[] products = new Product[3];


        products[0] = new Product("3128874119", "Banana", LocalDate.of(2023,1, 24), 124, 0.55);
        products[1] = new Product("2927458265", "Apple", LocalDate.of(2022, 12, 9), 18, 1.09);
        products[2] = new Product("9189927460", "Carrot",LocalDate.of(2023, 3, 31), 89, 2.99);

        printProducts(products);
    }

    public static void printProducts (Product[] products){

        Arrays.stream(products).sorted(Comparator.comparing(Product::getName));

        printProductsJSON(products);
        printProductsXML(products);
        printProductsCSV(products);


    }

    public static void printProductsJSON(Product [] products) {
        System.out.println("[");
        for (Product product : products){
            System.out.println(product.toJson());
        }
        System.out.println("]");

    }

    public static  void printProductsXML(Product [] products){

        System.out.println("<?xml=\"1.0\"?>");
        System.out.println("<product>");
        for (Product product : products){
            System.out.println(product.toXML());
        }
        System.out.println("</product>");
    }

    public static void printProductsCSV(Product [] products){

        for (Product product : products){
            System.out.println(product.printCSV());
        }
    }
}
