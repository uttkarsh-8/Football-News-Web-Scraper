package com.footbalWebScraper.footbalWebScraper.repository;

import com.footbalWebScraper.footbalWebScraper.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
