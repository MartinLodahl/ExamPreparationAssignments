/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author MartinLodahl
 */
@Entity
public class PaperBook extends Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long isbn;

    private double shippingWeight;
    private boolean inStock;

    public PaperBook() {

    }

    public PaperBook(double shippingWeight, boolean inStock, String author, double price, String title) {
        this.shippingWeight = shippingWeight;
        this.inStock = inStock;
        setAuthor(author);
        setPrice(price);
        setTitle(title);
    }

    public double getShippingWeight() {
        return shippingWeight;
    }

    public void setShippingWeight(double shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "entity.PaperBook[ id=" + isbn + " ]";
    }
}
