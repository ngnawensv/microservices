package cm.belrose.servicecategorie.repository;

import cm.belrose.servicecategorie.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 *
 *@author  Ngnawen Samuel
 * @since  23/01/2021 21:48:00
 *
 */
@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    Categorie findByNom(String nom);

}
