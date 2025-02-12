package com.example.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "author_id")
    private int authorId;

    @NotNull ( message = "Author name cannot be empty!")
    @Size(min = 6, max = 50, message = "Author name must be between 6 and 50 characters long!")
    @Column( name = "author_name", length = 50, nullable = false )
    private String authorName;

    @NotNull ( message = "Years of experience cannot be empty!")
    @Min( value = 6, message = "Years of experience must be greater than or equal to 0!")
    @Column( name = "experience_years", nullable = false )
    private int experienceYears;

    @Column( name = "skills")
    private String skills;

    @Email( message = "Invalid email!")
    @Column( name = "email", length = 255)
    private String email;

    @OneToMany( mappedBy = "author", fetch = FetchType.LAZY )
    private List<Book> bookList;

    public Author(int authorId, String authorName, int experienceYears, String skills, String email) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.experienceYears = experienceYears;
        this.skills = skills;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author[" + authorId + ", " + authorName + ", "
                + experienceYears + ", " + skills + ", " + email + "]";
    }
}
