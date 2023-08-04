/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class Order_Items {
    int orderID; 
    Product product; 
    int quantity; 

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    double total;
    public Order_Items(int orderID, Product product, int quantity) {
        this.orderID = orderID;
        this.product = product;
        this.quantity = quantity;
        this.total= product.getPrice()*quantity;
    }
    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
