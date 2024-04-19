package com.footbalWebScraper.footbalWebScraper.service.impl;

import com.footbalWebScraper.footbalWebScraper.model.Article;
import com.footbalWebScraper.footbalWebScraper.service.ScrapingService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScrapingServiceImpl implements ScrapingService {

    public static final String BASE_URL = "https://www.skysports.com/manchester-united";

    @Override
    public List<Article> scrapeArticles() {
        List<Article> articles = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(BASE_URL).get();
            Elements links = doc.select("a.news-list__headline-link");
            Elements snippets = doc.select("p.news-list__snippet");

            for (int i = 0; i < links.size(); i++) {
                Element link = links.get(i);
                String title = link.text();
                String url = link.absUrl("href");

                String snippet = i < snippets.size() ? snippets.get(i).text() : null;

                articles.add(new Article(title, url, snippet, null));
            }
        } catch (IOException e) {
            e.printStackTrace();  // Proper error handling should be added
        }
        return articles;
    }
}

