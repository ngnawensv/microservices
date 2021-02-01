package cm.belrose.servicearticle.repository;

import cm.belrose.servicearticle.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 *@author  Ngnawen Samuel
 * @Since  Le 24/01/2021
 */
@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
