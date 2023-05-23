package devmountain.group2.repositories;

import devmountain.group2.entities.AvailabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepository extends JpaRepository<AvailabilityEntity, Long>  {
}
