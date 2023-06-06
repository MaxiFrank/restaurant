package devmountain.group2.repositories;

import devmountain.group2.entities.AvailabilityEntity;
import devmountain.group2.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long>  {
}
