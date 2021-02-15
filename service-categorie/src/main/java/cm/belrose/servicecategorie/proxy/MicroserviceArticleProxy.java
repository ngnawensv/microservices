package cm.belrose.servicecategorie.proxy;

import cm.belrose.servicecategorie.beans.ArticleBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @FeignClient  déclare cette interface comme client Feign.
 * Feign utilisera les informations fournies ici pour construire les requêtes HTTP appropriées
 * afin d'appeler le service-article.
 */
@FeignClient(name ="service-article",url = "localhost:8082")
public interface MicroserviceArticleProxy {

    @GetMapping(value = "/articles")
    List<ArticleBean> listeDesArticles();

    @GetMapping( value = "/article/{id}")
    ArticleBean recupererUnArticle(@PathVariable("id") int id);

}
