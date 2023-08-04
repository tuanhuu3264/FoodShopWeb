/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tuan
 */
public class statusItem {
    private String name, imagePath, dateBy;
    private int quantity ,id, orderID;
    private double price, total;

    public statusItem() {
    }

    public statusItem(String name, String imagePath, String dateBy, int quantity, int id, int orderID, double price, double total) {
        this.name = name;
        this.imagePath = imagePath;
        this.dateBy = dateBy;
        this.quantity = quantity;
        this.id = id;
        this.orderID = orderID;
        this.price = price;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDateBy() {
        return dateBy;
    }

    public void setDateBy(String dateBy) {
        this.dateBy = dateBy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    
    
    
}
