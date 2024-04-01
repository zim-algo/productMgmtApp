package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmApp {

    public static void main(String[] args) throws JsonProcessingException, ParseException {
        System.out.println("App start");

        Product[] products = new Product[3];


        products[0] = new Product("3128874119", "Banana","2023-01-24", 124, 0.55);
        products[1] = new Product("2927458265", "Apple", "2022-12-9", 18, 1.09);
        products[2] = new Product("9189927460", "Carrot","2023-03-31", 89, 2.99);

        printProducts(products);
    }

    public static void printProducts (Product[] products) throws JsonProcessingException {

        Arrays.stream(products).sorted(Comparator.comparing(Product::getName));

        printProductsJSON(products);
        printProductsXML(products);
        printProductsCSV(products);


    }

    public static void printProductsJSON(Product [] products) throws JsonProcessingException {

        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        for (Product product : products){
            System.out.println(writer.writeValueAsString(product));
        }

    }

    public static  void printProductsXML(Product [] products) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        System.out.println("<?xml=\"1.0\"?>");
        ObjectWriter writer = xmlMapper.writer().withRootName("products");
        for (Product product : products){
            System.out.println(writer.writeValueAsString(product));
        }
        System.out.println();
    }

    public static void printProductsCSV(Product [] products){
        System.out.println("productId, productName, price, quantity");
        for (Product product : products){
            System.out.println(product.getProductId() + "," + product.getName() + "," + product.getUnitPrice() + "," + product.getQuantityInStock() + "," + product.getDateSupplied());
        }
    }
}
