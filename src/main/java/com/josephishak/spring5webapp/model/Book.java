package com.josephishak.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String publisher;
    private String ibsn;

    @ManyToMany
    @JoinTable(name = "author_book",joinColumns = @JoinColumn(name="book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<Author>();


    public Book(String title, String publisher, String ibsn) {
        this.title = title;
        this.publisher = publisher;
        this.ibsn = ibsn;
    }

    public Book(String title, String publisher, String ibsn, Set<Author> authors) {
        this.title = title;
        this.publisher = publisher;
        this.ibsn = ibsn;
        this.authors = authors;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIbsn() {
        return ibsn;
    }

    public void setIbsn(String ibsn) {
        this.ibsn = ibsn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
