package com.example.demo.controller;


import com.example.demo.model.HtmlParser;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@AllArgsConstructor
public class URLController {

    @PostMapping("/target_url")
    String newPageTextBody(@RequestBody String newUrl) {

        WebClient client = WebClient.create();

        String strPageText = client.get().uri(newUrl).retrieve().bodyToMono(String.class).block();

        try {
            if (strPageText.trim().isBlank())
                strPageText = "PageIsBlank";
        } catch (NullPointerException ex) {
            strPageText = "PageIsNull";
        }

        strPageText = HtmlParser.htmlTagRemove(strPageText);
        return strPageText;
    }
}
