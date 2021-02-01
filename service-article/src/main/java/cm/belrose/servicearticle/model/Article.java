package cm.belrose.servicearticle.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 *
 *@author  Ngnawen Samuel
 * @Since  Le 23/01/2021
 */

@Entity
public class Article  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_article")
    private Long id;
    @Column(name = "nom_article")
    private String nom;
    @Column(name = "prix_achat_article")
    private double prixAchat;
    @Column(name = "prix_vente_article")
    private double prixVente;
    @Column(name = "quantite_article")
    private double quantite;


    public Article() {
    }

    public Article(String nom, double prixAchat, double prixVente, double quantite) {
        this.nom = nom;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.quantite = quantite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

}
