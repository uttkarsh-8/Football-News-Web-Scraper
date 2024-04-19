package com.footbalWebScraper.footbalWebScraper.service;

import com.footbalWebScraper.footbalWebScraper.model.Article;

import java.util.List;

public interface ScrapingService {
    List<Article> scrapeArticles();
}
