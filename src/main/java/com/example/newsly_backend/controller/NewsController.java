package com.example.newsly_backend.controller;

import com.example.newsly_backend.client.NewsApiFeignClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*")
public class NewsController {
    private final NewsApiFeignClient newsApiClient;

    @Value("${newsapi.key}")
    private String apiKey;

    public NewsController(NewsApiFeignClient newsApiClient) {
        this.newsApiClient = newsApiClient;
    }

    @GetMapping
    public String getNews(@RequestParam String q) {
        return newsApiClient.getEverything(q, apiKey);
    }
}
