package ua.library.pak.Library.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private String author;
    private String dateOfRelease;
    private String tag;
    private String description;
    private int countOfPages;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }

    public Book() {
    }

    public Book(String name, String author, String dateOfRelease, String tag, String description, int countOfPages, String text) {
        this.name = name;
        this.author = author;
        this.dateOfRelease = dateOfRelease;
        this.tag = tag;
        this.description = description;
        this.countOfPages = countOfPages;
        this.text = text;
    }
}
