package cs544;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;
    private String ISBN;
    private String author;
    private double price;

    public Book() {
    }

    public Book( String title, String ISBN, String author,
                double price) {

        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
    }

    public Integer getId() {return id;}

    public String getTitle() {return title;}

    public String getISBN() {return ISBN;}

    public String getAuthor() {return author;}

    public double getPrice() {return price;}

    public void setId(Integer id) {this.id = id;}

    public void setTitle(String title) {this.title = title;}

    public void setISBN(String ISBN) {this.ISBN = ISBN;}

    public void setAuthor(String author) {this.author = author;}

    public void setPrice(double price) {this.price = price;}

    @Override
    public int hashCode() {
        return Objects.hash(id, title, ISBN, author, price);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
