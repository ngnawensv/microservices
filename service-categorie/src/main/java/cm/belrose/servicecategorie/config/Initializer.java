package cm.belrose.servicecategorie.config;


import cm.belrose.servicecategorie.model.Categorie;
import cm.belrose.servicecategorie.repository.CategorieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.*;


/**
 * Le 16/11/2020 à 09heures
 *
 * @author Ngnawen Samuel
 * <p>
 * Cette classe permet d'initialiser ma base de données avec quelques categories
 */
@Component
public class Initializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Initializer.class);

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Creation an default category ........
        List<Categorie> categories = new ArrayList<>();
        Categorie defaultCategorie = new Categorie("0000", "Default_cat");
        Categorie cat1 = new Categorie("code_cat1", "nom_cat1");
        Categorie cat2 = new Categorie("code_cat2", "nom_cat2");
        Categorie cat3 = new Categorie("code_cat3", "nom_cat3");
        Categorie cat4 = new Categorie("code_cat4", "nom_cat4");
        categories.add(defaultCategorie);
        categories.add(cat1);
        categories.add(cat2);
        categories.add(cat3);
        categories.add(cat4);
        categories.forEach(categorie -> {
            List<Categorie> categories_db=categorieRepository.findAll();
            if(categories_db.size()<5){
                categorieRepository.save(categorie);
                logger.info("Category save ===> "+categorie.getNom());
            }
            logger.info("Category "+categorie.getNom()+" already exist");
        });
    }
}
