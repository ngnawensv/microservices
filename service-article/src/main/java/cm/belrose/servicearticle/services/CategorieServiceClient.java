package cm.belrose.servicearticle.services;

import cm.belrose.servicearticle.dto.Categorie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "service-categorie") //specification du service  à appelé
public interface CategorieServiceClient {

    @GetMapping(name = "/categories/{id}?projection=fullCategorie")
    Categorie findCategorieById(@PathVariable("id") Long id);

    @GetMapping(name = "/categories?projection=fullCategorie")
    List<Categorie> findAll();

}
