package br.com.codeshare.microservices.articles.controllers;

import br.com.codeshare.microservices.articles.exception.ArticleNotFoundException;
import br.com.codeshare.microservices.articles.models.Article;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class ArticleController {

    private List<Article> articles;

    public ArticleController() {
        this.articles = new ArrayList<>();

        this.articles.add(new Article(1, "First Article", new Date(), 1));
        this.articles.add(new Article(2, "Second Article", new Date(), 2));
        this.articles.add(new Article(3, "Third Article", new Date(), 2));
        this.articles.add(new Article(4, "Fourth Article", new Date(), 1));
        this.articles.add(new Article(5, "Fifth Article", new Date(), 1));
    }

    @GetMapping(path = "/{id}")
    public Article findById(@PathVariable("id") Integer id) {
        log.info(String.format("Articles.findById(%d)", id));
        return this.articles.stream()
                .filter(article -> article.getId().intValue() == id.intValue())
                .findFirst()
                .orElseThrow(() -> new ArticleNotFoundException("id : " + id));
    }

    @GetMapping(path = "/author/{authorId}")
    public List<Article> findByAuthor(@PathVariable("authorId") final Integer authorId) {
        log.info(String.format("Articles.findByAuthor(%d)", authorId));
        return this.articles.stream().filter(article -> article.getAuthorId().intValue() == authorId.intValue()).collect(Collectors.toList());
    }

    @HystrixCommand(fallbackMethod = "getAllCached")
    @GetMapping(path = "/")
    public List<Article> getAll() {
        log.info("Articles.getAll()");
        return this.articles;
    }

    public List<Article> getAllCached() {
        log.info("Articles.getAllCached()");
        log.warn("Return cached result here");

        return new ArrayList<>();
    }
}
