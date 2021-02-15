package cm.belrose.servicearticle.controllers;

import cm.belrose.servicearticle.model.Article;
import cm.belrose.servicearticle.repository.ArticleRepository;
import cm.belrose.servicearticle.services.CategorieServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/full/{id}")
    Article getArtcle(@PathVariable("id") Long id) {
        Article article = articleRepository.getOne(id);
        System.out.println(" Article retourné: " + article);
        //article.setCategorie(categorieServiceClient.findCategorieById(article.getId()));
        return article;
    }

    @GetMapping("/articles")
    public List<Article> getArtcles() {
        return articleRepository.findAll();

    }
}
