/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class Bouquet {
    private String bouquetId;
    private String bouquetName;
    private String desc;
    private String price;
    private String discount;
    private String imageUrl;
    private String quantity;
    private String bouquetTypeId;

    public Bouquet() {
    }

    public Bouquet(String bouquetId, String bouquetName, String desc, String price, String discount, String imageUrl, String quantity, String bouquetTypeId) {
        this.bouquetId = bouquetId;
        this.bouquetName = bouquetName;
        this.desc = desc;
        this.price = price;
        this.discount = discount;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.bouquetTypeId = bouquetTypeId;
    }
    
}
