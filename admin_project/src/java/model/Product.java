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
public class Product {
    int id;
    String name, description,imagepath;
    double price;  
    int IdCategory;
    int status;
    public Product(int id, String name, String description, String imagepath, double price, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagepath = imagepath;
        this.price = price;
        this.status = status;
    }


    public Product(int id, String name, String imagepath, double price) {
        this.id = id;
        this.name = name;
        this.imagepath = imagepath;
        this.price = price;
    }

    public Product(String name, String description, String imagepath, double price, int IdCategory, int status) {
        this.name = name;
        this.description = description;
        this.imagepath = imagepath;
        this.price = price;
        this.IdCategory = IdCategory;
        this.status = status;
    }

    public Product() {
    }
   
    public Product(int id, String name, String description, String imagepath, double price, int IdCategory, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagepath = imagepath;
        this.price = price;
        this.IdCategory = IdCategory;
        this.status = status;
    }

    public Product(int id, String name, String imageP, double price, String des, int categoryId, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getIdCategory() {
        return IdCategory;
    }

    public void setIdCategory(int IdCategory) {
        this.IdCategory = IdCategory;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
 

    
}
