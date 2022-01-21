package com.example.demo.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlParser {
    public static String htmlTagRemove(String rawPageText) {
        Document parsedDoc = Jsoup.parse(rawPageText);
        return parsedDoc.text();
    }
}
