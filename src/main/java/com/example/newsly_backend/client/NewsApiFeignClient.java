package com.example.newsly_backend.client;

import com.example.newsly_backend.config.NewsFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "newsApiClient",
        url = "https://newsapi.org/v2",
        configuration = NewsFeignConfig.class
)
public interface NewsApiFeignClient {
    @GetMapping("/everything")
    String getEverything(
            @RequestParam("q") String query,
            @RequestParam("apiKey") String apiKey
    );
}
