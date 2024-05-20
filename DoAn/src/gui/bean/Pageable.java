/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.bean;

import java.util.List;

/**
 *
 * @author Yuuta
 * @param <T>
 */
public class Pageable<T> {

    private List<T> contents;
    private int totals;

    private Pageable() {
    }

    public Pageable(List<T> contents, int totals) {
        this.contents = contents;
        this.totals = totals;
    }

    public List<T> getContents() {
        return contents;
    }

    public int getTotals() {
        return totals;
    }

}
