package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCountDTO {
    private String author;
    private Long count;

    @Override
    public String toString() {
        return "BookCountDTO{" +
                "author='" + author + '\'' +
                ", count=" + count +
                '}';
    }
}
