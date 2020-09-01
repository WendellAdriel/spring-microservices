package br.com.codeshare.microservices.articles.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article {

    private Integer id;
    private String name;
    private Date publishDate;
    private Integer authorId;

}
