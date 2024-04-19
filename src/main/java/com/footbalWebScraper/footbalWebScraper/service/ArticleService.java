package com.footbalWebScraper.footbalWebScraper.service;

import com.footbalWebScraper.footbalWebScraper.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    Article saveArticle(Article article);
}
