package cm.belrose.servicelocation;

import cm.belrose.servicelocation.model.Location;
import cm.belrose.servicelocation.repository.LocationRepositoty;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceLocationApplication implements CommandLineRunner {

	@Autowired
	private LocationRepositoty locationRepositoty;

	public static void main(String[] args) {
		SpringApplication.run(ServiceLocationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Location location=new Location("Maroua",11l,"Rue 1");
		Location location1=new Location("Garoua",222l,"Rue 2");
		locationRepositoty.save(location);
		locationRepositoty.save(location1);
	}
}
