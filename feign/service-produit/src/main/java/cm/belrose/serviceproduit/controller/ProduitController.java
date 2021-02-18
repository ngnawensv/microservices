package cm.belrose.serviceproduit.controller;

import cm.belrose.serviceproduit.dto.LocationDto;
import cm.belrose.serviceproduit.model.Produit;
import cm.belrose.serviceproduit.repository.ProduitRepository;
import cm.belrose.serviceproduit.service.LocationServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProduitController {

    @Autowired
    private LocationServiceProxy locationServiceProxy;
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(value = "/produit/{id}", produces = "application/json")
    public Produit getProduit(@PathVariable("id") Long id){
        Produit p=produitRepository.findById(id).get();
        LocationDto locationDto=locationServiceProxy.getLocation(p.getLocationId());
        p.setLocation(locationDto);
        return  p;
    }

    @GetMapping(value = "/produits", produces = "application/json")
    public Produit getProduit1(){
        List<LocationDto> locationsDto=locationServiceProxy.getAllLocation();
        Produit p=produitRepository.findById(1l).get();
        p.setLocations(locationsDto);
        return  p;
    }
}
