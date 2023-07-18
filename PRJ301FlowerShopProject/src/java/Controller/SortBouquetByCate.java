/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Bouquet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Lenovo
 */
public class SortBouquetByCate extends HttpServlet {

    static ArrayList<Bouquet> sortName(ArrayList<Bouquet> bouquetList, int i) {
        Collections.sort(bouquetList, new Comparator<Bouquet>() {
            @Override
            public int compare(Bouquet o1, Bouquet o2) {
                //Acending
                if(i==0){
                    return o1.getBouquetName().compareTo(o2.getBouquetName());
                }else{
                    if(o1.getBouquetName().compareTo(o2.getBouquetName())>0){
                        return -1;
                    }else if(o1.getBouquetName().compareTo(o2.getBouquetName())<0){
                        return 1;
                    }else
                        return 0;
                }
            }
        });
        return bouquetList;
    }

    static ArrayList<Bouquet> sortId(ArrayList<Bouquet> bouquetList, int i) {
        Collections.sort(bouquetList, new Comparator<Bouquet>() {
            @Override
            public int compare(Bouquet o1, Bouquet o2) {
                //Acending
                if(i==0){
                    return o1.getBouquetId().compareTo(o2.getBouquetId());
                }else{
                    if(o1.getBouquetId().compareTo(o2.getBouquetId())>0){
                        return -1;
                    }else if(o1.getBouquetId().compareTo(o2.getBouquetId())<0){
                        return 1;
                    }else
                        return 0;
                }
            }
        });
        return bouquetList;
    }

    static ArrayList<Bouquet> sortType(ArrayList<Bouquet> bouquetList, int i) {
        Collections.sort(bouquetList, new Comparator<Bouquet>() {
            @Override
            public int compare(Bouquet o1, Bouquet o2) {
                //Acending
                if(i==0){
                    if(o1.getBouquetType()>o2.getBouquetType()){
                        return 1;
                    }else if(o1.getBouquetType()<o2.getBouquetType()){
                        return -1;
                    }else{
                        return 0;
                    }
                }else{
                    if(o1.getBouquetType()>o2.getBouquetType()){
                        return -1;
                    }else if(o1.getBouquetType()<o2.getBouquetType()){
                        return 1;
                    }else
                        return 0;
                }
            }
        });
        return bouquetList;
    }

    static ArrayList<Bouquet> sortPrice(ArrayList<Bouquet> bouquetList, int i) {
        Collections.sort(bouquetList, new Comparator<Bouquet>() {
            @Override
            public int compare(Bouquet o1, Bouquet o2) {
                //Acending
                if(i==0){
                    if(o1.getBouquetPrice()>o2.getBouquetPrice()){
                        return 1;
                    }else if(o1.getBouquetPrice()<o2.getBouquetPrice()){
                        return -1;
                    }else{
                        return 0;
                    }
                }else{
                    if(o1.getBouquetPrice()>o2.getBouquetPrice()){
                        return -1;
                    }else if(o1.getBouquetPrice()<o2.getBouquetPrice()){
                        return 1;
                    }else
                        return 0;
                }
            }
        });
        return bouquetList;
    }

    static ArrayList<Bouquet> sortDiscount(ArrayList<Bouquet> bouquetList, int i) {
        Collections.sort(bouquetList, new Comparator<Bouquet>() {
            @Override
            public int compare(Bouquet o1, Bouquet o2) {
                //Acending
                if(i==0){
                    if(o1.getBouquetDiscount()>o2.getBouquetDiscount()){
                        return 1;
                    }else if(o1.getBouquetDiscount()<o2.getBouquetDiscount()){
                        return -1;
                    }else{
                        return 0;
                    }
                }else{
                    if(o1.getBouquetDiscount()>o2.getBouquetDiscount()){
                        return -1;
                    }else if(o1.getBouquetDiscount()<o2.getBouquetDiscount()){
                        return 1;
                    }else
                        return 0;
                }
            }
        });
        return bouquetList;
    }

    static ArrayList<Bouquet> sortQuantity(ArrayList<Bouquet> bouquetList, int i) {
        Collections.sort(bouquetList, new Comparator<Bouquet>() {
            @Override
            public int compare(Bouquet o1, Bouquet o2) {
                //Acending
                if(i==0){
                    if(o1.getBouquetQuantity()>o2.getBouquetQuantity()){
                        return 1;
                    }else if(o1.getBouquetQuantity()<o2.getBouquetQuantity()){
                        return -1;
                    }else{
                        return 0;
                    }
                }else{
                    if(o1.getBouquetQuantity()>o2.getBouquetQuantity()){
                        return -1;
                    }else if(o1.getBouquetQuantity()<o2.getBouquetQuantity()){
                        return 1;
                    }else
                        return 0;
                }
            }
        });
        return bouquetList;
    }

    static ArrayList<Bouquet> sortDisplayed(ArrayList<Bouquet> bouquetList, int i) {
        Collections.sort(bouquetList, new Comparator<Bouquet>() {
            @Override
            public int compare(Bouquet o1, Bouquet o2) {
                //Acending
                if(i==0){
                    return Boolean.compare(o1.isDisplayed(), o2.isDisplayed());
                }else{
                    if(Boolean.compare(o1.isDisplayed(), o2.isDisplayed())>0){
                        return -1;
                    }else if(Boolean.compare(o1.isDisplayed(), o2.isDisplayed())<0){
                        return 1;
                    }else
                        return 0;
                }
            }
        });
        return bouquetList;
    }
}
