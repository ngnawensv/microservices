package cm.belrose.servicelocation.controller;

import cm.belrose.servicelocation.model.Location;
import cm.belrose.servicelocation.repository.LocationRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LocationController {

    @Autowired
    private LocationRepositoty locationRepositoty;

    @GetMapping(value = "/location/{id}", produces = "application/json")
    public Location getLocation(@PathVariable("id") Long id){
        return locationRepositoty.findById(id).get();
    }

    @GetMapping(value = "/locations", produces = "application/json")
    public List<Location> getAllLocation(){
        return locationRepositoty.findAll();
    }
}
