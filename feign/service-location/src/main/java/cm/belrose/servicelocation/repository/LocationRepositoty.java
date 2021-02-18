package cm.belrose.servicelocation.repository;

import cm.belrose.servicelocation.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepositoty extends JpaRepository<Location, Long> {
}
