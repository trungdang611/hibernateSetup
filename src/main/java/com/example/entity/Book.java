package com.example.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table( name = "books")
public class Book {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "book_id")
    private int bookId;

    @NotNull (message = "Book title cannot be empty!")
    @Size(min = 3, max = 50, message = "Book title must be between 3 to 50 characters long!")
    @Column( name = "title")
    private String bookTitle;

    @Column( name = "description")
    private String description;

    @DecimalMin( value = "0.0", inclusive = true, message = "The price must be greater than or equal to 0")
    @Column( name = "price")
    private double price;

    @Min( value = 0, message = "The quantity must be greater than or equal to 0!")
    @Column( name = "quantity")
    private int quantity;

    @NotNull ( message = "The published date cannot be empty")
    @PastOrPresent( message = "The published date must be in the past or the present!")
    @Column( name = "published_date", nullable = false)
    private LocalDate publishedDate;

    @NotNull( message = "The author of the book cannot be empty")
    @ManyToOne ( fetch = FetchType.LAZY )
    @JoinColumn ( name = "author_id")
    private Author author;

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", description=" + description + ", price=" + price
                + ", quantity=" + quantity + ", publishedDate=" + publishedDate + "]" + '\'';
    }
}
