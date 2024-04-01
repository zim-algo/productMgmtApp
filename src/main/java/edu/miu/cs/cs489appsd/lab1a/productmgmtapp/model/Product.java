package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Product implements Comparable<Product>{
    private String productId;
    private String name;
    private Date dateSupplied;
    private int quantityInStock;
    private double unitPrice;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Product() {
    }

    public Product(String name, Date dateSupplied, int quantityInStock, double unitPrice) {
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product(String productId, String name, String dateSupplied, int quantityInStock, double unitPrice) throws ParseException {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = sdf.parse(dateSupplied);
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(Date dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", dateSupplied=" + dateSupplied +
                ", quantityInStock=" + quantityInStock +
                ", unitPrice=" + unitPrice +
                '}';
    }

    @Override
    public int compareTo(Product other) {
        return this.name.compareTo(other.name);
    }
}
