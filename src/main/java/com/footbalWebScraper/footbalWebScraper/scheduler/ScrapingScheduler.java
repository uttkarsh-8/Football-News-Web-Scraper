package com.footbalWebScraper.footbalWebScraper.scheduler;

import com.footbalWebScraper.footbalWebScraper.model.Article;
import com.footbalWebScraper.footbalWebScraper.service.ArticleService;
import com.footbalWebScraper.footbalWebScraper.service.EmailService;
import com.footbalWebScraper.footbalWebScraper.service.ScrapingService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScrapingScheduler {

    private final ScrapingService scrapingService;
    private final ArticleService articleService;
    private final EmailService emailService;

    public ScrapingScheduler(ScrapingService scrapingService, ArticleService articleService, EmailService emailService) {
        this.scrapingService = scrapingService;
        this.articleService = articleService;
        this.emailService = emailService;
    }

    @Scheduled(fixedRate = 43200000)
    public void scrapeAndNotify(){
        List<Article> articles = scrapingService.scrapeArticles();
        articles.forEach(articleService::saveArticle);

        String content = articles.stream()
                .map(article -> article.getTitle()+"- Read more at: " + article.getUrl())
                .collect(Collectors.joining("\n\n"));

        if (!articles.isEmpty()) {
            emailService.sendEmail("uttu.sri@outlook.com", "Latest Manchester United Articles", content);
        }
    }
}
