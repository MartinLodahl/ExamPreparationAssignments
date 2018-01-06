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
public class EBook extends Book implements Serializable {


    private String downloadUrl;
    private double sizeMB;

    public EBook() {

    }

    public EBook(String downloadUrl, double sizeMB, String author, double price, String title) {
        this.downloadUrl = downloadUrl;
        this.sizeMB = sizeMB;
        setAuthor(author);
        setPrice(price);
        setTitle(title);

    }

    public EBook(String downloadUrl, double sizeMB, String author, double price, String title, long isbn) {
        this.downloadUrl = downloadUrl;
        this.sizeMB = sizeMB;
        setAuthor(author);
        setPrice(price);
        setTitle(title);
        setIsbn(isbn);
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getSizeMB() {
        return sizeMB;
    }

    public void setSizeMB(double sizeMB) {
        this.sizeMB = sizeMB;
    }

    @Override
    public String toString() {
        return "EBook{" + "isbn=" + getIsbn() + ", downloadUrl=" + downloadUrl + ", sizeMB=" + sizeMB + '}';
    }

}
