package cm.belrose.servicecategorie.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *@author  Ngnawen Samuel
 * @since  23/01/2021 21:48:00
 *
 */
@Entity
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_categorie")
    private String code;

    @Column(name = "nom_categorie")
    private String nom;

    public Categorie() {
    }

    public Categorie(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
