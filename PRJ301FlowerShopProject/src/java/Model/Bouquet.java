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
    private int bouquetType;
    private String bouquetDesc;
    private float bouquetPrice;
    private float bouquetDiscount;
    private String bouquetImageUrl;
    private int bouquetQuantity;
    private boolean displayed;

    public Bouquet() {
    }

    public Bouquet(String bouquetId, String bouquetName, int bouquetType, String bouquetDesc, float bouquetPrice, float bouquetDiscount, String bouquetImageUrl, int bouquetQuantity, boolean displayed) {
        this.bouquetId = bouquetId;
        this.bouquetName = bouquetName;
        this.bouquetType = bouquetType;
        this.bouquetDesc = bouquetDesc;
        this.bouquetPrice = bouquetPrice;
        this.bouquetDiscount = bouquetDiscount;
        this.bouquetImageUrl = bouquetImageUrl;
        this.bouquetQuantity = bouquetQuantity;
        this.displayed = displayed;
    }

    public boolean isDisplayed() {
        return displayed;
    }

    public void setDisplayed(boolean displayed) {
        this.displayed = displayed;
    }

    public int getBouquetType() {
        return bouquetType;
    }

    public void setBouquetType(int bouquetType) {
        this.bouquetType = bouquetType;
    }

    public String getBouquetId() {
        return bouquetId;
    }

    public void setBouquetId(String bouquetId) {
        this.bouquetId = bouquetId;
    }

    public String getBouquetName() {
        return bouquetName;
    }

    public void setBouquetName(String bouquetName) {
        this.bouquetName = bouquetName;
    }

    public String getBouquetDesc() {
        return bouquetDesc;
    }

    public void setBouquetDesc(String bouquetDesc) {
        this.bouquetDesc = bouquetDesc;
    }

    public float getBouquetPrice() {
        return bouquetPrice;
    }

    public void setBouquetPrice(float bouquetPrice) {
        this.bouquetPrice = bouquetPrice;
    }

    public float getBouquetDiscount() {
        return bouquetDiscount;
    }

    public void setBouquetDiscount(float bouquetDiscount) {
        this.bouquetDiscount = bouquetDiscount;
    }

    public String getBouquetImageUrl() {
        return bouquetImageUrl;
    }

    public void setBouquetImageUrl(String bouquetImageUrl) {
        this.bouquetImageUrl = bouquetImageUrl;
    }

    public int getBouquetQuantity() {
        return bouquetQuantity;
    }

    public void setBouquetQuantity(int bouquetQuantity) {
        this.bouquetQuantity = bouquetQuantity;
    }
}