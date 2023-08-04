/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tuan
 */
public class Cart {
   public List<Products> product;

    public Cart() {
        product = new ArrayList<>();
    }

    public Cart(List<Products> product) {
        this.product = product;
    }

    public List<Products> getProduct() {
        return product;
    }

    public void setProduct(List<Products> product) {
        this.product = product;
    }
    private Products getProductByid(int id){
        for (Products products : product) {
            if(products.getItem().getId()==id){
                return products;
            }
        }
        return null;
    }
    public int getQuantityByid(int id){
        return getProductByid(id).getQuantity();
    }
    public void addProduct(Products product){
        if(getProductByid(product.getItem().getId())!=null){
            Products p = getProductByid(product.getItem().getId());
            p.setQuantity(p.getQuantity()+product.getQuantity());
        }
        else{
            this.product.add(product);
        }
    }
    public void removeProduct(int id){
        if(getProductByid(id)!=null){
            product.remove(getProductByid(id));
        }
    }
    public double getTotalMoney(){
        double t = 0;
        for (Products p : product) {
            t+=p.getQuantity()*p.getPrice();
        }
        return t;
    }
    public int getTotalQuantity(){
        int t = 0;
        for (Products p : product) {
            t+=p.getQuantity();
        }
        return t;
    }
}
