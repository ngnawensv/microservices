package cm.belrose.serviceproduit.service;

import cm.belrose.serviceproduit.dto.LocationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "service-location")
public interface LocationServiceProxy {
    @GetMapping(value = "/api/v1/location/{id}",produces = "application/json")
    LocationDto getLocation(@PathVariable("id") Long id);

    @GetMapping(value = "/api/v1/locations",produces = "application/json")
    List<LocationDto> getAllLocation();
}
