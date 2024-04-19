package com.footbalWebScraper.footbalWebScraper.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String snippet;
    @Column
    private LocalDateTime publishedDate;


    public Article(String title, String url, String snippet, LocalDateTime publishedDate) {
        this.title = title;
        this.url = url;
        this.snippet = snippet;
        this.publishedDate = publishedDate; // This can be null
    }
}
