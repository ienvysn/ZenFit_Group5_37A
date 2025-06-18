/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Niraj
 */

public class EquipmentData {
    private String name;
    private String type;
    private int quantity;
    private String purchaseDate;

    // Constructor
    public EquipmentData(String name, String type, int quantity, String purchaseDate) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public String getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }
}