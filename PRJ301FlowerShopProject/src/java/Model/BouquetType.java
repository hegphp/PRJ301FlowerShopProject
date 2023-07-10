/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class BouquetType {
    private int bouquetTypeId;
    private String bouquetTypeName;

    public BouquetType() {
    }

    public BouquetType(int bouquetTypeId, String bouquetTypeName) {
        this.bouquetTypeId = bouquetTypeId;
        this.bouquetTypeName = bouquetTypeName;
    }

    public int getBouquetTypeId() {
        return bouquetTypeId;
    }

    public void setBouquetTypeId(int bouquetTypeId) {
        this.bouquetTypeId = bouquetTypeId;
    }

    public String getBouquetTypeName() {
        return bouquetTypeName;
    }

    public void setBouquetTypeName(String bouquetTypeName) {
        this.bouquetTypeName = bouquetTypeName;
    }
    
}
