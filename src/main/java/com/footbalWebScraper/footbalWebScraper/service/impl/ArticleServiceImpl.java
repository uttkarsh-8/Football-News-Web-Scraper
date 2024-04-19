package com.footbalWebScraper.footbalWebScraper.service.impl;

import com.footbalWebScraper.footbalWebScraper.model.Article;
import com.footbalWebScraper.footbalWebScraper.repository.ArticleRepository;
import com.footbalWebScraper.footbalWebScraper.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }
}
