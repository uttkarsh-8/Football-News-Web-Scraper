package com.footbalWebScraper.footbalWebScraper.controller;

import com.footbalWebScraper.footbalWebScraper.model.Article;
import com.footbalWebScraper.footbalWebScraper.service.ArticleService;
import com.footbalWebScraper.footbalWebScraper.service.ScrapingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final ScrapingService scrapingService;

    public ArticleController(ArticleService articleService, ScrapingService scrapingService) {
        this.articleService = articleService;
        this.scrapingService = scrapingService;
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @PostMapping("/scrape")
    public List<Article> scrapeAndSaveArticles() {
        List<Article> articles = scrapingService.scrapeArticles();
        articles.forEach(article -> articleService.saveArticle(article));

        return articles;
    }
}

