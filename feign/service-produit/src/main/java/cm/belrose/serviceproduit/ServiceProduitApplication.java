package cm.belrose.serviceproduit;

import cm.belrose.serviceproduit.dto.LocationDto;
import cm.belrose.serviceproduit.model.Produit;
import cm.belrose.serviceproduit.repository.ProduitRepository;
import cm.belrose.serviceproduit.service.LocationServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceProduitApplication implements CommandLineRunner {

	@Autowired
	private LocationServiceProxy locationServiceProxy;
	@Autowired
	private ProduitRepository produitRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServiceProduitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LocationDto loc=locationServiceProxy.getLocation(1l);
        LocationDto loc1=locationServiceProxy.getLocation(2l);
		System.out.println("Location: "+loc);
        System.out.println("Location: "+loc1);
		Produit p=produitRepository.save(new Produit("Produit 1",loc.getId()));
        Produit p1=produitRepository.save(new Produit("Produit 2",loc.getId()));
        System.out.println("Produit: "+p);
        System.out.println("Produit: "+p1);
	}
}
