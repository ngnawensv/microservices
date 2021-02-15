package cm.belrose.servicecategorie.controller;

import cm.belrose.servicecategorie.beans.ArticleBean;
import cm.belrose.servicecategorie.model.Categorie;
import cm.belrose.servicecategorie.proxy.MicroserviceArticleProxy;
import cm.belrose.servicecategorie.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private MicroserviceArticleProxy microserviceArticleProxy;

    @GetMapping("/categories/test")
    public String index(){
        return "Je suis dans service-catégorie";
    }


    @GetMapping("/categories")
    public List<Categorie> listeDesCategories(){
        List<Categorie> categories=categorieRepository.findAll();
        categories.forEach(System.out::println);
        return categories;
    }

    @GetMapping("/categories/produits")
    public List<ArticleBean> listeDesArticles(){
        System.out.println("Je suis dedans...........");
        List<ArticleBean> articleBeans=microserviceArticleProxy.listeDesArticles();
        articleBeans.forEach(System.out::println);
        return articleBeans;
    }
}
