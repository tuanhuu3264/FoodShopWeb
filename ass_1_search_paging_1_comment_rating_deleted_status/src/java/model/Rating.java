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
public class Rating {
    int accountID, productID, star; 
    String username;
    String dateComment; 
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    String content; 

    public Rating(int accountID, int productID, int star, String username, String content, String dateComment) {
        this.accountID = accountID;
        this.productID = productID;
        this.star = star;
        this.username = username;
        this.content = content;
        this.dateComment = dateComment;
    }

    public Rating() {
    }
    

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateComment() {
        return dateComment;
    }

    public void setDateComment(String dateComment) {
        this.dateComment = dateComment;
    }
    
}
