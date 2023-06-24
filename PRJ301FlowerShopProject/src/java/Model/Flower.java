/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class Flower {
    private String flowerId;
    private String flowerName;
    private String flowerDesc;
    private float flowerPrice;
    private String flowerImageUrl;
    private int flowerQuantity;

    public Flower() {
    }

    public Flower(String flowerId, String flowerName, String flowerDesc, float flowerPrice, String flowerImageUrl, int flowerQuantity) {
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.flowerDesc = flowerDesc;
        this.flowerPrice = flowerPrice;
        this.flowerImageUrl = flowerImageUrl;
        this.flowerQuantity = flowerQuantity;
    }

    public String getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(String flowerId) {
        this.flowerId = flowerId;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getFlowerDesc() {
        return flowerDesc;
    }

    public void setFlowerDesc(String flowerDesc) {
        this.flowerDesc = flowerDesc;
    }

    public float getFlowerPrice() {
        return flowerPrice;
    }

    public void setFlowerPrice(float flowerPrice) {
        this.flowerPrice = flowerPrice;
    }

    public String getFlowerImageUrl() {
        return flowerImageUrl;
    }

    public void setFlowerImageUrl(String flowerImageUrl) {
        this.flowerImageUrl = flowerImageUrl;
    }

    public int getFlowerQuantity() {
        return flowerQuantity;
    }

    public void setFlowerQuantity(int flowerQuantity) {
        this.flowerQuantity = flowerQuantity;
    }
    
}
