package cm.belrose.serviceproduit.model;

import cm.belrose.serviceproduit.dto.LocationDto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nom_produit")
    private String produitName;
    @Column(name = "location_id")
    private Long locationId;
    @Transient
    private LocationDto location;
    @Transient
    private List<LocationDto> locations;

    public Produit() {
    }

    public Produit(String produitName) {
        this.produitName = produitName;
    }

    public Produit(String produitName, LocationDto location) {
        this.produitName = produitName;
        this.location = location;
    }

    public Produit(String produitName, Long locationId) {
        this.produitName = produitName;
        this.locationId = locationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getProduitName() {
        return produitName;
    }

    public void setProduitName(String produitName) {
        this.produitName = produitName;
    }
    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public LocationDto getLocation() {
        return location;
    }

    public List<LocationDto> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationDto> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", produitName='" + produitName + '\'' +
                ", locationId=" + locationId +
                ", location=" + location +
                ", locations=" + locations +
                '}';
    }
}
